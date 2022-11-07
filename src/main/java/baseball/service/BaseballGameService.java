package baseball.service;

import baseball.domain.Computer;
import baseball.domain.PitchResult;
import baseball.message.ExceptionMessage;
import baseball.util.Validate;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {

    private Computer computer;
    private PitchResult pitchResult;
    private String userInput;

    public BaseballGameService() {
        pitchResult = new PitchResult();
    }

    public void initComputer() {
        computer = new Computer();
    }

    //유저의 게임내 숫자 맞추는 인풋 받기
    public void readUserInput() {
        String input = Console.readLine();

        if (Validate.isDifferentDigits(input)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DUPLICATE_DIGITS);
        }

        userInput = input;
    }

    private void setBallStatus() {
        pitchResult.setResult(userInput, computer.getNumbers());
    }

    // 위에서 받은 인풋 검증
    public boolean isKeepThrow() {
        return !(pitchResult.isThreeStrike());
    }

    //흐름 처리 메서드
    public void throwBaseball() {
        readUserInput();
        setBallStatus();
        displayPitchStatusMessage(pitchResult.getPitchStatusMessage());
    }

    private void displayPitchStatusMessage(String pitchStatusMessage) {
        System.out.println(pitchStatusMessage);
    }
}
