package baseball;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

import static baseball.Message.*;

public class UserNumber {

    private List<Integer> inputDigits;
    private List<Integer> secretDigits;

    public List<Integer> validate(String input) {

        LinkedHashSet<Integer> inputSet = inputStringToLinkedHashSet(input);

        isDigitsValid(inputSet);

        inputDigits = new ArrayList<>(inputSet);

        return inputDigits;
    }

    private static LinkedHashSet<Integer> inputStringToLinkedHashSet(String input) {

        LinkedHashSet<Integer> inputSet = new LinkedHashSet<>();

        CharacterIterator it = new StringCharacterIterator(input);

        while (it.current() != CharacterIterator.DONE) {

            if (!Character.isDigit(it.current())) {
                throw new IllegalArgumentException();
            }

            inputSet.add(Character.getNumericValue(it.current()));
            it.next();
        }

        return inputSet;
    }

    private static void isDigitsValid(LinkedHashSet<Integer> inputSet) {
        if (inputSet.size() != INPUT_SIZE || inputSet.contains(Integer.valueOf(0))) {
            throw new IllegalArgumentException();
        }
    }

    public void setSecretDigits(List<Integer> secretDigits) {
        this.secretDigits = secretDigits;
    }

    public int judge() {

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < INPUT_SIZE; i++) {
            ballCount += judgeBall(i);
            strikeCount += judgeStrike(i);
        }

        printJudgement(ballCount, strikeCount);

        return strikeCount;
    }


    private int judgeBall(int index) {

        Integer inputDigit = inputDigits.get(index);
        Integer secretDigit = secretDigits.get(index);

        if (inputDigit != secretDigit && secretDigits.contains(inputDigit)) {
            return 1;
        }

        return 0;
    }

    private int judgeStrike(int index) {

        Integer inputDigit = inputDigits.get(index);
        Integer secretDigit = secretDigits.get(index);

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
            System.out.println(ballCount + HINT_BALL);
            return;
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(ballCount + HINT_BALL + " ");
        }

        if (strikeCount != 0) {
            System.out.println(strikeCount + HINT_STRIKE);
        }
    }
}
