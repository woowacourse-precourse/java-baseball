package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restart = 0;

        while (restart != 2) {
            List<Integer> computer = computerNumberList();
            String result = "";
            while (!result.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                List<Integer> user = createUserNumberList(userInput);
                result = resultJudgement(computer, user);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restart = Integer.parseInt(Console.readLine());

            if(restart == 2)
                break;
        }
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
            return "낫싱";
        } else if (strikeCount == 0) {
            return ballCount + "볼";
        } else if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
