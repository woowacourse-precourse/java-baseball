package baseball;

import static baseball.Constraint.INPUT_NUMER_MENT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerNums implements Nums{
    List<Integer> nums = new ArrayList<>();

    public PlayerNums() {

    }

    @Override
    public void setNums() throws IllegalArgumentException{
        System.out.print("\n"+INPUT_NUMER_MENT);
        String input = Console.readLine().trim();
        isIllegal(input);
        this.nums = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());

    }

    private void isIllegal(String input) throws IllegalArgumentException {
        if (isNot3Len(input) || isNotNum(input) || isDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(String input) {
        return new HashSet<String>(List.of(input.split(""))).size() != 3;
    }

    private boolean isNotNum(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isNot3Len(String input) {
        return input.length() != 3;
    }

    @Override
    public List<Integer> getNums() {
        return this.nums;
    }
}
