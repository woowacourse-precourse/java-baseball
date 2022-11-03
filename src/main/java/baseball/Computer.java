package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<String> computersNumber = new ArrayList<>();

    public Computer() {
        while (computersNumber.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersNumber.contains(String.valueOf(pickNumber))) {
                computersNumber.add(computersNumber.size(), String.valueOf(pickNumber));
            }
        }
    }

    public String compareWithNumberOfPlayer(List<String> playersNumber) {
        Map<String, Integer> strikeBallMap = new HashMap<>();
        String result = "";
        for (String numberOfPlayer : playersNumber) {
            int indexOfComputersNumber = computersNumber.indexOf(numberOfPlayer);
            int indexOfPlayersNumber = playersNumber.indexOf(numberOfPlayer);
            if (indexOfComputersNumber == -1) {
                continue;
            }
            if (indexOfComputersNumber == indexOfPlayersNumber) {
                strikeBallMap.put("스트라이크", strikeBallMap.getOrDefault("스트라이크", 0) + 1);
            } else {
                strikeBallMap.put("볼", strikeBallMap.getOrDefault("볼", 0) + 1);
            }
        }

        if (strikeBallMap.getOrDefault("볼", 0) != 0) {
            result = result + (strikeBallMap.get("볼") + "볼 ");
        }
        if (strikeBallMap.getOrDefault("스트라이크", 0) != 0) {
            result = result + (strikeBallMap.get("스트라이크") + "스트라이크");
        }
        if (!strikeBallMap.containsKey("볼") && !strikeBallMap.containsKey("스트라이크")) {
            result = result + "낫싱";
        }

        return result;
    }
}
