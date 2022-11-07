package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANGE_FIRST = 1;
    private static final int RANGE_LAST = 9;
    private static final int RANGE_RADIX = 10;

    public List<Character> makeRandomNum(int listSize) {
        List<Character> characterList = new ArrayList<>();

        characterList.add(oneRandomNumChar());
        return compareAndAddList(characterList, listSize);
    }

    private List<Character> compareAndAddList(List<Character> characterList, int listSize) {
        char randNumChar;

        while (characterList.size() != listSize) {
            randNumChar = oneRandomNumChar();
            if (!characterList.contains(randNumChar)) {
                characterList.add(randNumChar);
            }
        }
        return characterList;
    }

    private Character oneRandomNumChar() {
        return Character.forDigit(Randoms.pickNumberInRange(RANGE_FIRST, RANGE_LAST), RANGE_RADIX);
    }
}