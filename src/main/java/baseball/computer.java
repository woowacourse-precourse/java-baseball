package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class computer {
    public static List<Integer> computerNumber(){
        List<Integer> computerBaseballNumber = new ArrayList<>();
        while (computerBaseballNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballNumber.contains(randomNumber)){
                computerBaseballNumber.add(randomNumber);
            }
        }
        return computerBaseballNumber;
    }
}
