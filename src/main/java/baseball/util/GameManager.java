package baseball.util;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class GameManager {

    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void execute() {
        do {
            game.play();
        } while (restart() == ExecuteStatus.RESTART);
    }

    private ExecuteStatus restart() {
        GamePrinter.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return ExecuteStatus.from(Console.readLine());
    }

    enum ExecuteStatus {
        RESTART("1"), END("2");

        private final String status;

        ExecuteStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public static ExecuteStatus from(String status) {
            return Arrays.stream(ExecuteStatus.values())
                .filter(e -> e.getStatus().equals(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상태 입력입니다. 입력: " + status));
        }
    }
}
