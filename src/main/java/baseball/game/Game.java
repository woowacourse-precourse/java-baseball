package baseball.game;

import baseball.io.IOTopClass;
import baseball.io.OutputMessage;
import java.util.List;

public class Game {

    private final Referee referee;
    private final Computer computer;

    public Game(int listSize) {
        this.referee = new Referee();
        this.computer = new Computer(listSize);
    }

    public void runGame(IOTopClass ioTopClass) {
        ioTopClass.printGuide(OutputMessage.START_MESSAGE.getMessage());
        while (true) {
            boolean flag;
            flag = endGameOrQuit(ioTopClass, false, computer.makeRandomNum());
            if (flag) {
                break;
            }
        }
    }

    private boolean endGameOrQuit(IOTopClass ioTopClass, boolean flag, List<Character> computerList) {
        int oneOrTwo = 0;
        while (oneOrTwo == 0) {
            ioTopClass.printGuide(OutputMessage.INPUT_MESSAGE.getMessage());
            List<Integer> strikeBalls = referee.compareLists(computerList, ioTopClass.makeInputList());
            ioTopClass.printStrikeAndBalls(strikeBalls);
            oneOrTwo = endGameMessage(strikeBalls.equals(List.of(3, 0)), oneOrTwo, ioTopClass);
            flag = checkTwo(oneOrTwo);
        }
        return flag;
    }

    private static boolean checkTwo(int oneOrTwo) {
        return oneOrTwo == 2;
    }

    private  int endGameMessage(boolean trueOrFalse, Integer oneOrTwo, IOTopClass ioTopClass) {
        if (trueOrFalse) {
            ioTopClass.printGuide(OutputMessage.ENDGAME_MESSAGE.getMessage());
            ioTopClass.printGuide(OutputMessage.ENDORRE_MESSAGE.getMessage());
            oneOrTwo = ioTopClass.endOrReOneOrTwo();
        }
        return oneOrTwo;
    }
}