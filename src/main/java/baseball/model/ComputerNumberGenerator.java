package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerNumberGenerator {
    public List<Integer> numGenerate(List<Integer> computerNum) {
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
