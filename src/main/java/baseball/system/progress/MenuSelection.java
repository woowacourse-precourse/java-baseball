package baseball.system.progress;

import baseball.system.constant.BaseballConstant;
import baseball.system.exception.IllegalArgument;
import baseball.utils.*;

public class MenuSelection {
    private int selectionNumber;

    public int startMenuSelection() {
        printMenuSelection();

        InputSelectionNumber();

        return selectionNumber;
    }

    private void InputSelectionNumber() {
        String inputNumber = Input.input();
        setSelectionNumber(inputNumber);
    }

    private void setSelectionNumber(String inputNumber) {
        this.selectionNumber = selectNumber(inputNumber);
    }

    private int selectNumber(String inputNumber) throws IllegalArgumentException {

        final int PLAY_GAME = BaseballConstant.PLAY_GAME;
        final int QUIT = BaseballConstant.QUIT;
        final int SELECTION_NUMBER_LENGTH = BaseballConstant.SELECTION_NUMBER_LENGTH;

        if (!IsCollection.isInputNumbersInRange(inputNumber, PLAY_GAME, QUIT)
                || !IsCollection.isEqualToSetLength(inputNumber, SELECTION_NUMBER_LENGTH)) {
            IllegalArgument.outOfRange(PLAY_GAME, QUIT);
        }

        return Integer.parseInt(inputNumber);
    }

    private void printMenuSelection() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
