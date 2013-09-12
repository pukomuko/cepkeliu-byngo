package cepkeliu.robocop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cepkeliu.robocop.model.Meeting;
import cepkeliu.robocop.model.Player;

@Service
public class GameService extends BaseService {

    public static Map<Integer, String> map;

    static {
        map = new HashMap<Integer, String>();

        map.put(1, "Pasitempikim");
        map.put(2, "Reikia pasistengti");
        map.put(3, "Įgyvendinom planą");
        map.put(4, "Ambicingi planai");
        map.put(5, "Klientų pasitenkinimas");
        map.put(6, "Dideli įkainiai");
        map.put(7, "Kadangi");
        map.put(8, "Nepaisant");
        map.put(9, "Sausainis prie kavos");
        map.put(10, "Etika");
        map.put(11, "Kokybiškai");
        map.put(12, "Laiku");
        map.put(13, "Daugiau negu prašo");
        map.put(14, "Fiksuotos kainos projektai");
        map.put(15, "Panaceja");
        map.put(16, "Kliento poreikiai");
        map.put(17, "Testavimas");
        map.put(18, "ES pinigai");
        map.put(19, "Pasiūlymas");
        map.put(20, "Realizacija");
        map.put(21, "Nebuvo lengva");
        map.put(22, "Debėsys");
        map.put(23, "Konkurentai");
        map.put(24, "Užsakovas");
        map.put(25, "Blogas klientas");
        map.put(26, "Pasitikėjimas");
        map.put(27, "Projekto apimtis");
        map.put(28, "Viešas sektorius ");
        map.put(29, "Eksportas ");
        map.put(30, "Privatus sektorius");
        map.put(31, "Susiveržkim diržus");
        map.put(32, "Sveikatos draudimas");
        map.put(33, "Kavos aparatas");
        map.put(34, "Renginiai");
        map.put(35, "Mokymai");
        map.put(36, "Rezultatai");
        map.put(37, "Nedžiugina");
        map.put(38, "Noriu pabrėžti");
        map.put(39, "Integracija");
        map.put(40, "Susitikimas");
        map.put(41, "Augimas");
        map.put(42, "Vėliava");
        map.put(43, "Pristatymas");
        map.put(44, "Strategija");
        map.put(45, "Pardavimai");
        map.put(46, "Studentai");
        map.put(47, "Nortal-LAB");
        map.put(48, "Nortal");
        map.put(49, "Stalo futbolas");
        map.put(50, "Steeringas");
        map.put(51, "Komanda");
        map.put(52, "Ekonominė situacija");
        map.put(53, "Dėmesys");
        map.put(54, "Terminas");
        map.put(55, "Pinigai");
        map.put(56, "Tikslai");
        map.put(57, "Apimtis");
        map.put(58, "Lūkesčiai");
        map.put(59, "Palaikymas");
        map.put(60, "Sprendimas");
        map.put(61, "Koncentruotis");
        map.put(62, "Vertė");
        map.put(63, "Resursai");
        map.put(64, "Panaudoti");
        map.put(65, "Mobillios aplikacijos");
        map.put(66, "Telefonas");
        map.put(67, "Planšetė");
        map.put(68, "Lemputė");
        map.put(69, "Vadovai");
        map.put(70, "Specialistai");
        map.put(71, "JIRA");
        map.put(72, "Confluence");
        map.put(73, "Ataskaita");
        map.put(74, "Raportuoti");
        map.put(75, "Nepasiteisino");
        map.put(76, "Pavyko");
        map.put(77, "Užtikrinti");
        map.put(78, "Sėkmė");
        map.put(79, "Atsigauna");
        map.put(80, "Rinka");
        map.put(81, "Naujas ofisas");
        map.put(82, "Gyvename");
        map.put(83, "Apyvarta");
        map.put(84, "Pelnas");
        map.put(85, "Rizika");
        map.put(86, "Galimybė");
        map.put(87, "Striprybė");
        map.put(88, "Silpnybė");
        map.put(89, "Verslas");
        map.put(90, "Institucijos");
        map.put(91, "Įsisavinti");
        map.put(92, "Politinė situacija");
        map.put(93, "Nurašyti");
        map.put(94, "Atsisakyti");
        map.put(95, "Laimėti");
        map.put(96, "Pasiskirstymas");
        map.put(97, "Projektas");
        map.put(98, "Įdiegti");
        map.put(99, "Mobili versija");
        map.put(100, "Motyvacija");
        map.put(101, "Technologijos");
        map.put(102, "Konferencija");
        map.put(103, "Viskas bus gerai");
        map.put(104, "Ne taip gerai kaip tikėjomės");
        map.put(105, "Padirbėti savaitgalį");
        map.put(106, "Klientas nežino ko nori");
        map.put(107, "Reikės šiek tiek perdaryti");
        map.put(108, "Nebaigta analizė");
        map.put(109, "Bug'as nepasiduoda");
        map.put(110, "Bugovas produktas");
        map.put(111, "Neapsiversim per galvą");
        map.put(112, "Neįdomu");
        map.put(113, "Iššūkiai");
        map.put(114, "Taskas");
        map.put(115, "Investicija");
        map.put(116, "Prisijungti");
        map.put(117, "Užduotis");
        map.put(118, "Gerai");
        map.put(119, "Blogai");
        map.put(120, "Patenkinamai");
        map.put(121, "Puikiai");
        map.put(122, "Įvairovė");
        map.put(123, "Feisbukas");
        map.put(124, "Naudotojo sąsaja");
        map.put(125, "Daugiapakopis mechanizmas");
        map.put(126, "Buvo");
        map.put(127, "Yra");
        map.put(128, "Apkrovos testas");
        map.put(129, "Pasidžiaugti");
        map.put(130, "Sąnaudos");
        map.put(131, "Patirtis");
        map.put(132, "Tačiau");
        map.put(133, "Nepaisant to");
        map.put(134, "Dauguma");
        map.put(135, "Keli");
        map.put(136, "Reikalavimas");
    }
    
