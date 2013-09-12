package cepkeliu.robocop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cepkeliu.robocop.model.Meeting;
import cepkeliu.robocop.model.Player;

@Service
public class MeetingsService extends BaseService {

    @Transactional(readOnly = true)
    public List<Meeting> getAll() {
        return em.createQuery("from Meeting where winner is null order by createdOn desc", Meeting.class)
                .setMaxResults(10)
                .getResultList();
    }
    
    @Transactional 
    public Long createNewMeeting(final String meetingName, final String playerName) {

        Meeting meeting = new Meeting();
        meeting.setCreatedOn(new Date());
        meeting.setName(meetingName);

        Player player = new Player();
        player.setName(playerName);
        meeting.setPlayers(new ArrayList<Player>());
        meeting.getPlayers().add(player);

        save(meeting, Meeting.class);
        return meeting.getId();
    }

    @Transactional
    public Long attachPlayerToMeeting(final Long meetingId, final String playerName) {

        Meeting meeting = getById(meetingId, Meeting.class);

        if (meeting.getPlayers() == null) {
            meeting.setPlayers(new ArrayList<Player>());
        }
        Player player = new Player();
        player.setName(playerName);
        meeting.getPlayers().add(player);

        save(meeting, Meeting.class);
        return meeting.getId();
    }
}
