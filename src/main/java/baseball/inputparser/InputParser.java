package baseball.inputparser;

import java.util.HashSet;
import java.util.Set;

import static baseball.inputparser.InputType.GAME_RESTART_INPUT;
import static baseball.inputparser.InputType.IN_GAME_INPUT;
import static baseball.inputparser.RestartType.QUIT;
import static baseball.inputparser.RestartType.RESTART;

/**
 * 사용자의 입력과 관련한 로직 처리를 담당합니다.
 * @version 1.0.0
 * @author Cho MinHo
 */
public class InputParser {

    /**
     * 게임이 진행 중일 때 (사용자가 3개의 문자를 입력하는 경우) 입력 문자열에 관한 처리 메서드입니다.
     * 입력 문자열을 입력으로 받아 해당하는 3개의 숫자를 담은 Set을 반환합니다.
     * @param input 입력 문자열
     * @return 입력으로 받은 3개의 숫자를 담은 Set
     * @throws IllegalArgumentException 입력 문자열이 정수형으로 파싱되지 않거나, 서로 다른 3개의 숫자가 아닌 경우
     */
    public static Set<Integer> parseInGameInput(String input) throws IllegalArgumentException {
        checkCommonInput(input, IN_GAME_INPUT);
        return parseThreeInteger(input);
    }

    /**
     * 게임 종료 시점에 게임 재시작 여부에 관한 입력 문자열을 받아서 재시작 여부를 반환하는 메서드입니다.
     * @param input 입력 문자열
     * @return 게임 재시작 여부
     * @throws IllegalArgumentException 입력 문자열이 정수형으로 파싱되지 않거나, 1 또는 2의 값이 아닌 경우
     */
    public static RestartType parseRestartInput(String input) throws IllegalArgumentException {
        checkCommonInput(input, GAME_RESTART_INPUT);

        int inputValue = Integer.parseInt(input);
        if (!(inputValue == 1 || inputValue == 2)) {
            throw new IllegalArgumentException("1 또는 2의 숫자를 입력해야 합니다! ex)1");
        }

        if (inputValue == 1) {
            return RESTART;
        }
        else {
            return QUIT;
        }
    }

    /**
     * 공통적인 입력처리에 관련된 메서드입니다.
     * 각 입력 문자열이 Integer 형으로 변환될 수 있는지를 검사하며, 변환할 수 없으면 예외를 던집니다.
     * @param input 입력 문자열
     * @param inputType 입력 문자열 타입
     * @throws IllegalArgumentException 입력 문자열이 Integer형으로 반환될 수 없는 경우
     */
    private static void checkCommonInput(String input, InputType inputType) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            if (inputType == IN_GAME_INPUT) {
                throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해야 합니다! ex)123");
            }
            else if (inputType == GAME_RESTART_INPUT) {
                throw new IllegalArgumentException("1 또는 2의 숫자를 입력해야 합니다! ex)1");
            }
            else {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다!");
            }
        }
    }

    /**
     * 입력 문자열이 서로 다른 3개의 숫자인지를 확인하고, 서로 다른 3개의 숫자일 경우 이 숫자들을 담은 Set을 반환합니다.
     * @param input 입력 문자열
     * @return 3개의 서로 다른 숫자들을 담은 Set
     * @throws IllegalArgumentException 입력 문자열이 서로 다른 3개의 숫자가 아닌 경우
     */
    private static Set<Integer> parseThreeInteger(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해야 합니다! ex)123");
        }

        Set<Integer> integerSet = new HashSet<>();
        // set은 같은 숫자를 중복해서 저장하지 않기 때문에, set을 이용해서 숫자들을 저장하고, 숫자가 총 3개인지 확인합니다.
        for (int i = 0; i < input.length(); i++) {
            integerSet.add(input.charAt(i) - '0');
        }

        if (integerSet.size() < 3) {
            throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해야 합니다! ex)123");
        }
        return integerSet;
    }

}
