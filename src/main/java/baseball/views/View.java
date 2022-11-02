package baseball.views;

import baseball.model.CompareResultDto;

public class View {
	public void startMessage() {
		Printer.printGameStartMessage();
	}

	public String baseballInput() {
		Printer.printPlzEnterTheBaseballNumberMessage();
		String userBaseBallNumber = Reader.getUserBaseBallNumber();

		return userBaseBallNumber;
	}

	public void hintMessage(CompareResultDto compareResult) {
		int ballCnt = compareResult.getBallCnt();
		int strikeCnt = compareResult.getStrikeCnt();

		if (isNoting(ballCnt, strikeCnt)) {
			Printer.printHintNothingMessage();
			return;
		}

		Printer.printHintCountMessage(ballCnt, strikeCnt);
	}

	private boolean isNoting(int ballCnt, int strikeCnt) {
		return ballCnt + strikeCnt == 0;
	}

	public int endMessage() {
		Printer.printGameEndingMessage();
		Printer.printGameContinueQuestionMessage();

		String proceed = Reader.getUserGameProceedNumber();

		return Integer.parseInt(proceed);
	}
}
