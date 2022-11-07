package baseball;

import baseball.Messages.ErrorMessages;
import baseball.Messages.ProgramMessages;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    private Pitcher user;
    private Catcher com;

    private boolean quit;
    private boolean strikeOut;
    HintGenerator hg;
    String hint;


    public void startGame() {
        do {
            playGame();
        } while (!quit);
    }

    /**
     * 사용자가 2를 입력하여 게임을 완전히 종료하기 전까지 게임을 진행하는 함수
     */
    public void playGame() {
        System.out.println(ProgramMessages.START_MESSAGE);
        com = new Catcher();
        strikeOut = false;
        do {
            provideHint();
        } while (!strikeOut);
    }

    /**
     * 사용자로부터 입력받은 수로 힌트를 만들고 사용자에게 제공하는 함수
     */
    public void provideHint() {
        System.out.print(ProgramMessages.PLEASE_TYPE_NUMBER);
        String input = Console.readLine();
        validateInput(input);
        user = new Pitcher(input);
        hg = new HintGenerator(user, com);
        hint = hg.generateHint();
        System.out.println(hint);
        isStrikeOut(hint);
    }

    /**
     * input이 1 또는 2가 아닐 때 예외처리 해주는 함수
     *
     * @param input
     */
    public void validateInput(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ErrorMessages.PLEASE_REENTER);
        } else if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER);
        } else if (input.equals(ProgramMessages.RESTART)
                || input.equals(ProgramMessages.QUIT)) {
            throw new IllegalArgumentException(ErrorMessages.PLEASE_REENTER);
        }
    }

    /**
     * hint가 3스트라이크인지 확인하는 함수
     */
    public void isStrikeOut(String hint) {
        if(hint.equals("3"+ProgramMessages.STRIKE)) {
            strikeOut = true;
            System.out.println(ProgramMessages.GAME_SET);
            quitOrRestart();
        }
    }

    /**
     * 사용자의 입력에 따라서 종료할지 재시작할지 quit 변수값을 조정하는 함수
     */
    public void quitOrRestart() {
        System.out.println(ProgramMessages.QUIT_OR_RESTART);
        String input = Console.readLine();
        if(input.equals(ProgramMessages.RESTART)) {
            quit = false;
        } else if (input.equals(ProgramMessages.QUIT)) {
            quit = true;
        }

    }
}
