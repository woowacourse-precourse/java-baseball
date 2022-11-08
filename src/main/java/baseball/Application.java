package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continueGame = true;
        while (continueGame) {
            List<Integer> randomValue = getRandomValue();
            playGame(randomValue);
        }
    }

    private static void playGame(List<Integer> randomValue) {
        boolean success = true;
        while (success) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = readLine();

            HashMap<String, Integer> ballStrikeNum = initializeBallStrikePoint();

        }
    }

    private static HashMap<String, Integer> initializeBallStrikePoint() {
        HashMap<String, Integer> ballStrikeNum = new HashMap<>();
        ballStrikeNum.put("ballNum", 0);
        ballStrikeNum.put("strikeNum", 0);
        return ballStrikeNum;
    }


    private static List<Integer> getRandomValue() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
