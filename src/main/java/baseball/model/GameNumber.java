package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    public static final int GAME_NUMBER_LENGTH = 3;

    private final List<Integer> numberListByDigit;

    private GameNumber(List<Integer> integerList) {
        numberListByDigit = new ArrayList<>();
        numberListByDigit.addAll(integerList);
    }

    public static GameNumber makeInstance(String input) {
        InputValidator.validateGameNumberInput(input);

        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            integerList.add(input.charAt(i) - '0');
        }

        return new GameNumber(integerList);
    }

    public static GameNumber makeRandomInstance() {
        return new GameNumber(makeRandomOneDigitIntListWithNoDuplicate());
    }

    public BallStrikeResult countBallStrike(GameNumber oth) {
        BallStrikeResult result = new BallStrikeResult();
        for(int i = 0; i < this.numberListByDigit.size(); i++) {
            countBallStrikeOnIdx(result, oth, i);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            result.append(numberListByDigit.get(i));
        }

        return result.toString();
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