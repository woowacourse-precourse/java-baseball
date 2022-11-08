package baseball;

import constant.Texts;

import java.util.ArrayList;
import java.util.List;

public class Checker {
    public void checkLegalNumber(String number) throws IllegalArgumentException {
        if (!this.isIntegerNumeric(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_MISMATCHING + Texts.USER_INPUT_ILLEGAL_NOTICE + Texts.USER_INPUT_ILLEGAL + Texts.GAME_END);
        }
        if (!this.isNumberDigitLegal(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_DIGIT + Texts.USER_INPUT_ILLEGAL_NOTICE + Texts.USER_INPUT_ILLEGAL + Texts.GAME_END);
        }
        if (this.isNumberDuplicated(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_DUPLICATED + Texts.USER_INPUT_ILLEGAL_NOTICE + Texts.USER_INPUT_ILLEGAL + Texts.GAME_END);
        }
        if (this.isContainsZero(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_ZERO + Texts.USER_INPUT_ILLEGAL_NOTICE + Texts.USER_INPUT_ILLEGAL + Texts.GAME_END);
        }
    }

    public boolean isIntegerNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumberDigitLegal(String number) {
        if (number.length() == 3) {
            return true;
        }
        return false;
    }

    public boolean isNumberDuplicated(String number) {
        String[] digits = number.split("");
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i].equals(digits[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isContainsZero(String number) {
        String[] numeric = number.split("");
        for (String s : numeric) {
            if (s.equals("0")) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> checkByDigit(List<Integer> userNumbers, List<Integer> computerNumbers) {
        List<Integer> result = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);
            if (isStrike(userNumber, computerNumber)) {
                strike += 1;
            } else if (isBall(userNumber, computerNumbers)) {
                ball += 1;
            }
        }
        result.add(strike);
        result.add(ball);
        return result;
    }

    public boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    public boolean isBall(int userNumber, List<Integer> computerNumbers) {
        return computerNumbers.contains(userNumber);
    }

    public String checkResult(List<Integer> result) {
        StringBuffer scoreBuffer = new StringBuffer();
        if (isNothing(result)) {
            scoreBuffer.append(Texts.CHECKER_RESULT_NOTTING);
        } else {
            int strike = result.get(0);
            int ball = result.get(1);
            if (ball > 0) {
                scoreBuffer.append(ball);
                scoreBuffer.append(Texts.CHECKER_RESULT_BALL);
                scoreBuffer.append(" ");
            }
            if (strike > 0) {
                scoreBuffer.append(strike);
                scoreBuffer.append(Texts.CHECKER_RESULT_STRIKE);
            }
        }
        return scoreBuffer.toString();
    }

    public boolean isNothing(List<Integer> result) {
        return result.get(0) == 0 && result.get(1) == 0;
    }

}
