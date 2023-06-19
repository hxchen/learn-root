package com.a3fun.learn.java.match;

import java.util.*;

public class Matchmaking {
    public static List<MatchResult> matchPlayers(LinkedList<Player> players, int groupSize) {
        // 按照玩家战力进行升序排序
        Collections.sort(players, Comparator.comparingInt(p -> p.power));

        List<MatchResult> results = new ArrayList<>();
        int totalPlayers = players.size();
        int numGroups = totalPlayers / (2 * groupSize);

        // 分组
        for (int i = 0; i < numGroups; i++) {
            List<Player> redTeam = new ArrayList<>();
            List<Player> blueTeam = new ArrayList<>();

            // 从排序后的玩家列表中依次选取玩家加入红蓝队伍
            for (int j = 0; j < groupSize; j++) {
                if (j%2 == 0){
                    redTeam.add(players.removeFirst());
                    blueTeam.add(players.removeFirst());
                }else{
                    blueTeam.add(players.removeFirst());
                    redTeam.add(players.removeFirst());
                }

            }

            results.add(new MatchResult(redTeam, blueTeam));
        }

        return results;
    }

    public static void main(String[] args) {
        // 示例用法
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player(1, 100));
        players.add(new Player(2, 80));
        players.add(new Player(3, 90));
        players.add(new Player(4, 110));
        players.add(new Player(5, 95));
        players.add(new Player(6, 85));
        players.add(new Player(7, 115));
        players.add(new Player(8, 75));

        List<MatchResult> results = Matchmaking.matchPlayers(players, 2);

        // 输出匹配结果
        for (int i = 0; i < results.size(); i++) {
            MatchResult result = results.get(i);
            System.out.println("Group " + (i + 1) + ":");
            System.out.println("Red Team: " + result.redTeam);
            System.out.println("Blue Team: " + result.blueTeam);
            System.out.println();
        }
    }

}
