package baseball;

import baseball.Output.Message;

import java.util.List;

public class HintGenerator {

    private static final int UNIT_DIVISION = 10;
    private static final int MAX_DIGIT = 2;
    public static String generateHint(Integer userInput, List<Integer> randomNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        int division = 1;

        for (int digit = 0; digit <= MAX_DIGIT; digit++, division *= UNIT_DIVISION)
        {
            int number = (userInput / division) % UNIT_DIVISION;

            if (isStrike(number, randomNumber,MAX_DIGIT - digit))
            {
                strikeCount++;
            } else if (isBall(number, randomNumber))
            {
                ballCount++;
            }
        }

        return getHintMessage(ballCount,strikeCount);
    }

    private static String getHintMessage(int ballCount,int strikeCount)
    {
        if (strikeCount == 0 && ballCount == 0)
        {
            return Message.getNothingMessage();
        }
        else if(strikeCount == 0)
        {
            return Message.getBallMessage(ballCount);
        }
        else if(ballCount == 0)
        {
            return Message.getStrikeMessage(strikeCount);
        }

        return Message.getBallAndStrikeMessage(ballCount,strikeCount);
    }

    private static Boolean isBall(int number,List<Integer> randomNumber)
    {
        if(randomNumber.contains(number)) return true;

        return false;
    }

    private static Boolean isStrike(int number,List<Integer> randomNumber,int index)
    {
        if(randomNumber.get(index) == number) return true;

        return false;
    }



}
