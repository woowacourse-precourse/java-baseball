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
    static void printResult(int strike, int ball, int nothing) {
        if(nothing == 3) {
            System.out.println("낫싱");
        }
        if(ball != 0) {
            System.out.print(ball+"볼 ");
        }
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }
    static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        String flag;
        List<Integer> COM = randomize();
        printStart();
        while (true) {
            printInput();
            String N = readLine();
            if (N.length() != 3) {
                throw new IllegalArgumentException();
            }
            List<Integer> M = splitString(N);
            for (int i = 0; i < 3; i++) {
                if (COM.get(i).equals(M.get(i))) {
                    strike++;
                } else if (M.contains(COM.get(i))) {
                    ball++;
                } else {
                    nothing++;
                }
            }
            printResult(strike, ball, nothing);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                flag = readLine();
                if (flag.equals("2")) {
                    break;
                } else if (!flag.equals("1")) {
                    throw new IllegalArgumentException();
                } else {
                    COM = randomize();
                }
            }
            strike = 0;
            ball = 0;
            nothing = 0;
        }
    }
}
