package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> getUserInput() throws IllegalArgumentException {
        List<Integer> userNum = new ArrayList<>();
        String userInput = Console.readLine();

        if (userInput.length() != 3)
            throw new IllegalArgumentException("게임 종료");

        for (int i = 0; i < userInput.length(); i++) {
            if ((int) userInput.charAt(i) == 0)
                throw new IllegalArgumentException("게임 종료");
            userNum.add((int) userInput.charAt(i));
        }
        return userNum;
    }

    public static void compareNums(List<Integer> computerNum, List<Integer> userNum) {
        if (computerNum.equals(userNum)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
            chooseGameCondition();
        } else {
            List<Integer> copyUserNum = new ArrayList<>(userNum);
            copyUserNum.retainAll(computerNum);
            int count = 0;

            if (copyUserNum.isEmpty())
                System.out.println("낫싱");
            else {
                for (int i = 0; i < copyUserNum.size(); i++) {
                    int indexComputer = computerNum.indexOf(copyUserNum.get(i));
                    int indexUser = userNum.indexOf(copyUserNum.get(i));
                    if (indexComputer == indexUser)
                        count++;
                }
                if (count == 0)
                    System.out.println(count + "볼");
                else if (copyUserNum.size() - count == 0)
                    System.out.println(count + "스트라이크");
                else
                    System.out.println((copyUserNum.size() - count) + "볼" + count + "스트라이크");
            }
        }
    }

    public static void chooseGameCondition() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
        } else {
        }
    }

    public static void startGame() {
        List<Integer> computerNum = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNum = createComputerNum();
        boolean continueGame = true;

        while (continueGame) {
            List<Integer> userNum = new ArrayList<>();
            try {
                userNum = getUserInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
            compareNums(computerNum, userNum);
        }
    }

    public static void main(String[] args) {
        startGame();
    }
}
