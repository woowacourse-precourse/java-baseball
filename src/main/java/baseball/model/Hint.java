package baseball.model;

import java.util.Arrays;

public enum Hint {

    NOTHING(false,false) {
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return "낫싱";
        }
    },
    BALL_AND_STRIKE(true,true) {
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return ballCnt + "볼 " + strikeCnt + "스트라이크\n";
        }
    },
    ONLY_BALL(true,false){
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return ballCnt + "볼\n";
        }
    },
    ONLY_STRIKE(false, true){
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return strikeCnt + "스트라이크\n";
        }
    };

    private boolean isBallExist;
    private boolean isStrikeExist;

    Hint (boolean isBallExist, boolean isStrikeExist) {
        this.isBallExist = isBallExist;
        this.isStrikeExist = isStrikeExist;
    }

    abstract public String printHintMessage(int ballCnt, int strikeCnt) ;

    public static Hint findHint(int ballCnt, int strikeCnt) {
        boolean isInputBallExist = validateExist(ballCnt);
        boolean isInputStrikeExist = validateExist(strikeCnt);

        return Arrays.stream(values())
                .filter(i -> i.isStrikeExist == isInputStrikeExist)
                .filter(i -> i.isBallExist == isInputBallExist)
                .findFirst()
                .orElse(null);
    }

    public static boolean validateExist(int cnt) {
        return cnt > 0;
    }
}