package baseball.repository;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.model.gamenumber.ComputerNumber;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberRepository extends ComputerNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public ComputerNumberRepository() {
        super(makeNumberList());
    }

    @Override
    public List<Integer> getNumberList() {
        return super.getNumberList();
    }

    public static int getRandomNumber() {
        return pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static List<Integer> makeNumberList() {
        List<Integer> computerNumberList = new ArrayList<>(NUMBER_DIGITS);
        int index = 0;
        while (index < NUMBER_DIGITS) {
            int randomNumber = getRandomNumber();
            if (!isDuplicate(computerNumberList, randomNumber)) {
                computerNumberList.add(randomNumber);
                index++;
            }
        }
        return computerNumberList;
    }

    public static boolean isDuplicate(List<Integer> computerNumberList, int randomNumber) {
        if (computerNumberList.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}