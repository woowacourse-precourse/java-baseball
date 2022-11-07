package baseball;

import java.util.Arrays;
import java.util.function.Predicate;

public enum GameMassage {
    START_MASSAGE("숫자 야구 게임을 시작합니다.\n", (x) -> false),
    INPUT_NUMBER("숫자를 입력해주세요 : ", (x) -> false),
    NOT_ANSWER("%d볼 %d스트라이크\n", (StrikeAndBall x) -> (
            (x.strike > Digits.ZERO.getDigit() || x.ball > Digits.ZERO.getDigit())
                    && (x.strike < Digits.SIZE.getDigit()))
    ),
    NOTHING("낫싱\n", (StrikeAndBall x) -> (
            (x.strike == Digits.ZERO.getDigit())
                    && (x.ball == Digits.ZERO.getDigit()))
    ),
    ALL_STRIKE("3스트라이크\n", (StrikeAndBall x) -> x.strike == Digits.SIZE.getDigit()),
    ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", (x) -> false),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", (x) -> false);

    private String massage;
    private final Predicate<StrikeAndBall> predicate;

    GameMassage(String massage, Predicate<StrikeAndBall> predicate) {
        this.massage = massage;
        this.predicate = predicate;
    }

    private boolean test(StrikeAndBall strikeAndBall) {
        return predicate.test(strikeAndBall);
    }

    public static GameMassage findStrikeAndBallMessage(StrikeAndBall strikeAndBall) {
        return Arrays.stream(GameMassage.values())
                .filter(gameMassage -> gameMassage.test(strikeAndBall))
                .peek(m -> {
                    if (m == NOT_ANSWER) {
                        makeBallAndStrikeSentence(strikeAndBall);
                    }
                })
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static GameMassage makeBallAndStrikeSentence(StrikeAndBall strikeAndBall) {
        String ballAndStrike = GameMassage.NOT_ANSWER.getMassage();
        ballAndStrike = String.format(
                ballAndStrike,
                strikeAndBall.ball,
                strikeAndBall.strike
        );
        GameMassage.NOT_ANSWER.setMassage(ballAndStrike);
        return GameMassage.NOT_ANSWER;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
