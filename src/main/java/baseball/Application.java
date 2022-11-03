package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int SIZE = 3;
        List<Integer> computer = CreateNumbers(SIZE);
        String input = Console.readLine();
    }

    private static List<Integer> CreateNumbers(int SizeOfNum) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
               computer.add(randomNumber);
            }
        }
        return computer;
    }

}
