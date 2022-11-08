package baseball;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Message.*;

public class UserNumber {
    public List<Integer> validate(String input) {

        Set<Integer> inputSet = new HashSet<>();
        CharacterIterator it = new StringCharacterIterator(input);

        while (it.current() != CharacterIterator.DONE) {
            if (!Character.isDigit(it.current())) {
                throw new IllegalArgumentException();
            }
            inputSet.add(Character.getNumericValue(it.current()));
        }

        if(inputSet.size() != 3 || inputSet.contains(Integer.valueOf(0))){
            throw new IllegalArgumentException();
        }

        List<Integer> inputDigits = new ArrayList<>(inputSet);

        return inputDigits;
    }

    public void judge(List<Integer> inputDigits, List<Integer> secretDigits) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < INPUT_SIZE; i++) {
            ballCount += judgeBall(inputDigits.get(i),secretDigits,i);
            strikeCount += judgeStrike(inputDigits.get(i), secretDigits.get(i));
        }

        printJudgement(ballCount, strikeCount);
    }


    private int judgeBall(Integer inputDigit, List<Integer> secretDigits, int index) {

        Integer secretDigit = secretDigits.get(index);

        if (inputDigit != secretDigit && secretDigits.contains(inputDigit)) {
            return 1;
        }

        return 0;
    }

    private int judgeStrike(Integer inputDigit, Integer secretDigit) {

        if (inputDigit == secretDigit) {
            return 1;
        }

        return 0;
    }

    private static void printJudgement(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(HINT_NOTHING);
            return;
        }

        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount +HINT_BALL);
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(ballCount +HINT_BALL+" ");
        }

        if (strikeCount != 0) {
            System.out.println(strikeCount +HINT_STRIKE);
        }
    }
}
