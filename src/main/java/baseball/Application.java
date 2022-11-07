package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    final static String RESTART = "1";
    final static String GAME_OVER = "2";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        continueGame(setComputer());
    }

    static List<Integer> setComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void continueGame(List<Integer> computer) throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = getUser();

        printResult(computer, user);
    }

    static List<Integer> getUser() {
        List<Integer> user = new ArrayList<>();
        char[] user_chArr = Console.readLine().toCharArray();

        for (char character : user_chArr) {
            int num = character - '0';
            //서로 다른 수가 아닌 경우
            if (user.contains(num)) {
                throw new IllegalArgumentException();
            } else {
                user.add(num);
            }
        }
        //숫자 3개가 아닌 경우
        if (user.size() != 3) throw new IllegalArgumentException();
        //숫자가 아닌 경우
        for (int i = 0; i < 3; i++) {
            if (!(1 <= user.get(i) && user.get(i) <= 9)) {
                throw new IllegalArgumentException();
            }
        }

        return user;
    }

    static void printResult(List<Integer> computer, List<Integer> user) throws IllegalArgumentException {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            } else if (user.contains(computer.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            endGame();
            return;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        continueGame(computer);
    }

    static void endGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals(RESTART)) {
            continueGame(setComputer());
        } else if (!input.equals(GAME_OVER)) {
            throw new IllegalArgumentException();
        }
    }
}

