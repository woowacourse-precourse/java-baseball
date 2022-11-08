package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println(compareAns(makeAns(),getInput()).get(0));
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
        System.out.print("숫자를 입력해주세요 : ");

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

    static List<Integer> compareAns(List<Integer> computer, int[] userInput) {
        List<Integer> result = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(userInput[i])) {
                ball += 1;
            }
            if (computer.get(i).equals(userInput[i])) {
                strike += 1;
            }
        }
        ball -= strike;
        result.add(ball);
        result.add(strike);
        return result;
    }

    static void printResult(List<Integer> result) {
        String info = "";
        if (result.get(0).equals(0) && result.get(1).equals(0)) {
            info += "낫싱";
        } else if (result.get(1).equals(0)) {
            info = info + result.get(0) + "볼";
        } else if (result.get(0).equals(0)) {
            info = info + result.get(1) + "스트라이크";
        } else {
            info = info + result.get(0) + "볼 " + result.get(1) + "스트라이크";
        }
        System.out.println(info);
    }







}
