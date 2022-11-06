package baseball;

import java.util.ArrayList;
import java.util.List;

public class Pitcher {

    private List<Integer> pitcherNumbers = new ArrayList<>();

    Pitcher(String input) {
        setPitcherNumbers(input);
    }

    public void setPitcherNumbers(String input) {
        String[] nums = input.split("");
        for(String num : nums) {
            pitcherNumbers.add(Integer.parseInt(num));
        }
    }

    public List<Integer> getPitcherNumbers() {
        return pitcherNumbers;
    }
}
