package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    public static final int GAME_NUMBER_LENGTH = 3;

    private final List<Integer> numberListByDigit;

    public static GameNumber makeInstance(String input) {
        InputValidator.validateGameNumberInput(input);

        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            integerList.add(input.charAt(i) - '0');
        }

        return new GameNumber(integerList);
    }

    public static GameNumber getRandomInstance() {
        return new GameNumber(makeRandomOneDigitIntListWithNoDuplicate());
    }

    private GameNumber(List<Integer> integerList) {
        numberListByDigit = new ArrayList<>();
        numberListByDigit.addAll(integerList);
    }

    private static List<Integer> makeRandomOneDigitIntListWithNoDuplicate() {
        List<Integer> output = new ArrayList<>();
        while (output.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!output.contains(randomNumber)) {
                output.add(randomNumber);
            }
        }

        return output;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            result.append(numberListByDigit.get(i));
        }

        return result.toString();
    }

    public BallStrikeResult countBallStrike(GameNumber oth) {
        BallStrikeResult result = new BallStrikeResult();
        for(int i = 0; i < this.numberListByDigit.size(); i++) {
            countBallStrikeOnIdx(result, oth, i);
        }
        return result;
    }

    private void countBallStrikeOnIdx(BallStrikeResult result, GameNumber oth, int idx) {
        int currentDigit = this.numberListByDigit.get(idx);

        if(currentDigit == oth.numberListByDigit.get(idx)) {
            result.addStrikeCount();
            return;
        }
        if(oth.numberListByDigit.contains(currentDigit)) {
            result.addBallCount();
        }
    }
}