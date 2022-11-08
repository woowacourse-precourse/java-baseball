package baseball.model.balls;

import java.util.EnumMap;

public enum JudgementType {
    STRIKE, BALL, NOTHING;

    public static final int DEFAULT_VALUE = 0;

    public static EnumMap<JudgementType, Integer> creatEnumMap() {
        EnumMap<JudgementType, Integer> ballReport = new EnumMap<>(JudgementType.class);
        ballReport.put(JudgementType.STRIKE, DEFAULT_VALUE);
        ballReport.put(JudgementType.BALL, DEFAULT_VALUE);
        ballReport.put(JudgementType.NOTHING, DEFAULT_VALUE);
        return ballReport;
    }
}
