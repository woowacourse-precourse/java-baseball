package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    static final int EXIT = 2;

    static int strike = 0;
    static int ball = 0;
    static boolean gameEnd = false;
    static boolean gameExit = false;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = getRandomNumberList();
            playGame(computer);

            if (gameExit) break;
        }

    }

    public void playGame(List<Integer> computer) {
        gameEnd = false;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Integer> user = validateUserInput(input);

            calculateScore(user, computer);
            printResult();

            if (gameEnd) {
                restartOrExit();
                break;
            }
        }
    }

    public List<Integer> getRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> validateUserInput(String input) {
        List<Integer> user = new ArrayList<>();
        for (String number : Arrays.asList(input.split(""))) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException();
            }
            user.add(Integer.parseInt(number));
        }

        if (user.size() != 3)
            throw new IllegalArgumentException();
        if (user.get(0) == user.get(1) || user.get(1) == user.get(2) || user.get(2) == user.get(0))
            throw new IllegalArgumentException();

        return user;
    }

    public void calculateScore(List<Integer> user, List<Integer> computer) {
        strike = 0;
        ball = 0;

        for (int number : user) {
            int userIndex = user.indexOf(number);
            int computerIndex = computer.indexOf(number);

            if (userIndex == computerIndex) {
                strike++;
            }
            else if (computerIndex != -1) {
                ball++;
            }
        }
    }

    public void printResult() {
        if (strike == 0 && ball == 0)
            System.out.print("낫싱");
        if (ball != 0)
            System.out.print(ball + "볼 ");
        if (strike != 0)
            System.out.print(strike + "스트라이크");

        System.out.println();

        if (strike == 3)
            gameEnd = true;
    }

    public void restartOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int choose = Integer.parseInt(Console.readLine());
        if (choose == EXIT)
            gameExit = true;
    }

}
