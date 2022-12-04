package baseball.view;

import baseball.util.InputExceptionPharse;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserInput(){
        return Console.readLine();
    }

    /**
     * 사용자 숫자 입력
     * @return
     */
    public String getUserNumber() throws IllegalArgumentException {
        String userInput = getUserInput();
        InputException.nullException(userInput);
        InputException.notNumberSizeException(userInput);
        InputException.notNumber(userInput);

        return userInput;
    }

    /**
     * 게임 시작 종료 입력
     * @return
     */
    public int getGameNumber() throws IllegalArgumentException {
        String userInput = getUserInput();
        InputException.nullException(userInput);
        InputException.notNumber(userInput);
        InputException.notGameNumberSizeException(userInput);

        int gameNumber = Integer.parseInt(userInput);
        InputException.notGameStatusNumber(gameNumber);
        return gameNumber;
    }
}
