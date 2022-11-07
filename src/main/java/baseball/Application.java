package baseball;

import static baseball.State.*;
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
        IOUtil.printStartMessage();
        List<Integer> computerNumbers = new ArrayList<>();
        makeRandomNumbers(computerNumbers);
        System.out.println(computerNumbers);
        List<Integer> playerNumbers = IOUtil.getNumbersFromPlayer();
        calculate(computerNumbers, playerNumbers);
        IOUtil.printMapToConsole(resultMap);

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
               insertResultToMap(STRIKE);
           }
           else if ( player.contains(computer.get(i))) {
               insertResultToMap(BALL);
           }
           else {
               insertResultToMap(NOTHING);
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
