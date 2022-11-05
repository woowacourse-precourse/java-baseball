package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class Application {
    public static void main(String[] args) {

    }
    static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static void validateOnlyNumbers(String guess) {
        try {
            int numbers = Integer.parseInt(guess);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다. 프로그램을 종료합니다");
        }
    }
    static void validateThreeNumbers(String guess) {
        if (guess.length() != 3) {
            throw new IllegalArgumentException("숫자 세 개만 입력이 가능합니다. 프로그램을 종료합니다.");
        }
    }
    static int[] compareGuessToComputer(List<Integer> guess, List<Integer> computer) {
        int[] comparison = new int[2];
        int num;
        for (int order = 0; order < guess.size(); order ++) {
            num = guess.get(order);
            if (computer.contains(num) && (order == guess.indexOf(num))) {
                comparison[1]++;
            }
            else if (computer.contains(num) && (order != guess.indexOf(num))) {
                comparison[0]++;
            }
        }
        return comparison;
    }
    static String gameResults(int[] comparison) {
        String result = "";
        if ((comparison[0]==0) && (comparison[1]==0)) {
            result = "낫싱";
            return result;
        }
        else if (!(comparison[0]==0)) {
            result += comparison[0]+"볼 ";
        }
        else if (!(comparison[1]==0)) {
            result += comparison[1]+"스트라이크";
        }
        return result;
    }

}
