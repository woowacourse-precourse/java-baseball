package baseball.model;

public class MatchDto {

	private final int requestNumber;
	private final int computerNumber;

	private MatchDto(int requestNumber, int computerNumber) {
		this.requestNumber = requestNumber;
		this.computerNumber = computerNumber;
	}

	public static MatchDto of(int requestNumber, int computerNumber) {
		return new MatchDto(requestNumber, computerNumber);
	}

	public int getRequestNumber() {
		return requestNumber;
	}

	public int getComputerNumber() {
		return computerNumber;
	}

}
