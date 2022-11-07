package baseball.game;

import baseball.io.IOTopClass;
import java.util.List;

public class Game {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENDGAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String ENDORRE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final List<Integer> THREE_STRIKE = List.of(3, 0);
    private static final int LIST_SIZE = 3;

    private final CompareTwoList compareTwoList;
    private final Computer computer;

    public Game() {
        this.compareTwoList = new CompareTwoList();
        this.computer = new Computer();
    }

    public void runGame(IOTopClass ioTopClass) {
        System.out.println(START_MESSAGE);
        while (true) {
            boolean flag;
            flag = endGameOrQuit(ioTopClass, false, computer.makeRandomNum(LIST_SIZE));
            if (flag) {
                break;
            }
        }
    }

    private boolean endGameOrQuit(IOTopClass ioTopClass, boolean flag, List<Character> computerList) {
        int oneOrTwo = 0;
        while (oneOrTwo == 0) {
            System.out.print(INPUT_MESSAGE);
            List<Integer> strikeBalls = compareTwoList.compareLists(computerList, ioTopClass.makeInputList());
            ioTopClass.printStrikeAndBalls(strikeBalls);
            oneOrTwo = endGameMessage(strikeBalls.equals(THREE_STRIKE), oneOrTwo, ioTopClass);
            flag = checkTwo(oneOrTwo);
        }
        return flag;
    }

    private static boolean checkTwo(int oneOrTwo) {
        return oneOrTwo == 2;
    }

    private  int endGameMessage(boolean trueOrFalse, Integer oneOrTwo, IOTopClass ioTopClass) {
        if (trueOrFalse) {
            System.out.println(ENDGAME_MESSAGE + ENDORRE_MESSAGE);
            oneOrTwo = ioTopClass.endOrReOneOrTwo();
        }
        return oneOrTwo;
    }
}