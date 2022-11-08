package baseball;

import java.util.*;

public class Player {

    private static final int FIXED_INPUT_LENGTH = 3;

//    private static List<Integer> inputList = new ArrayList<>();
    private static Map<Integer, Integer> playerInputMap = new HashMap<>();

    public void input(String inputString) {

        validateInputLength(inputString);
        validateInputIsNumber(inputString);
        validateInputHasZero(inputString);
        validateInputDuplication(inputString);

        inputStringToInputList(inputString);
    }

    public void inputStringToInputList(String inputString){
        playerInputMap.clear();

        int inputLength = inputString.length();

        for (int idx = 0; idx < inputLength; idx++) {
            char token = inputString.charAt(idx);
            int tokenToInt = token - '0';

            playerInputMap.put(idx, tokenToInt);
        }
    }

    public Map<Integer, Integer> getPlayerInputMap() {
        return Collections.unmodifiableMap(playerInputMap);
    }


    // 입력값이 숫자인지 검증
    public void validateInputIsNumber(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char token = inputString.charAt(i);

            if (!Character.isDigit(token)) {
                throw new IllegalArgumentException("입력값은 숫자만 포함되어야 합니다.");
            }
        }
    }

    public void validateInputHasZero(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char token = inputString.charAt(i);

            if (token == '0') {
                throw new IllegalArgumentException("입력값에 0이 포함될 수 없습니다.");
            }
        }
    }

    public void validateInputLength(String inputString) {
        if (inputString.length() != FIXED_INPUT_LENGTH) {
            throw new IllegalArgumentException(inputString + " 입력값은 세자리여야 합니다.");
        }
    }

    public void validateInputDuplication(String inputString) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            set.add(inputString.charAt(i));
        }

        if (set.size() != inputString.length()) {
            throw new IllegalArgumentException("입력값에 수의 중복이 존재합니다.");
        }
    }
}
