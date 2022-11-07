package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
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
}
