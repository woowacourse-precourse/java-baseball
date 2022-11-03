package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_LENGTH_ERROR_MESSAGE = "입력한 값이 3자리가 아닙니다.";
    private static final String INPUT_REPLAY_ERROR_MESSAGE = "재시작이나 종료를 위해서는 1이나 2를 입력해야 합니다.";
    private static final String INPUT_NOT_NUMERIC_ERROR_MESSAGE = "숫자가 아닌 문자가 입력되었습니다.";
    private static final String INPUT_DUPLICATED_ERROR_MESSAGE = "중복된 숫자가 입력되었습니다.";
    private static final int INPUT_BASEBALL_LENGTH = 3;
    private static final int INPUT_REPLAY_LENGTH = 3;
    private static char REPLAY = '1';
    private static char END = '2';
    public static void main(String[] args) {
        gameStart();

    }

    static void gameStart() {
        System.out.println(START_MESSAGE);
        int[] computer = initializeComputerNumber();
        boolean playBaseball = true;
        while(playBaseball){
            String userInput = getUserInput();
            try {
                isValidInput(userInput ,InputType.BASEBALL_NUMBER);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException);
                break;
            }
        }
    }

    static int[] initializeComputerNumber() {
        List<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumberList.contains(randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
        int[] computerNumberArray = computerNumberList.stream().mapToInt(i -> i).toArray();
        return computerNumberArray;
    }

    static String getUserInput() {
        System.out.print(INPUT_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }

    static void isValidInput(String userInput, InputType inputType) {
        if(inputType == InputType.BASEBALL_NUMBER) {
            if(userInput.length() != INPUT_BASEBALL_LENGTH) {
                throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
            }
            if(!isNumeric(userInput)) {
                throw new IllegalArgumentException(INPUT_NOT_NUMERIC_ERROR_MESSAGE);
            }
            if(hasDuplicatedNumber(userInput)) {
                throw new IllegalArgumentException(INPUT_DUPLICATED_ERROR_MESSAGE);
            }
        } else if(inputType == InputType.WHETHER_REPLAY) {
            if(userInput.length() != INPUT_REPLAY_LENGTH) {
                throw new IllegalArgumentException(INPUT_REPLAY_ERROR_MESSAGE);
            }
            if(!(userInput.charAt(0) == REPLAY || userInput.charAt(0) == END)) {
                throw new IllegalArgumentException(INPUT_REPLAY_ERROR_MESSAGE);
            }
        }
    }

    static boolean isNumeric(String userInput) {
        boolean result = true;
        for(int i = 0; i < 3; ++i) {
            if(!(userInput.charAt(i) >= '1' && userInput.charAt(i) <= '9')) {
                result = false;
                break;
            }
        }

        return result;
    }

    static boolean hasDuplicatedNumber(String userInput) {
        boolean isDuplicated = false;
        char firstLetter = userInput.charAt(0);
        char secondLetter = userInput.charAt(1);
        char thirdLetter = userInput.charAt(2);
        if(firstLetter == secondLetter) {
            isDuplicated = true;
        } else if(firstLetter == thirdLetter) {
            isDuplicated = true;
        } else if(secondLetter == thirdLetter) {
            isDuplicated = true;
        }

        return isDuplicated;
    }
}

enum InputType {
    BASEBALL_NUMBER,
    WHETHER_REPLAY
}