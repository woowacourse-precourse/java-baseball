package custom.service.vo;

public enum GameStatus {
    KEEP("계속 진행"),
    RETRY("재확인"),
    EXIT("종료");

    private final String name;

    GameStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
