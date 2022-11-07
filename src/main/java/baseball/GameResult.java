package baseball;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class GameResult {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private Map<String, Integer> counts;

    GameResult() {
        counts = new TreeMap<>();
    }

    public void init() {
        counts.clear();
    }

    public void compare(List<Integer> computer, List<Integer> user) {
        counts.put(BALL, countBalls(computer, user));
        counts.put(STRIKE, countStrikes(computer, user));
    }

    public int getBallCount() {
        return counts.getOrDefault(BALL, 0);
    }

    public int getStrikeCount() {
        return counts.getOrDefault(STRIKE, 0);
    }

    public boolean isThreeStrike() {
        return counts.getOrDefault(STRIKE, 0).equals(3);
    }

    @Override
    public String toString() {
        List<String> results = new ArrayList<>();
        for (String key : counts.keySet()) {
            if (counts.get(key) == 0) {
                continue;
            }
            results.add(counts.get(key) + key);
        }
        if (results.isEmpty()) {
            return "낫싱";
        }
        return String.join(" ", results);
    }

    private int countBalls(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                continue;
            }
            if (computer.contains(user.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    private int countStrikes(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                count += 1;
            }
        }
        return count;
    }
}
