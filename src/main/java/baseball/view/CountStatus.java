package baseball.view;

public enum Ball {
    NO_COUNT {
        boolean calculator(int ball, int strike) {
            return ball == 0 && strike == 0;
        }
    },
    ONLY_BALL_COUNT {
        boolean calculator(int ball, int strike) {
            return ball != 0 && strike == 0;
        }
    },
    ONLY_STRIKE_COUNT {
        boolean calculator(int ball, int strike) {
            return ball == 0 && strike != 0;
        }
    },
    BALL_AND_STRIKE_COUNT {
        boolean calculator(int ball, int strike) {
            return ball != 0 && strike != 0;
        }
    };

    abstract boolean calculator(int ball, int strike);
}
