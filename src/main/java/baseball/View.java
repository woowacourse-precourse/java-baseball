package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_SENTNECE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String RESTART_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXIT_SENTENCE = "게임 종료";

    View() {}

    void gameStartText() {
        System.out.println(START_SENTENCE);
    }

    String numberInputText() {
        String number = "";

        System.out.println(INPUT_SENTNECE);
        number = Console.readLine();

        return number;
    }

    void gameResultOutputText(String text) {
        System.out.println(text);
    }

    String victoryOutputText() {
        String number = "";

        System.out.println(CORRECT_SENTENCE + "\n" + RESTART_SENTENCE);
        number = Console.readLine();

        if(number.equals("1") == false && number.equals("2") == false) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    void gameEnd() {
        System.out.println(EXIT_SENTENCE);
    }
}
