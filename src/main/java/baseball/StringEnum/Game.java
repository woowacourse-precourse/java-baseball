package baseball.StringEnum;

import baseball.domain.BaseballGame.Ball;
import baseball.domain.BaseballGame.Restart;

public enum Game {
    START {
        @Override
        public String toString() {
            return "숫자 야구 게임을 시작합니다.";
        }
    },
    INPUT {
        @Override
        public String toString() {
            return "숫자를 입력해주세요 : ";
        }
    },
    END {
        @Override
        public String toString() {
            return String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Ball.COUNT.getValue());
        }
    },
    RESTART {
        @Override
        public String toString() {
            return String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", Restart.RESTART.getValue(), Restart.END.getValue());
        }
    }

}
