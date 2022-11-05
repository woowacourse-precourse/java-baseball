package baseball.printer;

import baseball.core.dto.BallStrikeDto;

import java.util.List;

public class ResultMessageGenerator {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";

    private int ballCount;
    private int strikeCount;


    public String generateMessage(BallStrikeDto dto) {
        initCounts(dto);
        String resultMessage;

        if (isNothing()) {
            resultMessage = getNothingMessage();
        } else {
            resultMessage = getBallStrikeResultString();
        }
        return resultMessage;
    }

    private void initCounts(BallStrikeDto dto) {
        this.ballCount = dto.getBallCount();
        this.strikeCount = dto.getStrikeCount();
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    private String getNothingMessage() {
        return NOTHING;
    }

    private String getBallStrikeResultString() {
        String ballString = getBallString();
        String strikeString = getStrikeString();

        return toResultMessage(ballString, strikeString);
    }

    private String getStrikeString() {
        String strikeString = "";
        if (strikeCount != 0) {
            strikeString = String.format(STRIKE, strikeCount);
        }
        return strikeString;
    }

    private String getBallString() {
        String ballString = "";
        if (ballCount != 0) {
            ballString = String.format(BALL, ballCount);
        }
        return ballString;
    }

    private static String toResultMessage(String ballString, String strikeString) {
        return String.join(" ", List.of(ballString, strikeString)).trim();
    }
}
