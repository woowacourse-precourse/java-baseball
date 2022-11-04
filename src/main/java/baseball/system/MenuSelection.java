package baseball.system;

import camp.nextstep.edu.missionutils.Console;
public class MenuSelection {

    private final boolean PLAY_GAME = true;
    private final boolean QUIT = false;


    public boolean startMenuSelection() {

        printMenuSelection();

        String selectionNumber = inputSelectionNumber();

        if(selectionNumber.equals("1")){
            return PLAY_GAME;
        }

        return QUIT;

    }

    private String inputSelectionNumber() throws IllegalArgumentException {

        String inputNumber = Console.readLine();

        if(isOneOrTwo(inputNumber)){
            return inputNumber;
        }

        throw new IllegalArgumentException();
    }

    private boolean isOneOrTwo(String inputNumber){
        return inputNumber.equals("1") || inputNumber.equals("2");
    }

    private void printMenuSelection() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
