package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer Computer;
    private final User User;
    private final Calculator Calculator;

    private static int startFlag = 1;
    private static int NumberLength = 3;

    //새로 게임 만들 때의 생성자
    public Game() {
        Computer = new Computer();
        User = new User();
        Calculator = new Calculator();
    }
    // 사용자가 정확한 답 못맞췄을 경우, 생성자.
    public Game(String computerNum) {
        Computer = new Computer(computerNum);
        User = new User();
        Calculator = new Calculator();
    }

    public void start() {
        insertInput();
        showHint();
        checkCorrectNum();
        IsEnd();
    }

    public void insertInput() {
        Output.printInputMsg();
        User.setUserNumber();
    }

    public void showHint() {
        Calculator.calculateNum(Computer.getComputerNumber(), User.getUserNumber());
        Output.printOutput(Calculator.getBallNum(), Calculator.getStrikeNum());
    }

    public void checkCorrectNum(){
        if (checkThreeStrike(Calculator.getStrikeNum())) {
            Output.printEndMsg();
            setStartFlag();
        } else {
            new Game(Computer.getComputerNumber()).start();
        }
    }

    public void IsEnd(){
        if (!checkEndGame(startFlag)) {
            new Game().start();
        }
    }

    public Boolean checkThreeStrike(int StrikeNum) {
        return StrikeNum == NumberLength;
    }

    public void setStartFlag() {
        startFlag = Input.getStartFlag();
    }

    public boolean checkEndGame(int startFlag) {
        if (startFlag != 1 && startFlag != 2) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        return startFlag == 2;
    }
}
