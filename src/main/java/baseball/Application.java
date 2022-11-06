package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        chooseResetOrExit();
    }

    static void startGame() {
    }

    static List<Integer> getRandomThree() {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }

    static void chooseResetOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();

        if (s.equals("1")) {
            startGame();
        } else if (s.equals("2")) {
            return;
        }
    }
}
