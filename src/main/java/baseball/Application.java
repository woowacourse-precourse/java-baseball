package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    static void printResult(int strike, int ball, int nothing) {
        if(nothing == 3) {
            System.out.println("낫싱");
        }
        if(ball != 0) {
            System.out.println(ball+"볼 ");
        }
        if(strike != 0) {
            System.out.println(strike+"스트라이크 ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        int flag = 1;

        List<Integer> COM = randomize();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String N = readLine();
            if (N.length() != 3) {
                throw new IllegalArgumentException();
            }
            List<Integer> M = splitString(N);
            for (int i = 0; i < 3; i++) {
                if (Objects.equals(M.get(i), COM.get(i))) {
                    strike++;
                } else if (M.contains(COM.get(i))) {
                    ball++;
                } else {
                    nothing++;
                }
            }
            printResult(strike, ball, nothing);

        }
    }
}
