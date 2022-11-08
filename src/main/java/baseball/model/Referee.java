package baseball.model;

import java.util.List;

import baseball.utility.Utility;

public class Referee {
    public String judge(int userQuestion, List<Integer> computerNumber){
        int ball = 0, strike = 0;

        for(int digit = 2; digit >= 0; --digit, userQuestion /= 10){
            if(isExist(userQuestion % 10, computerNumber) && !isRightLocation(digit, userQuestion % 10, computerNumber))
                ++ball;
            else if(isExist(userQuestion % 10, computerNumber) && isRightLocation(digit, userQuestion % 10, computerNumber))
                ++strike;
        }
        
        if(strike == 0){
            if(ball == 0)
                return Utility.NOTHING_MESSAGE;
            else
                return String.format(Utility.BALL_MESSAGE, ball);
        }
        else{
            if(ball == 0)
                return String.format(Utility.STRIKE_MESSAGE, strike);
            else
                return String.format(Utility.BALL_MESSAGE, ball) + " " + String.format(Utility.STRIKE_MESSAGE, strike);
        }
    }

    private boolean isExist(int questionDigitNumber, List<Integer> computerNumber){
        for(int digit = 0; digit < Utility.DIGIT_LENGTH; ++digit)
            if(questionDigitNumber == computerNumber.get(digit))
                return true;
        return false;
    }

    private boolean isRightLocation(int questionDigit, int questionDigitNumber, List<Integer> computerNumber){
        if(computerNumber.get(questionDigit) == questionDigitNumber) return true;
        return false;
    }
}