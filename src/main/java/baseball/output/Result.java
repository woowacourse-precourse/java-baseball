package baseball.output;

import java.util.Arrays;

public enum Result {

	NOTHING("00", "낫싱"),
	ZERO_STRIKE_ONE_BALL("01", "1볼"),
	ZERO_STRIKE_TWO_BALL("02", "2볼"),
	ZERO_STRIKE_THREE_BALL("03", "3볼"),
	ONE_STRIKE_ZERO_BALL("10", "1스트라이크"),
	ONE_STRIKE_ONE_BALL("11", "1볼 1스트라이크"),
	ONE_STRIKE_TWO_BALL("12", "2볼 1스트라이크"),
	TWO_STRIKE_ZERO_BALL("20", "2스트라이크"),
	TWO_STRIKE_ONE_BALL("21", "1볼 2스트라이크"),
	THREE_STRIKE_ZERO_BALL("30", "3스트라이크");


	private String score;
	private String message;

	Result(String score, String message) {
		this.score = score;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public static String getResult(String score) {
		Result result = Arrays.stream(Result.values())
				.filter(rs -> rs.score.equals(score))
				.findAny().orElse(Result.NOTHING);
		return result.getMessage();
	}
}