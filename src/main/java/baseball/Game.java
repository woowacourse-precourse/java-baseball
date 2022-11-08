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

    public void start() {
        Output.printStartMsg();
        do {
            Computer.setComputerNumber();
            while (true) {
                Output.printInputMsg();
                User.setUserNumber();
                Calculator.calculateNum(Computer.getComputerNumber(), User.getUserNumber());
                Output.printOutput(Calculator.getBallNum(), Calculator.getStrikeNum());
                if (checkThreeStrike(Calculator.getStrikeNum())) {
                    Output.printEndMsg();
                    getStartFlag();
                    break;
                }
            }
        } while (checkEndGame());
    }
    public void getNumfromUser(){

    }
    public Boolean checkThreeStrike(int StrikeNum) {
        return StrikeNum == NumberLength;
    }

    public void getStartFlag() {
        startFlag = Integer.parseInt(Console.readLine());
    }

    public boolean checkEndGame() {
        if (startFlag != 1 && startFlag != 2) {
            throw new IllegalArgumentException();
        }
        return startFlag == 2;
    }
}
