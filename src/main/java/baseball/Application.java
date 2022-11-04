package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static List<Integer> setComputerNumbers(List<Integer> computerNumbers){

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    public static void main(String[] args) {
        List<Integer> computerNumbers = new ArrayList<>();

        computerNumbers = setComputerNumbers(computerNumbers);

        for(int numbers : computerNumbers) System.out.println(numbers); //난수 출력 확인.
    }
}

