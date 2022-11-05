package baseball.system;

import baseball.utils.Input;

public class MenuSelection {

    private final boolean PLAY_GAME = true;
    private final boolean QUIT = false;

    private String selectionNumber;

    public boolean startMenuSelection() {

        printMenuSelection();

        String inputNumber = Input.input();
        setSelectionNumber(inputNumber);

        if (selectionNumber.equals("1")) {
            return PLAY_GAME;
        }

        return QUIT;

    }

    private void setSelectionNumber(String inputNumber) {
        this.selectionNumber = selectNumber(inputNumber);
    }

    private String selectNumber(String inputNumber) throws IllegalArgumentException {

        if (isOneOrTwo(inputNumber)) {
            return inputNumber;
        }

        throw new IllegalArgumentException();
    }

    private boolean isOneOrTwo(String inputNumber) {
        return inputNumber.equals("1") || inputNumber.equals("2");
    }

    private void printMenuSelection() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
