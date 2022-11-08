package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer Computer;
    private final User User;
    private final Calculator Calculator;

    private static int startFlag = 1;
    private static int NumberLength = 3;

    public Game() {
        Computer = new Computer();
        User = new User();
        Calculator = new Calculator();
    }
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
        if (!checkEndGame()) {
            new Game().start();
        }
    }

    public Boolean checkThreeStrike(int StrikeNum) {
        return StrikeNum == NumberLength;
    }

    public void setStartFlag() {
        startFlag = Input.getStartFlag();
    }

    public boolean checkEndGame() {
        if (startFlag != 1 && startFlag != 2) {
            throw new IllegalArgumentException();
        }
        return startFlag == 2;
    }
}
