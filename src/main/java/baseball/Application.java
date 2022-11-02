package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Application {

    private static final int answerLength = 3;

    private static List<Integer> startGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> correctAnswer = new ArrayList<>();
        while (correctAnswer.size() < answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(randomNumber)) {
                correctAnswer.add(randomNumber);
            }
        }
        return  correctAnswer;
    }

    private static List<Integer> getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] inputArray = Console.readLine().split("");

        List<Integer> userAnswer = new ArrayList<>();
        try {
            for (String input : inputArray) {
                userAnswer.add(Integer.parseInt(input));
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        Set<Integer> userAnswerSet = new HashSet<>(userAnswer);
        if (userAnswer.size() != answerLength) {
            throw new IllegalArgumentException();
        } else if (userAnswer.size() != userAnswerSet.size()) {
            throw new IllegalArgumentException();
        }

        return userAnswer;
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
