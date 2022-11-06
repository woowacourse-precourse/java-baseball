package custom.dto;

import custom.service.vo.GameStatus;

public class Response {

    private final GameStatus gameStatus;
    private final String message;

    public Response(GameStatus gameStatus, String message) {
        this.gameStatus = gameStatus;
        this.message = message;
    }

    public static Response endOf(String message) {
        return new Response(GameStatus.EXIT, message);
    }

    public static Response keepOf(String message) {
        return new Response(GameStatus.KEEP, message);
    }

    public static Response retryOf(String message) {
        return new Response(GameStatus.RETRY, message);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public String getMessage() {
        return message;
    }
}
