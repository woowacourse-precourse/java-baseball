package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class GenerateRandomNumber {
    private static final int SIZE = 3;
    private static final int MAX = 9;
    private static final int MIN = 1;
    private List<Integer> eachdigit;

    public List<Integer> getDigits() {

        return this.eachdigit;
    }

    public void setRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        this.eachdigit = computerNumber;
    }


}


