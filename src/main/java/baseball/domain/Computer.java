package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MAX_SIZE_OF_NUMBER = 3;
    private static final int DOES_NOT_EXIST = -1;
    private static final String NOTHING = "";
    List<String> computersNumber = new ArrayList<>();

    public Computer() {
        while (computersNumber.size() < MAX_SIZE_OF_NUMBER) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersNumber.contains(String.valueOf(pickedNumber))) {
                computersNumber.add(computersNumber.size(), String.valueOf(pickedNumber));
            }
        }
    }

    public String getResultMessage(List<String> playersNumber) {
        String result = "";
        Map<String, Integer> strikeBallMap = compareWithNumberOfPlayer(playersNumber);
        boolean haveBallCount = strikeBallMap.getOrDefault("볼", 0) != 0;
        boolean haveStrikeCount = strikeBallMap.getOrDefault("스트라이크", 0) != 0;
        if (haveBallCount) {
            result += (strikeBallMap.get("볼") + "볼 ");
        }
        if (haveStrikeCount) {
            result += (strikeBallMap.get("스트라이크") + "스트라이크");
        }
        if (result.equals(NOTHING)) {
            result = "낫싱";
        }
        return result;
    }

    public Map<String, Integer> compareWithNumberOfPlayer(List<String> playersNumber) {
        Map<String, Integer> strikeBallMap = new HashMap<>();
        for (String numberOfPlayer : playersNumber) {
            int indexOfComputersNumber = computersNumber.indexOf(numberOfPlayer);
            int indexOfPlayersNumber = playersNumber.indexOf(numberOfPlayer);
            if (indexOfComputersNumber == DOES_NOT_EXIST) {
                continue;
            }
            if (indexOfComputersNumber == indexOfPlayersNumber) {
                strikeBallMap.put("스트라이크", strikeBallMap.getOrDefault("스트라이크", 0) + 1);
            }
            if (indexOfComputersNumber != indexOfPlayersNumber) {
                strikeBallMap.put("볼", strikeBallMap.getOrDefault("볼", 0) + 1);
            }
        }

        return strikeBallMap;
    }
}
