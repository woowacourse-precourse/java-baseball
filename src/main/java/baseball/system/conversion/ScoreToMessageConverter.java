package baseball.system.conversion;

import baseball.dto.Score;

public class ScoreToMessageConverter implements Converter<Score, String> {

    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String BALL_MESSAGE_FORMAT = "%d볼 ";
    public static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크";

    @Override
    public String convert(Score target) {
        Integer ballScore = target.getBallScore();
        Integer strikeScore = target.getStrikeScore();

        if (ballScore == 0 && strikeScore == 0) {
            return NOTHING_MESSAGE;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (ballScore != 0) {
            stringBuilder.append(String.format(BALL_MESSAGE_FORMAT, ballScore));
        }
        if (strikeScore != 0) {
            stringBuilder.append(String.format(STRIKE_MESSAGE_FORMAT, strikeScore));
        }

        return stringBuilder.toString();
    }
}
