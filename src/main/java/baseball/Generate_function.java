package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Generate_function {
    public String generate_numbers() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }

        return Transformation_function.Integer_list_2_String(digits);
    }
}
