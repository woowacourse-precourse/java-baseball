package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LinkedHashMap<Integer, Integer> computersNumbers;
        LinkedHashMap<Integer, Integer> playersNumbers;
        LinkedHashMap<String, Integer> scoreSheet;
        System.out.println("숫자 야구 게임을 시작합니다.");
        computersNumbers = randomNumbers();
        int playStatus = 0;

        while (playStatus == 0) {
            playersNumbers = getNumbers();
            scoreSheet = comparing(computersNumbers, playersNumbers);
            playStatus = gameResult(scoreSheet);
            if (playStatus == 1) {
                playStatus = restartGame();
                computersNumbers = randomNumbers();
            }
        }
    }

    public static LinkedHashMap<Integer, Integer> randomNumbers() {

        LinkedHashMap<Integer, Integer> randomlyPickedNumbers = new LinkedHashMap<>();

        for (int index = 0; index < 3; index++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomlyPickedNumbers.containsValue(randomNumber)) {
                randomlyPickedNumbers.put(index, randomNumber);
            }
        }

 /*       ArrayList<Integer> randomlyPickedNumbers = new ArrayList<Integer>();
        while (randomlyPickedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomlyPickedNumbers.contains(randomNumber)) {
                randomlyPickedNumbers.add(randomNumber);
            }
        }*/
        return randomlyPickedNumbers;
    }



    public static boolean inputRequirements(int input1, int input2, int input3) {
        if ((input1 != input2) && (input2 != input3) && (input1 != input3)) {
            if ((input1 < 10) && (input2 < 10) && (input3 < 10) && (input1 > 0) && (input2 > 0) && (input3 > 0)) {
                return true;
            }
        }
        return false;
    }

    public static LinkedHashMap<Integer, Integer> getNumbers() {
        LinkedHashMap<Integer, Integer> usersNumbers = new LinkedHashMap<Integer, Integer>();

        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        int inputNumber1 = Integer.parseInt(input);
        int inputNumber2 = 0;
        int inputNumber3 = 0;
        if (inputNumber1 > 99 && inputNumber1 < 1000) {

            inputNumber2 = inputNumber1 % 100 / 10;
            inputNumber3 = inputNumber1 % 10;
            inputNumber1 = inputNumber1 / 100;

        } else if (inputNumber1 > 0 && inputNumber1 < 10) {
            String input2 = Console.readLine();
            String input3 = Console.readLine();
            inputNumber2 = Integer.parseInt(input2);
            inputNumber3 = Integer.parseInt(input3);
        } else {
            throw new IllegalArgumentException();
        }
        if (inputRequirements(inputNumber1, inputNumber2, inputNumber3)) {
            usersNumbers.put(0, inputNumber1);
            usersNumbers.put(1, inputNumber2);
            usersNumbers.put(2, inputNumber3);
        } else {
            throw new IllegalArgumentException();
        }
        return usersNumbers;
    }

    public static LinkedHashMap<String, Integer> comparing(LinkedHashMap<Integer, Integer> computerNumbers, LinkedHashMap<Integer, Integer> userNumbers) {

        LinkedHashMap<String, Integer> hintResult = new LinkedHashMap<String, Integer>();

        int strike = 0;
        int ball = 0;
        for (int arrayIndex = 0; arrayIndex < 3; arrayIndex++) {
            if (computerNumbers.get(arrayIndex).equals(userNumbers.get(arrayIndex))) {
                strike++;
            }
            if (computerNumbers.containsValue(userNumbers.get(arrayIndex))) {
                ball++;
            }
        }
        ball = ball - strike;

        hintResult.put("strike", strike);
        hintResult.put("ball", ball);

        return hintResult;
    }

    public static int gameResult(LinkedHashMap<String, Integer> strikeAndBall) {
        int gameStatus = 0;
        if (strikeAndBall.get("strike") == 3) {
            System.out.printf("%d스트라이크\n", strikeAndBall.get("strike"));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameStatus = 1;
        } else if (strikeAndBall.get("strike") == 0 && strikeAndBall.get("ball") == 0) {
            System.out.println("낫싱");
        } else {
            if (strikeAndBall.get("strike") == 0) {
                System.out.printf("%d볼\n", strikeAndBall.get("ball"));
            } else if (strikeAndBall.get("ball") == 0) {
                System.out.printf("%d스트라이크\n", strikeAndBall.get("strike"));
            } else {
                System.out.printf("%1$d볼 %2$d스트라이크\n", strikeAndBall.get("ball"), strikeAndBall.get("strike"));
            }
        }
        return gameStatus;
    }

    public static int restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = Console.readLine();
        int answer = Integer.parseInt(input);
        if (answer == 1) {
            return 0;
        } else if (answer == 2) {
            return 1;
        } else {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
}


