package baseball.util;

import java.util.Arrays;

public enum ExecuteStatus {
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