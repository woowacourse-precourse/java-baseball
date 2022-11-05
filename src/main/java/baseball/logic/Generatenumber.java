package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Generatenumber {
    private final int range_start = 1;
    private final int range_end = 9;
    private final int input_size =3;
    private List<Integer> randomNum;

    public Generatenumber() {
        randomNum = new ArrayList<>();
    }

    public List<Integer> getNum() {
        return generateNumber();
    }

    public List<Integer> generateNumber() {
        HashSet<Integer> numbers = new LinkedHashSet<>();
        while(numbers.size()<input_size){
            int randomNum = Randoms.pickNumberInRange(range_start, range_end);
            numbers.add(randomNum);
        }
        randomNum = new ArrayList<>(numbers);
        return randomNum;
    }
}
