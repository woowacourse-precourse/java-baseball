package baseball.view;

public enum GameResult {
	BALL ("볼 "),
	STRIKE ("스트라이크"),
	NOTHING ("낫싱"),
	INIT_RESULT ("");

	private String message;

	GameResult(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
