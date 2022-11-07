package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    static List<Integer> randomize() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static List<Integer> splitString(String a) {
        List<Integer> result = new ArrayList<>();
        String[] arr = a.split("");
        for(int i=0; i<3; i++) {
            result.add(Integer.valueOf(arr[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        int flag = 1;

        List<Integer> COM = randomize();
        String N = readLine();
        if(N.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> M = splitString(N);


    }
}
