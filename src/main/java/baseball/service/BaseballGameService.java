package baseball.service;

import baseball.domain.Computer;
import baseball.domain.PitchResult;

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

    }

    private void setBallStatus() {
        pitchResult.setResult(userInput, computer.getNumbers());
    }

    // 위에서 받은 인풋 검증
    public boolean isThreeStrike() {
        return false;
    }

    //흐름 처리 메서드
    public void throwBaseball() {
        setBallStatus();
    }
}
