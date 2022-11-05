package baseball.view;

import baseball.dto.BallCountDto;
import camp.nextstep.edu.missionutils.Console;

public class GameResultView {

    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_GAME_STATE_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void showScore(BallCountDto ballCountDto) {
        StringBuilder sb = new StringBuilder();
        if (ballCountDto.getBall() == 0 && ballCountDto.getStrike() == 0) {
            sb.append(BallState.NOTHING.label());
            System.out.println(sb);
            return;
        }
        if (ballCountDto.getStrike() == 0) {
            sb.append(ballCountDto.getBall()).append(BallState.BALL.label());
            System.out.println(sb);
            return;
        }
        if (ballCountDto.getBall() == 0) {
            sb.append(ballCountDto.getStrike()).append(BallState.STRIKE.label());
            System.out.println(sb);
            return;
        }
        sb.append(ballCountDto.getBall())
                .append(BallState.BALL.label())
                .append(" ")
                .append(ballCountDto.getStrike())
                .append(BallState.STRIKE.label());
        System.out.println(sb);
    }

    public void checkThreeStrike(BallCountDto ballCountDto) {
        if (ballCountDto.getStrike() == 3) {
            System.out.println(GAME_END_MESSAGE);
        }
    }

    public int checkRestartGame() {
        System.out.println(INPUT_GAME_STATE_COMMAND_MESSAGE);

        String inputRestartString = Console.readLine();
        int inputRestartNumber = Integer.parseInt(inputRestartString);

        validateInputNumber(inputRestartNumber);
        return inputRestartNumber;
    }

    private void validateInputNumber(int inputRestartNumber) {
        if (!(inputRestartNumber == 1 || inputRestartNumber == 2)) {
            throw new IllegalArgumentException();
        }
    }
}
