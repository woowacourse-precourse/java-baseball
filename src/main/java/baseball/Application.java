package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void getUserGuess(List<Integer> guess) {
        System.out.print("숫자를 입력해주세요 : ");
        String[] numbers = Console.readLine().split("");
        if (numbers.length != 3) {
            throw new IllegalArgumentException("Takes only input of three integers without space Ex. '123'");
        }
        guess.clear();
        for(String number:numbers) {
            try {
                guess.add(Integer.parseInt(number));
            }
            catch (Exception e) {
                throw new IllegalArgumentException("Input takes only integer guesses");
            }
        }
    }

    public static boolean checkGuess(List<Integer> computer, List<Integer> guess) {
        if (computer.equals(guess)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        int ball = 0;
        int strike = 0;

        for (int i=0; i < computer.size(); i++) {
            Integer digit = guess.get(i);
            if (digit.equals(computer.get(i))) {
                strike += 1;
                continue;
            }
            if (computer.contains(digit)) {
                ball += 1;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        else {
            if (ball != 0) {
                System.out.printf("%d볼 ", ball);
            }
            if (strike != 0) {
                System.out.printf("%d스트라이크", strike);
            }
            System.out.println();
        }
        return false;
    }

    public static void runGame() {
        List<Integer> computer = generateRandomNumber();
        List<Integer> guess = new ArrayList<>();
        while(true) {
            getUserGuess(guess);
            if (checkGuess(computer, guess)) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고,
         * 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
         *
         * 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
         * 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
         * 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
         * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
         * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
         */
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer;
        while(true) {
            runGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            answer = Console.readLine();
            if (answer.contentEquals("1")) {
                continue;
            }
            else if (answer.contentEquals("2")) {
                break;
            }
            else {
                throw new IllegalArgumentException("1 과 2만 입력으로 받습니다");
            }
        }
    }
}
