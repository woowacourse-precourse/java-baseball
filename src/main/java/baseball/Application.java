package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restart=1;

        while (restartNumberValidate(restart)) {
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

        if (isNumberValidate(number) == false) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < number.length(); i++) {
            int numberToInt = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (user.contains(numberToInt)) {
                throw new IllegalArgumentException();
            }
            user.add(numberToInt);
        }

        checkSize(user);

        return user;
    }

    public static int compareNumberComputerWithUser(List<Integer> computer, List<Integer> user) {
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
        int sameNumberCount = compareNumberComputerWithUser(computer, user);
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

    public static void checkSize(List<Integer> user) {
        if (user.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumberValidate(String userInput) {
        char check;

        if (userInput.equals("")) {
            return false;
        }

        for (int i = 0; i < userInput.length(); i++) {
            check = userInput.charAt(i);
            if (check < 48 || check > 58) {
                return false;
            }
        }

        return true;
    }

    public static boolean restartNumberValidate(int restart) {

        if (restart == 1) {
            return true;
        } else if (restart == 2) {
            return false;
        } else if (restart != 1 || restart != 2) {
            throw new IllegalArgumentException("정상적인 값이 아닙니다");
        }

        return false;
    }
}
