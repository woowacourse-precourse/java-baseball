package baseball.StringEnum;

import baseball.domain.BaseballGame.Ball;
import baseball.domain.BaseballGame.Restart;

public enum InputExceptionCode {
    NOT_NUMBER_INCLUDE {
        @Override
        public String toString() {
            return "숫자만 입력할 수 있습니다.";
        }
    },
    NOT_3_NUMBERS {
        @Override
        public String toString() {
            return String.format("%d 부터 %d 사이의 %d개의 숫자만 입력할 수 있습니다.", Ball.MIN.getValue(), Ball.MAX.getValue(), Ball.COUNT.getValue());
        }
    },
    NOT_IN_RANGE {
        @Override
        public String toString() {
            return String.format("%d 부터 %d 사이의 %d개의 숫자만 입력할 수 있습니다.", Ball.MIN.getValue(), Ball.MAX.getValue(), Ball.COUNT.getValue());
        }
    },
    DUPLICATE_NUMBER {
        @Override
        public String toString() {
            return String.format("서로 다른 %d개의 숫자만 입력할 수 있습니다.", Ball.COUNT.getValue());
        }
    },
    NOT_RESTART_NUMBER {
        @Override
        public String toString() {
            return String.format("새로 시작 (%d), 종료 (%d) 중 하나 만을 입력 할 수 있습니다.", Restart.RESTART.getValue(), Restart.END.getValue());
        }
    }

}
