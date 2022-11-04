package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int end = 0;
        List<Integer> computer = makeAns();

        while (end != 2) {
            if(compareAns(computer,getInput()) == 3){
                System.out.println("Restart 1, End 2 ");
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

    static List<Integer> getInput() {
        int input = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        //try catch 문?
        List<Integer> userInput = new ArrayList<>();
        while (input > 0) {
            userInput.add(0, input % 10);
            input /= 10;
        }
        return userInput;
    }

    static int compareAns(List<Integer> computer, List<Integer> input) {
        int strike = 0;
        int ball = 0;

        if (computer.contains(input.get(0))) {
            if (computer.get(0).equals(input.get(0))) {
                strike += 1;
            } else {
                ball += 1;
            }
        }
        if (computer.contains(input.get(1))) {
            if (computer.get(1).equals(input.get(1))) {
                strike += 1;
            } else {
                ball += 1;
            }
        }
        if (computer.contains(input.get(2))) {
            if (computer.get(2).equals(input.get(2))) {
                strike += 1;
            } else {
                ball += 1;
            }
        }

        if (strike == 0) {
            if (ball == 0) {
                System.out.println("Nothing");
            } else {
                System.out.printf("%dBall %n", ball);
            }
        } else {
            if (ball == 0) {
                System.out.printf("%dStrike %n", strike);
            } else {
                System.out.printf("%dStrike %dBall %n", strike, ball);
            }
        }

        return strike;
    }
}
