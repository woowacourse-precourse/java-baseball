package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        showProblem();
    }

    static int readUser() {
        int result = Integer.parseInt(Console.readLine());
        return result;
    }

    static List<Integer> writeUser() {
        List<Integer> result = new ArrayList<>();
        int userNum = readUser();

        while (userNum > 0) {
            result.add(userNum % 10);
            userNum /= 10;
        }
        Collections.reverse(result);

        return result;
    }

    static List<Integer> writeComputer() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    static void showProblem() {
        List<Integer> computerList = writeComputer();
        boolean bool = true;

        while (bool) {
            System.out.print("\n숫자를 입력해주세요 : ");
            List<Integer> userList = writeUser();
            if (userList.size() > 3){
                throw new IllegalArgumentException();
            }

            List<Integer> answer = check(userList, computerList);
            if (answer.get(0) != 0)
                System.out.print(answer.get(0) + "볼 ");
            if (answer.get(1) != 0)
                System.out.print(answer.get(1) + "스트라이크");

            if (answer.get(1) == 3) {
                System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                bool = false;
                lastMessage();
            } else if (answer.get(2) == 3)
                System.out.print("낫싱");
        }
    }

    static List<Integer> check(List<Integer> writeUser, List<Integer> computer) {
        List<Integer> result = Arrays.asList(0, 0, 0);

        for (int i = 0; i < writeUser.size(); i++) {
            if (computer.contains(writeUser.get(i)) && computer.get(i) != writeUser.get(i))
                result.set(0, result.get(0) + 1);
            else if (computer.get(i) == writeUser.get(i))
                result.set(1, result.get(1) + 1);
            else if (!computer.contains(writeUser.get(i)))
                result.set(2, result.get(2) + 1);
        }
        return result;
    }

    static boolean lastMessage() {
        boolean result = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        switch (readUser()) {
            case 1:
                showProblem();
            case 2:
                result = false;
        }
        return result;
    }
}
