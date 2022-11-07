package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Application {

    private static Map<State, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        resultMap.clear();
        List<Integer> computerNumbers = new ArrayList<>();
        makeRandomNumbers(computerNumbers);
        List<Integer> playerNumbers = IOUtil.getNumbersFromPlayer();
        calculate(computerNumbers, playerNumbers);
    }

    public static void makeRandomNumbers(List<Integer> computerNumbers) {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public static void calculate(List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < computer.size(); i++) {
           if (Objects.equals(computer.get(i), player.get(i))) {
               insertResultToMap(State.STRIKE);
           }
           else if ( player.contains(computer.get(i))) {
               insertResultToMap(State.BALL);
           }
           else {
               insertResultToMap(State.NOTHING);
           }
        }
    }

    private static void insertResultToMap(State state) {
        if ( !resultMap.containsKey(state) ) {
            resultMap.put(state, 1);
        }
        else {
            resultMap.put(state, resultMap.get(state) + 1);
        }
    }

    public static Map<State, Integer> getResultMap() {
        return resultMap;
    }
}
