package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {

    private static Map<String, Integer> strikeAndBallCounter;
    public static void main(String[] args) {
        initializerOfStrikeAndBallCounter();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = createRandomThreeDigitNum();

    }

    static void initializerOfStrikeAndBallCounter() {
        strikeAndBallCounter = new LinkedHashMap<>();
        strikeAndBallCounter.put("strike", 0);
        strikeAndBallCounter.put("ball", 0);
    }

    static List<Integer> createRandomThreeDigitNum() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
