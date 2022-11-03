package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String userInput = Console.readLine();

    }

    public static List<Integer> computerNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
        return computer;
    }

    public static List<Integer> createUserNumberList(String number) {
        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            int numberToInt = Integer.parseInt(String.valueOf(number.charAt(i)));
            user.add(numberToInt);
        }
        return user;
    }

    public static int compareComputerWithUser(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                count++;
            }
        }
        return count;
    }


    public static int strikeCount(List<Integer> computer, List<Integer> user) {
        int strike=0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public static String resultJudgement(List<Integer> computer, List<Integer> user) {
        int sameNumberCount = compareComputerWithUser(computer, user);
        int strikeCount = strikeCount(computer, user);
        int ballCount = sameNumberCount - strikeCount;

        if(sameNumberCount == 0) {
            return "미싱";
        } else if (strikeCount == 0) {
            return ballCount + "볼";
        } else if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

}
