package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean play = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (play) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            play = checkContinue();
        }
    }

    private static void playGame() {
        List<Integer> inputNumber = new ArrayList<>();
        List<Integer> baseballNumber = BaseballNumber.create();
        while (!baseballNumber.equals(inputNumber)) {
            inputNumber = inputNumber();
            int strike = BaseballNumber.countStrike(baseballNumber, inputNumber);
            int ball = BaseballNumber.countBall(baseballNumber, inputNumber);
            String message = BaseballNumber.getMessage(strike, ball);
            System.out.println(message);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputData = Console.readLine();
        validateNumber(inputData);

        List<Integer> inputNumber = new ArrayList<>();
        for (char digit : inputData.toCharArray()) {
            inputNumber.add(digit - 48);
        }

        return inputNumber;
    }

    private static void validateNumber(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("the input only allows integer");
        }

        if (inputData.length() != 3) {
            throw new IllegalArgumentException("the input only allows three-digit numbers");
        }

        for (char digit : inputData.toCharArray()) {
            if (digit == '0') {
                throw new IllegalArgumentException("each digit only allows 1~9");
            }
        }

        List<Character> inputDataList = new ArrayList<>();
        for (char digit : inputData.toCharArray()) {
            inputDataList.add(digit);
        }
        Set<Character> inputDataSet = new HashSet<>(inputDataList);
        if (inputDataList.size() != inputDataSet.size()) {
            throw new IllegalArgumentException("all digits are unique");
        }
    }

    private static boolean checkContinue() {
        String inputData = Console.readLine();
        if (inputData.equals("1")) {
            return true;
        }
        if (inputData.equals("2")) {
            return false;
        }
        //0,1외의 숫자가 들어왔을경우 Exception 처리
        throw new IllegalArgumentException("enter 1 or 2");
    }
}