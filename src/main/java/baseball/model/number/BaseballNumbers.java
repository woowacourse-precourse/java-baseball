package baseball.model.number;

import static baseball.model.Constant.DUPLICATE_NUMBER_EXCEPTION;
import static baseball.model.Constant.GAME_NUMBERS_SIZE;
import static baseball.model.Constant.INPUT_SIZE_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    List<BaseballNumber> ballNumbers;

    public BaseballNumbers(String numberString) {
        this.ballNumbers = new ArrayList<>();
        validateSize(numberString);
        createBaseballNumber(numberString);
        validateDuplicateNumbers();
    }

    public BaseballNumbers(List<Integer> ballNumbers) {
        this.ballNumbers = new ArrayList<>();
        createBaseballNumber(ballNumbers);
    }

    private void validateSize(String uncheckNumbers) {
        if (uncheckNumbers.length() != GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INPUT_SIZE_EXCEPTION);
        }
    }

    private void createBaseballNumber(String uncheckNumbers) {
        for (int index = 0; index < uncheckNumbers.length(); index++) {
            char uncheckNumber = uncheckNumbers.charAt(index);
            BaseballNumber baseballNumber = new BaseballNumber(uncheckNumber);
            ballNumbers.add(baseballNumber);
        }
    }

    private void createBaseballNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            ballNumbers.add(baseballNumber);
        }
    }

    private void validateDuplicateNumbers() {
        for (int index = 0; index < ballNumbers.size(); index++) {
            if(isDuplicateNumbers(index)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
            }
        }
    }

    private boolean isDuplicateNumbers(int index) {
        BaseballNumber baseballNumber = ballNumbers.get(index);
        for(int nextIndex = index+1; nextIndex < ballNumbers.size(); nextIndex++) {
            BaseballNumber nextBaseballNumber = ballNumbers.get(nextIndex);
            if(baseballNumber.equals(nextBaseballNumber)){
                return true;
            }
        }
        return false;
    }

    public int getStrike(BaseballNumbers otherBaseballNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            BaseballNumber baseballNumber = ballNumbers.get(i);
            BaseballNumber otherBaseballNumber = otherBaseballNumbers.ballNumbers.get(i);
            if (baseballNumber.equals(otherBaseballNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBall(BaseballNumbers otherBaseballNumbers) {
        List<BaseballNumber> otherBaseballNumberList = otherBaseballNumbers.ballNumbers;
        int ballCount = 0;
        for (int baseballIndex = 0; baseballIndex < GAME_NUMBERS_SIZE; baseballIndex++) {
            BaseballNumber baseballNumber = ballNumbers.get(baseballIndex);
            int otherBaseballIndex = otherBaseballNumberList.indexOf(baseballNumber);
            if (otherBaseballIndex >= 0 && baseballIndex != otherBaseballIndex) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean isNothing(BaseballNumbers otherBaseballNumbers) {
        List<BaseballNumber> otherBaseballNumberList = otherBaseballNumbers.ballNumbers;
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            BaseballNumber otherBaseballNumber = otherBaseballNumberList.get(i);
            boolean isSameNumber = ballNumbers.contains(otherBaseballNumber);
            if (isSameNumber) {
                return false;
            }
        }
        return true;
    }
}
