package com.a3fun.learn.java.match;

import java.util.List;

public class MatchResult {
    List<Player> redTeam;
    List<Player> blueTeam;

    public MatchResult(List<Player> redTeam, List<Player> blueTeam) {
        this.redTeam = redTeam;
        this.blueTeam = blueTeam;
    }
}
