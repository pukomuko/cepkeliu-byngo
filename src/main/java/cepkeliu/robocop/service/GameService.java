package cepkeliu.robocop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cepkeliu.robocop.model.Meeting;
import cepkeliu.robocop.model.Player;

@Service
public class GameService extends BaseService {

    public static Map<Integer, String> map;

    private static String[] phrases = {
            "Vertė",
            "Augimas",
            "Didinimas",
            "Nortal",
            "Byngo",
            "Paslauga",
            "Vystyti",
            "Plėsti",
            "Plėtra",
            "Regionas",
            "Nacionalinis",
            "Tarptautinis",
            "Augti",
            "Industrija ",
            "Rinka",
            "Užkariauti",
            "Pasalis",
            "Ateitis",
            "Svarbu",
            "Įdomus",
            "Šalis",
            "Specialistas",
            "Ekspertas",
            "Sparčiai",
            "Aplenkti",
            "Pavyti",
            "Naujas",
            "Idėja",
            "Senas",
            "Klientas ",
            "Užsakovas",
            "Aktuali",
            "Problema",
            "Viešas sektorius",
            "Biurokratas",
            "Auditorija",
            "Privatus sektorius",
            "Pasitenkinimas",
            "Lūkesčiai",
            "Sausainis prie kavos",
            "Sprendimas",
            "Pakeisti",
            "Pergalė",
            "Laimėjimas",
            "Pasistenkim",
            "Padirbkim savaitgalį",
            "Mobili aplikacija",
            "Technologija",
            "Motyvacija",
            "Ne taip gerai kaip tikėjomės",
            "Ambicingi planai",
    };
    
    public Iterator<String> randomPhrases() {
        Random r = new Random();

        Set<String> result = new HashSet<String>();

        while (result.size() < 18) {
            result.add(phrases[r.nextInt(phrases.length)]);
        }
      
        return result.iterator();
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
        info.setCost(calculateCost(meeting.getPlayers().size(), meeting.getCreatedOn()));
        info.setWinner(meeting.getWinner());
        info.setWonByMe(false);

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
