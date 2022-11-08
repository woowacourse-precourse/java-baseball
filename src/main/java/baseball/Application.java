package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        print("숫자 야구 게임을 시작합니다.\n");

        boolean isOver = false;

        while (!isOver) {
            isOver = startNewGame();
        }

    }

    static boolean startNewGame() {
        Integer answerNumber = getNewAnswer();
        Integer userAnswerNumber = null;

        while (!answerNumber.equals(userAnswerNumber)) {
            print("숫자를 입력해주세요 : ");
            userAnswerNumber = getIntegerInput();
            validate(userAnswerNumber);
            print("\n");

            List<Integer> gameResult = getGameResult(answerNumber, userAnswerNumber);
            printGameResult(gameResult.get(0), gameResult.get(1));
        }

        boolean isOver;
        userAnswerNumber = getIntegerInput();
        print("\n");

        if (userAnswerNumber == 1) {
            isOver = false;
        } else if (userAnswerNumber == 2) {
            isOver = true;
        } else {
            throw new IllegalArgumentException();
        }

        return isOver;
    }

    static void print(String text) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException error) {
            error.printStackTrace();
        }

    }

    static Integer getNewAnswer() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }

        }

        int result = 0;

        for (int index = numbers.size() - 1, digit = 1; 0 <= index; index--) {
            result += numbers.get(index) * digit;
            digit *= 10;
        }

        return result;
    }

    static Integer getIntegerInput() throws IllegalArgumentException {

        try {
            String userInput = Console.readLine();
            Integer result = Integer.parseInt(userInput);
            return result;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException();
        }

    }

    static void validate(Integer number) throws IllegalArgumentException {

        if (number < 123 || 987 < number) {
            throw new IllegalArgumentException();
        }

        Set<Integer> duplicateCheckSet = new HashSet<Integer>();
        duplicateCheckSet.add(number % 10);
        duplicateCheckSet.add((number / 10) % 10);
        duplicateCheckSet.add((number / 100) % 10);

        if (duplicateCheckSet.size() != 3 || duplicateCheckSet.contains(0)) {
            throw new IllegalArgumentException();
        }

    }

    static List<Integer> getGameResult(Integer answer, Integer userAnswer) {
        int ball = 0;
        int strike = 0;

        String answerString = String.valueOf(answer);
        String userAnswerString = String.valueOf(userAnswer);

        for (int index = 0; index < userAnswerString.length(); index++) {
            Character targetChar = userAnswerString.charAt(index);

            if (targetChar == answerString.charAt(index)) {
                strike++;
            } else if (answerString.contains(targetChar.toString())) {
                ball++;
            }

        }

        return List.of(ball, strike);
    }

    static void printGameResult(int ball, int strike) {

        if (ball != 0) {
            print(ball + "볼 ");
        }

        if (strike != 0) {
            print(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            print("낫싱");
        }

        if (strike == 3) {
            print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        print("\n");
    }
}