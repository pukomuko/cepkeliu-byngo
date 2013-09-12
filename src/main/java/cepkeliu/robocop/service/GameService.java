package cepkeliu.robocop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public List<String> getPhraseTexts() {
        return new ArrayList<String>(map.values());
    }

    @Transactional(readOnly = true)
    public List<String> getPlayers(final Long meetingId) {
        Meeting meeting = getById(meetingId, Meeting.class);

        List<String> result = new ArrayList<String>();
        for (Player player : meeting.getPlayers()) {
            result.add(player.getName());
        }

        return result;
    }
}
