package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomNumberGenerator {
    ArrayList<Integer> numberList= new ArrayList<>();

    public RandomNumberGenerator(){
        generateRandomNumber(this.numberList);
    }
    static void generateRandomNumber(ArrayList<Integer> numberList) {
        while (numberList.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }
}
