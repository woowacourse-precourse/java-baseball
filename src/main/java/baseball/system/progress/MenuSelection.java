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
        if (isNotSelectionNumber(inputNumber)) {
            IllegalArgument.outOfRange(BaseballConstant.PLAY_GAME, BaseballConstant.QUIT);
        }

        return Integer.parseInt(inputNumber);
    }

    private boolean isNotSelectionNumber(String inputNumber){
        return (!IsCollection.isInputNumbersInRange(inputNumber, BaseballConstant.PLAY_GAME, BaseballConstant.QUIT))
                || (!IsCollection.isEqualToSetLength(inputNumber, BaseballConstant.SELECTION_NUMBER_LENGTH));
    }

    private void printMenuSelection() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
