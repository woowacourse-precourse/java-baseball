package baseball.baseballgame.balls;

import java.util.EnumMap;

public enum JudgementType {
    STRIKE, BALL, NOTHING;

    public static EnumMap<JudgementType, Integer> creatEnumMap() {
        EnumMap<JudgementType, Integer> ballReport = new EnumMap<>(JudgementType.class);
        ballReport.put(JudgementType.STRIKE, 0);
        ballReport.put(JudgementType.BALL, 0);
        ballReport.put(JudgementType.NOTHING, 0);
        return ballReport;
    }
}
