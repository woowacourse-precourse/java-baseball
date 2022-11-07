package baseball;

import baseball.Messages.ErrorMessages;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class Pitcher {

    private List<Integer> pitcherNumbers = new ArrayList<>();

    Pitcher(String input) {
        setPitcherNumbers(input);
    }

    public void setPitcherNumbers(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ErrorMessages.STRING_OUT_OF_BOUNDS);
        }
        String[] nums = input.split("");
        if (nums[0].equals(nums[1]) || nums[1].equals(nums[2])) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBERS);
        }

        for (String num : nums) {
            if (!Character.isDigit(num.charAt(0))) {
                throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER);
            }
            pitcherNumbers.add(Integer.parseInt(num));
        }
    }

    public List<Integer> getPitcherNumbers() {
        return pitcherNumbers;
    }
}
