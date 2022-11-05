package baseball.view;

import baseball.dto.BallCountDto;

public class GameResultView {

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
        sb.append(ballCountDto.getStrike()).append(BallState.STRIKE.label()).append(ballCountDto.getBall()).append(BallState.BALL.label());
        System.out.println(sb);
    }
}
