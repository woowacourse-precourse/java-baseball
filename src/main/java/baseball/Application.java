package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        getComputerNumber(computer);

        List<Integer> user = new ArrayList<>();
        String userNumber = Console.readLine();
        try {
            checkNumberLength(userNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생");
            return;
        }


    }

    static void getComputerNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static void checkNumberLength(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
