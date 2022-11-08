package baseball.gameComponents;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateNumber(List<Integer> number) {
        if(number.size() != 3) {
            throw new GameException(ExceptionCode.NUMBER_NOT_3_DIGITS);
        }
        for(Integer n : number) {
            if(n <= 0 || n > 9) {
                throw new GameException(ExceptionCode.NUMBER_NOT_IN_RANGE_FROM_1_TO_9);
            }
        }
        Set<Integer> set = new HashSet<>(number);
        if(set.size() != 3) {
            throw new GameException(ExceptionCode.NUMBER_DUPLICATED);
        }
    }

    public void isPositiveNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new GameException(ExceptionCode.NOT_NUMBER);
        }
        if(number <= 0) {
            throw new GameException(ExceptionCode.NUMBER_NOT_IN_RANGE_FROM_1_TO_9);
        }
    }
    public void validateBallsAndStrike(int[] ballsAndStrikes) {
        int balls = ballsAndStrikes[0];
        int strikes = ballsAndStrikes[1];

        if(ballsAndStrikes.length != 2
                || balls < 0 || balls > 3
                || strikes < 0 || strikes > 3|| balls + strikes > 3) {
            throw new GameException(ExceptionCode.BALLS_AND_STRIKES_NOT_VALID);
        }
    }
}
