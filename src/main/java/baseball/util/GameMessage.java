package baseball.util;

import baseball.domain.StrikeAndBallDomain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum GameMessage {
    START_MASSAGE("숫자 야구 게임을 시작합니다.\n", (x) -> false),
    INPUT_NUMBER("숫자를 입력해주세요 : ", (x) -> false),
    BALL_AND_STRIKE("%d볼 %d스트라이크\n", (StrikeAndBallDomain x) -> (
            (x.getStrike() > Digits.ZERO.getDigit() || x.getBall() > Digits.ZERO.getDigit())
                    && (x.getStrike() < Digits.SIZE.getDigit()))
    ),
    NOTHING("낫싱\n", (StrikeAndBallDomain x) -> (
            (x.getStrike() == Digits.ZERO.getDigit())
                    && (x.getBall() == Digits.ZERO.getDigit()))
    ),
    THREE_STRIKE("3스트라이크\n", (StrikeAndBallDomain x) -> x.getStrike() == Digits.SIZE.getDigit()),
    ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", (x) -> false),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", (x) -> false);

    private String massage;
    private final Predicate<StrikeAndBallDomain> predicate;

    GameMessage(String massage, Predicate<StrikeAndBallDomain> predicate) {
        this.massage = massage;
        this.predicate = predicate;
    }

    private boolean test(StrikeAndBallDomain strikeAndBallDomain) {
        return predicate.test(strikeAndBallDomain);
    }

    /*값이 계속 바뀌기 때문에 초기화 필수*/
    private static void initMessage(){
        GameMessage.BALL_AND_STRIKE.setMassage("%d볼 %d스트라이크\n");
    }

    public static GameMessage findStrikeAndBallMessage(StrikeAndBallDomain strikeAndBallDomain) {
        initMessage();

        return Arrays.stream(GameMessage.values())
                .filter(gameMassage -> gameMassage.test(strikeAndBallDomain))
                .peek(m -> {
                    if (m == BALL_AND_STRIKE) {
                        makeBallAndStrikeSentence(strikeAndBallDomain);
                    }
                })
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static GameMessage makeBallAndStrikeSentence(StrikeAndBallDomain strikeAndBallDomain) {
        String ballAndStrike = GameMessage.BALL_AND_STRIKE.getMassage();
        ballAndStrike = String.format(
                ballAndStrike,
                strikeAndBallDomain.getBall(),
                strikeAndBallDomain.getStrike()
        );
        GameMessage.BALL_AND_STRIKE.setMassage(ballAndStrike);
        return GameMessage.BALL_AND_STRIKE;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
