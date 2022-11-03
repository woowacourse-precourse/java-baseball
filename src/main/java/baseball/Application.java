package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        while (true) {
            application.run();
            if (application.handleExit()) {
                break;
            }
        }
    }

    public boolean handleExit() {
        printRestartOrExit();
        String restartKey = Console.readLine();
        int key = checkValidRestartKey(restartKey);
        if (key == 2) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void printRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    // 1 -> 재시작.
    // 2 -> 종료.
    // 그외 -> 예외처리.
    private int checkValidRestartKey(String restartKey) {
        checkInputLength(restartKey, 1);
        int key = Character.getNumericValue(restartKey.charAt(0));
        checkInValidRange(1, 2, key);
        return key;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = createNewAnswer();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            List<Integer> userInput = getValidUserInput(scanner.nextLine());
            int strike = getStrike(answer, userInput);
            int ball = getBall(answer, userInput, strike);
            Response response = new Response(strike, ball);
            response.view();
            if (response.isCompleted) {
                break;
            }
        }
    }

    public int getBall(List<Integer> answer, List<Integer> userInput, int strike) {
        Set<Integer> matchedIndexSet = new HashSet<>();
        for (int i = 0; i < answer.size(); i++) {
            addIndexIfMatchedAnswer(matchedIndexSet, answer.get(i), userInput);
        }
        int ballCount = ifMinusChangeZero(matchedIndexSet.size() - strike);
        return ballCount;
    }

    private int ifMinusChangeZero(int integer) {
        if (integer < 0) {
            return 0;
        }
        return integer;
    }

    private Set<Integer> addIndexIfMatchedAnswer(Set<Integer> matchedIndexSet, int answer, List<Integer> userInput) {
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) == answer) {
                matchedIndexSet.add(i);
            }
        }
        return matchedIndexSet;
    }

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
        int inputLength = 3;
        checkInputLength(input, inputLength);
        List<Integer> userInput = convertIntegerList(input);
        checkIsInteger(userInput);

        return userInput;
    }

    private void checkInputLength(String input, int length) {
        if (input.length() != length) {
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
