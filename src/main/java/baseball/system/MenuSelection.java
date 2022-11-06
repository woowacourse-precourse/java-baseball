package baseball.system;

import baseball.utils.*;

public class MenuSelection {
    private int selectionNumber;

    public int startMenuSelection() {
        printMenuSelection();

        String inputNumber = Input.input();
        setSelectionNumber(inputNumber);

        return selectionNumber;
    }

    private void setSelectionNumber(String inputNumber) {
        this.selectionNumber = selectNumber(inputNumber);
    }

    private int selectNumber(String inputNumber) throws IllegalArgumentException {
        if (!IsCollection.isInputNumbersInRange(
                inputNumber,
                BaseballConstant.PLAY_GAME,
                BaseballConstant.QUIT)) {
            throw new IllegalArgumentException();
        }

        if (!IsCollection.isEqualToSetLength(
                inputNumber,
                BaseballConstant.SELECTION_NUMBER_LENGTH)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(inputNumber);
    }

    private void printMenuSelection() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
