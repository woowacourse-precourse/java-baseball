package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        getStartMessage();
        List<Integer> answer = getRandomValue();
        List<Integer> userInput;
        makeException();
    }

    public static void getStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void getCorrectMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> getRandomValue() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static List<Integer> getUserInput() {

            String input = Console.readLine();
            List<Integer> inputList = new ArrayList<>();

            if (input.length() > 3) {makeException();}

            return inputList;
    }

    public static void makeException() {
        throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해주십시오");
    }
}
