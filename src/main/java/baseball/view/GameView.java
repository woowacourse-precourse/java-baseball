package baseball.view;

import baseball.validation.InputValidation;

public class GameView {
    private final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String GAME_SET = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final String BALL = "볼 ";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String CMD_CONTINUE = "1";
    private final String CMD_HALT = "2";

    private final InputValidation inputValidation;

    public GameView(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public void announceStart() {
        System.out.println(GAME_START);
    }

    public String getInput() {
        System.out.print(INPUT_NUMBER);
        String input = readLine();
        inputValidation.validateNumber(input);
        return input;
    }

    public void ballsAndStrikes(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }

        if (ball != 0) {
            sb.append(ball).append(BALL);
        }
        if (strike != 0) {
            sb.append(strike).append(STRIKE);
        }
        System.out.println(sb);
    }

    public void announceGameSet() {
        System.out.println(GAME_SET);
    }

    public boolean isRestart(String input) {
        if (input.equals(CMD_CONTINUE)) {
            return true;
        }
        if (input.equals(CMD_HALT)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

}
