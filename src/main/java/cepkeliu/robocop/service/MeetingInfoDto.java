package cepkeliu.robocop.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MeetingInfoDto {

    private String winner;

    private BigDecimal cost;

    private List<String> players;
    
    private boolean wonBeMe;

    public MeetingInfoDto() {
        this.players = new ArrayList<String>();
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(final String winner) {
        this.winner = winner;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(final BigDecimal cost) {
        this.cost = cost;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(final List<String> players) {
        this.players = players;
    }

    public boolean isWonBeMe() {
        return wonBeMe;
    }

    public void setWonBeMe(boolean wonBeMe) {
        this.wonBeMe = wonBeMe;
    }
}
