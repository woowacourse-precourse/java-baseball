package baseball.game;

import baseball.io.IOTopClass;
import java.util.List;

public class Game {

    private final CompareTwoList compareTwoList;
    private final Computer computer;

    public Game(int listSize) {
        this.compareTwoList = new CompareTwoList();
        this.computer = new Computer(listSize);
    }

    public void runGame(IOTopClass ioTopClass) {
        GameGuide.startMessage();
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
            GameGuide.inputMessage();
            List<Integer> strikeBalls = compareTwoList.compareLists(computerList, ioTopClass.makeInputList());
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
            GameGuide.reOrEndGameMessage();
            oneOrTwo = ioTopClass.endOrReOneOrTwo();
        }
        return oneOrTwo;
    }
}