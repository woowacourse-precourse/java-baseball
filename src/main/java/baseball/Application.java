package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continueGame = true;
        while (continueGame) {
            List<Integer> randomValue = getRandomValue();

            playGame(randomValue);

            continueGame = continueOrEnd();
        }
    }

    public static void playGame(List<Integer> randomValue) {
        boolean success = true;
        while (success) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = readLine();

            validateThreeDifferentDigits(input);

            HashMap<String, Integer> ballStrikeNum = initializeBallStrikePoint();

            findPoint(randomValue, input, ballStrikeNum);

            success = printPoint(ballStrikeNum);
        }
    }

    public static boolean continueOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int newGame = Integer.parseInt(readLine());
        validateContinueEnd(newGame);
        if (newGame == 2) {
            System.out.println("게임 종료");
            return false;
        }
        return true;
    }

    public static void validateThreeDifferentDigits(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if(input.contains("0")){
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == input.charAt(1)) {
            throw new IllegalArgumentException();
        } else if (input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException();
        } else if (input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }

    }

    public static void validateContinueEnd(int newGame) {
        if (newGame !=1 && newGame !=2){
            throw new IllegalArgumentException();
        }
    }

    public static boolean printPoint(HashMap<String, Integer> ballStrikeNum) {
        if (ballStrikeNum.get("ballNum") == 0 && ballStrikeNum.get("strikeNum") == 0) {
            System.out.println("낫싱");
            return true;
        } else if (ballStrikeNum.get("ballNum") != 0 && ballStrikeNum.get("strikeNum") == 0) {
            System.out.println(ballStrikeNum.get("ballNum") + "볼");
            return true;
        } else if (ballStrikeNum.get("ballNum") == 0 && ballStrikeNum.get("strikeNum") != 0) {
            System.out.println(ballStrikeNum.get("strikeNum") + "스트라이크");
            if (ballStrikeNum.get("strikeNum") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return false;
            }
        } else {
            System.out.println(ballStrikeNum.get("ballNum") + "볼 " + ballStrikeNum.get("strikeNum") + "스트라이크");
            return true;
        }
        return true;
    }

    public static void findPoint(List<Integer> randomValue, String input, HashMap<String, Integer> ballStrikeNum) {
        for (int i = 0; i < 3; i++) {
            char charNum = input.charAt(i);
            if (randomValue.indexOf(Character.getNumericValue(charNum)) == i) {
                ballStrikeNum.put("strikeNum", ballStrikeNum.get("strikeNum") + 1);
            } else if (randomValue.contains(Character.getNumericValue(charNum))) {
                ballStrikeNum.put("ballNum", ballStrikeNum.get("ballNum") + 1);
            }
        }
    }

    public static HashMap<String, Integer> initializeBallStrikePoint() {
        HashMap<String, Integer> ballStrikeNum = new HashMap<>();
        ballStrikeNum.put("ballNum", 0);
        ballStrikeNum.put("strikeNum", 0);
        return ballStrikeNum;
    }

    public static List<Integer> getRandomValue() {
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
