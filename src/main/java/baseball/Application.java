package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumbers = new ArrayList<>();
        makeRandomNumbers(computerNumbers);
        List<Integer> playerNumbers = IOUtil.getNumbersFromPlayer();
    }

    public static void makeRandomNumbers(List<Integer> computerNumbers) {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
