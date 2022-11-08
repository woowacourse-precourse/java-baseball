package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.constants.Constant.*;

public class Computer {

	private List<Integer> answerBaseballNumberList = new ArrayList<>();
	private List<Integer> playerBaseballNumberList = new ArrayList<>();
	private int strikeCnt = 0;
	private int ballCnt = 0;

	public Computer() {
		init();
	}

	public void init() {
		initCount();
		answerBaseballNumberList = generateRandomNumberList();
	}

	public void initCount() {
		this.strikeCnt = 0;
		this.ballCnt = 0;
	}

	protected List<Integer> generateRandomNumberList() {
		Set<Integer> randomNumbers = new LinkedHashSet<>();

		while (randomNumbers.size() != MAX_ANSWER_COUNT) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
			randomNumbers.add(randomNumber);
		}

		return new ArrayList<>(randomNumbers);
	}

	public boolean isAnswer(Player player) {
		playerBaseballNumberList = player.getCurrentUserAnswer();
		return IntStream.range(MIN_START_SEQ, MAX_ANSWER_COUNT)
				.allMatch(this::isSameNumber);
	}

	private boolean isSameNumber(int seq) {
		return playerBaseballNumberList.get(seq).compareTo(answerBaseballNumberList.get(seq)) == 0;
	}

	public CompareResultDto countBallAndStrike(Player player) {
		initCount();

		playerBaseballNumberList = player.getCurrentUserAnswer();

		for (int answerBaseballNumberSeq = 0; answerBaseballNumberSeq < 3; answerBaseballNumberSeq++) {
			increaseCount(answerBaseballNumberSeq);
		}

		return new CompareResultDto(ballCnt, strikeCnt);
	}

	private void increaseCount(int answerBaseballNumberSeq) {
		int answer = answerBaseballNumberList.get(answerBaseballNumberSeq);

		IntStream.range(MIN_START_SEQ, MAX_ANSWER_COUNT)
				.takeWhile(playerBaseballNumberSeq ->
						increaseStrikeCntIfBothSameSeqAndValue(answerBaseballNumberSeq, playerBaseballNumberSeq))
				.forEach(playerBaseballNumberSeq ->
						increaseBallCntIfBothSameValue(answer, playerBaseballNumberSeq));
	}

	private void increaseBallCntIfBothSameValue(int answer, int playerBaseballNumberSeq) {
		int playerAnswer = playerBaseballNumberList.get(playerBaseballNumberSeq);

		if (answer == playerAnswer) {
			ballCnt++;
		}
	}

	private boolean increaseStrikeCntIfBothSameSeqAndValue(int answerBaseballNumberSeq, int playerBaseballNumberSeq) {
		if (isStrike(answerBaseballNumberSeq, playerBaseballNumberSeq)) {
			strikeCnt++;
			return false;
		}

		return true;
	}

	private boolean isStrike(int answerBaseballNumberSeq, int playerBaseballNumberSeq) {
		int answer = answerBaseballNumberList.get(answerBaseballNumberSeq);
		int playerAnswer = playerBaseballNumberList.get(playerBaseballNumberSeq);

		return playerBaseballNumberSeq == answerBaseballNumberSeq && answer == playerAnswer;
	}
}
