package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.Constant.MAX;

public class Player {
    private static final String INT_REGEX = "^[0-9]*$";
    private static final Player PLAYER = new Player();

    public static Player getPlayer() {
        return PLAYER;
    }

    public List<Integer> inputNumber() {
        String userInput = Console.readLine();

        // 예외
        checkNumber(userInput);
        checkLength(userInput);
        checkDuplication(userInput);
        checkRangeNumber(userInput);

        return stringToList(userInput);
    }

    public int inputContinuation() {
        String userInput = Console.readLine();

        // 예외
        checkFormContinuation(userInput);

        return Integer.parseInt(userInput);
    }

    private List<Integer> stringToList(String userInput) {
        int[] input = Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());
    }

    public void checkNumber(String userInput) throws IllegalArgumentException {
        if(!userInput.matches(INT_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public void checkLength(String userInput) throws IllegalArgumentException {
        if(userInput.length() > MAX) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    public void checkDuplication(String userInput) throws IllegalArgumentException {
        List<Integer> before_input = stringToList(userInput);
        Set<Integer> after_input = new HashSet<>(before_input);

        if(before_input.size() != after_input.size()) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자만 입력이 가능합니다.");
        }
    }

    public void checkFormContinuation(String userInput) throws IllegalArgumentException {
        int userContinuation = Integer.parseInt(userInput);
        if(userContinuation != 1 && userContinuation != 2) {
            throw new IllegalArgumentException("1(새로 시작), 2(게임 종료) 만 입력 가능합니다.");
        }
    }

    public void checkRangeNumber(String userInput) throws IllegalArgumentException {
        List<Integer> inputList = stringToList(userInput);
        List<Integer> range = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for(int inputListIndex = 0; inputListIndex < MAX; inputListIndex++) {
            if(!range.contains(inputList.get(inputListIndex))) {
                throw new IllegalArgumentException("입력할 수 있는 숫자 범위는 1 ~ 9 사이입니다.");
            }
        }
    }
}