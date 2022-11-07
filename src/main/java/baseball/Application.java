package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> generateRandomNumber() {
        List<Integer> generatedNumber = new ArrayList<>();
        while (generatedNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumber.contains(randomNumber)){
                generatedNumber.add(randomNumber);
            }
        }
        return generatedNumber;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
