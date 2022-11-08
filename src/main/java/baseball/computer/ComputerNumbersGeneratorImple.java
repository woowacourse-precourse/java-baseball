package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class ComputerNumbersGeneratorImple implements ComputerNumbersGenerator {
    @Override
    public List<Integer> autoCreateNumbers() {
        List<Integer> numbers = new ArrayList<>(3);

        while (numbers.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }

        }
        return numbers;
    }

    @Override
    public List<Integer> createNumbers(List<Integer> numbers) {
        return numbers;
    }

}