    public Iterator<String> randomPhrases() {
        List<String> rnd = new ArrayList<String>();
        Random r = new Random();
        
        for (int i = 0; i < 20; i++) {
            rnd.add(map.get(1 + r.nextInt(map.size())));
        }
        return rnd.iterator();
    }

    public List<String> getPhraseTexts() {
        return new ArrayList<String>(map.values());
    }

    private static BigDecimal calculateCost(final int persons, final Date startDate) {
        long milis = new Date().getTime() - startDate.getTime();
        
        return new BigDecimal(milis)
                .divide(new BigDecimal(3600000L), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(persons))
                .multiply(new BigDecimal(140L))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Transactional(readOnly = true)
    public MeetingInfoDto getGameInfo(final Long meetingId) {
        MeetingInfoDto info = new MeetingInfoDto();

        Meeting meeting = getById(meetingId, Meeting.class);

        for (Player player : meeting.getPlayers()) {
            info.getPlayers().add(player.getName());
        }
        info.setWinner(null);
        info.setCost(calculateCost(meeting.getPlayers().size(), meeting.getCreatedOn()));
        info.setWinner(meeting.getWinner());
        info.setWonBeMe(false);

        return info;
    }
    
    public static boolean solveMatrix(final int[][] matrix) {
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            int colSum = 0;

            diag1 = diag1 + matrix[i][i];
            diag2 = diag2 + matrix[i][matrix.length - i - 1];
            for (int j = 0; j < matrix.length; j++) {
                rowSum = rowSum + matrix[i][j];
                colSum = colSum + matrix[j][i];
            }
            if (rowSum == matrix.length || colSum == matrix.length) {
                return true;
            }
        }
        return (diag1 == matrix.length) || (diag2 == matrix.length);
    }

    public boolean solveWinner(final Map<String, Boolean> cellMap) {
        int[][] matrix = new int[4][4];
        for (Entry<String, Boolean> entry : cellMap.entrySet()) {
            int x = entry.getKey().replace("cell", "").charAt(0) - '0' - 1;
            int y = entry.getKey().replace("cell", "").charAt(1) - '0' - 1;
            matrix[x][y] = entry.getValue() ? 1 : 0;
        }
        return solveMatrix(matrix);
    }

    @Transactional
    public void closeMeeting(final Long id, final String winner) {
        Meeting meeting = getById(id, Meeting.class);
        meeting.setWinner(winner);
        save(meeting, Meeting.class);
    }
}
