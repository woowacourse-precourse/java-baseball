package baseball;

public enum GameStatus {
    START("시작", "1"),
    END("종료", "2");
    private final String code;
    private String name = "";

    GameStatus(String name, String code) {
        this.name = name;
        this.code = code;
    }

    String getCode() {
        return this.code;
    }
}
