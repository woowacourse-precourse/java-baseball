package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameStart = 1;
        do {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStart = Integer.parseInt(readLine());
        } while (gameStart == 1);
    }

    private static void playGame() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        user = getUserInput();
        computer = makeComputerNumber();

        for (int data: user) {
            System.out.println(data);
        }
    }

    private static List<Integer> getUserInput() {
        List<Integer> user = new ArrayList<>();
        int tmp = Integer.parseInt(readLine());
        while (user.size() < 3) {
            user.add(tmp%10);
            tmp /= 10;
        }
        Collections.reverse(user);
        return user;
    }

    private static List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

