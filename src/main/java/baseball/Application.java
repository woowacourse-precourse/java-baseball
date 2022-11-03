package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();


    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> Answer = createNewAnswer();
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> userInput = getValidUserInput(Console.readLine());
        }
    }

    public int getBall()

    public int getStrike(List<Integer> answer, List<Integer> userInput) {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == userInput.get(i)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getValidUserInput(String input) {
        checkInputLength(input);
        List<Integer> userInput = convertIntegerList(input);
        checkIsInteger(userInput);

        return userInput;
    }

    private void checkInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    private void checkIsInteger(List<Integer> inputs) {
        int startInclusive = 1;
        int lastInclusive = 9;

        for (Integer input : inputs) {
            checkInValidRange(startInclusive, lastInclusive, input);
        }
    }

    private void checkInValidRange(int startInclusive, int lastInclusive, int param) {
        if (param < startInclusive || param > lastInclusive) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    private List<Integer> convertIntegerList(String input) {
        List<Integer> userInput = new ArrayList<>();
        for (char number : input.toCharArray()) {
            userInput.add(Character.getNumericValue(number));
        }
        return userInput;
    }

    public List<Integer> createNewAnswer() {
        int startInclusive = 1;
        int lastInclusive = 9;
        int count = 3;
        return Randoms.pickUniqueNumbersInRange(startInclusive, lastInclusive, count);
    }
}
