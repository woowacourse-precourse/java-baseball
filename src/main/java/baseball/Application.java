package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int NUM_SIZE = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = ComputerGenerate();
    }

    private static List<Integer> ComputerGenerate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_SIZE) {
            AddComputerValue(computer);
        }
        return computer;
    }

    private static List<Integer> AddComputerValue(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
        return computer;
    }
}
