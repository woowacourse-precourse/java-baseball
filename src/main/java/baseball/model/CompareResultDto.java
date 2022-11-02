package baseball.model;

public class CompareResultDto {
	private int ballCnt;
	private int strikeCnt;

	public CompareResultDto(int ballCnt, int strikeCnt) {
		this.ballCnt = ballCnt;
		this.strikeCnt = strikeCnt;
	}

	public int getStrikeCnt() {
		return strikeCnt;
	}

	public int getBallCnt() {
		return ballCnt;
	}
}
