package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isGameFinished = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerDigits = generateRandomNumbers();
        System.out.println();

        while (!isGameFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = getUserInput();
            System.out.println(userInput);
            int userGuess = validateUserInput(userInput, 3);

            List<Integer> inputDigits = getDigitList(userGuess);
            List<Integer> comparedResult = compareAnswerWithInput(answerDigits, inputDigits);

            isGameFinished = printStrikeAndBall(comparedResult);
            if (isGameFinished) {
                userInput = getUserInput();
                userGuess = validateUserInput(userInput, 1);
                if (userGuess == 1){
                    isGameFinished = false;
                    answerDigits = generateRandomNumbers();
                }else if (userGuess == 2){
                    isGameFinished = true;
                }
            }
        }

        return;
    }

    public static List<Integer> generateRandomNumbers(){
        List<Integer> answerDigits = new ArrayList<Integer>();
        while(answerDigits.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerDigits.contains(randomNumber)){
                answerDigits.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        return answerDigits;
    }

    public static String getUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    private static int validateUserInput(String userInput, int checkLength) throws IllegalArgumentException {
        try {
            if (userInput.length() != checkLength) {
                throw new IllegalArgumentException("Input should be"+ checkLength +
                        "digit numbers in the range of 111~999");
            }
            int userGuess = Integer.parseInt(userInput);
            return userGuess;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input should be 3 digit numbers in the range of 111~999");
        }
    }

    public static List<Integer> compareAnswerWithInput(List<Integer> answerDigits, List<Integer> inputDigits) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            int answerDigit = answerDigits.get(i);
            int inputDigit = inputDigits.get(i);

            if (answerDigit == inputDigit) {
                strikeCount++;
                ballCount--;
            }
            if (answerDigits.contains(inputDigit)) {
                ballCount++;
            }
        }

        return List.of(strikeCount, ballCount);
    }

    public static List<Integer> getDigitList(int numbers) {
        int tmp = numbers;
        ArrayList<Integer> digits = new ArrayList<Integer>();

        while (tmp > 0) {
            int digit = tmp % 10;
            digits.add(0,digit);
            tmp = tmp / 10;
        }

        return digits;
    }

    public static boolean printStrikeAndBall(List<Integer> comparedResult) {
        int strikeCount = comparedResult.get(0);
        int ballCount = comparedResult.get(1);

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }
        System.out.println("");
        return false;
    }


}
