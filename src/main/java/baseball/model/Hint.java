package baseball.model;

public enum Hint {

    NOTHING() {
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return "낫싱";
        }
    },
    BALL_AND_STRIKE() {
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return ballCnt + "볼 " + strikeCnt + "스트라이크\n";
        }
    },
    ONLY_BALL(){
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return ballCnt + "볼\n";
        }
    },
    ONLY_STRIKE(){
        @Override
        public String printHintMessage(int ballCnt, int strikeCnt) {
            return strikeCnt + "스트라이크\n";
        }
    };

    abstract public String printHintMessage(int ballCnt, int strikeCnt) ;
}