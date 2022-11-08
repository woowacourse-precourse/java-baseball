package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    public static final String NON_BALL_COUNTS_ALERT = "입력된 정보가 없습니다.";
    public static final String BALL_COUNTS_ALERT = "현재 입력한 결과입니다.\r\n";

    private BaseballNumbers randomNumbers;
    private final List<BallCount> ballCounts = new ArrayList<>();

    public GameBoard() {
        createRandomNumbers();
    }

    public BaseballNumbers createRandomNumbers() {
        if (randomNumbers == null) {
            List<String> randomNumberList = new ArrayList<>();

            randomNumbers = new BaseballNumbers();
            validateMaxSize(randomNumberList);
            randomNumbers.createBaseballNumbers(String.join("", randomNumberList));
            return randomNumbers;
        }
        return randomNumbers;
    }

    public void validateMaxSize(List<String> randomNumberList) {
        while (randomNumberList.size() < BaseballConstants.LAST_INDEX_OF_BASEBALL_NUMBER) {
            putUniqueRandomNumber(randomNumberList);
        }
    }

    public void putUniqueRandomNumber(List<String> randomNumberList) {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        if (!randomNumberList.contains(String.valueOf(randomNumber))) {
            randomNumberList.add(String.valueOf(randomNumber));
        }
    }

    public String processReadline(String readline) {
        BaseballNumbers inputBaseballNumbers = new BaseballNumbers();

        if (!inputBaseballNumbers.createBaseballNumbers(readline)) {
            return showRecords();
        }
        return showBallCount(inputBaseballNumbers);
    }

    public String showRecords() {
        StringBuilder records = new StringBuilder(BALL_COUNTS_ALERT);

        if (checkRecordsInformation()) {
            ballCounts.forEach(record -> records.append(record.toStringRecords()).append("\r\n"));
            return records.toString();
        }
        return NON_BALL_COUNTS_ALERT;
    }

    public boolean checkRecordsInformation() {
        return ballCounts.size() > 0;
    }

    public String showBallCount(BaseballNumbers inputBaseballNumbers) {
        BallCount ballCount = new BallCount();

        ballCount.validateBallCount(randomNumbers, inputBaseballNumbers);
        updateBallCounts(ballCount);
        return ballCount.toString();
    }

    public void updateBallCounts(BallCount ballCount) {
        ballCounts.add(ballCount);
    }

}
