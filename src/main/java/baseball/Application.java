package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int end = 0;
        List<Integer> computer = makeAns();
        List<Integer> info;
        System.out.println(computer);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (end != 2) {
            info = compareAns(computer, getInput());
            System.out.println(printInfo(info));
            if (info.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                computer = makeAns();
                end = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
            }
        }
    }

    static List<Integer> makeAns() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    static int[] getInput() {
        System.out.println("숫자를 입력해주세요 : ");
        int[] userInput = new int[3];
        int idx = 2;
        int input = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        while (input > 0) {
            userInput[idx] = input % 10;
            input /= 10;
            idx -= 1;
        }
        return userInput;

    }

    static List<Integer> compareAns(List<Integer> computer, int[] input) {
        List<Integer> ans = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(input[i])) {
                ball += 1;
            }
            if (computer.get(i).equals(input[i])) {
                strike += 1;
            }
        }
        ball -= strike;
        ans.add(strike);
        ans.add(ball);
        return ans;
    }

    static String printInfo(List<Integer> ans) {
        String info = "";
        if (ans.get(0).equals(0) && ans.get(1).equals(0)) {
            info += "낫싱";
        } else if (ans.get(0).equals(0)) {
            info = info + ans.get(1) + "볼";

        } else if (ans.get(1).equals(0)) {
            info = info + ans.get(0) + "스트라이크";
        } else {
            info = info + ans.get(1) + "볼 " + ans.get(0) + "스트라이크";
        }
        return info;
    }

}
