package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }

    public static void start() {
        List<Integer> computerNumber = randomNumber();

        boolean run = true;

        while (run) {
            System.out.print("숫자를 입력해주세요 : ");
            String numbers = Console.readLine();

            isThree(numbers);
            hasDuplicate(numbers);

            List<Integer> playerNumber = player(numbers);

            int strike = strike(computerNumber, playerNumber);

            int ball = ball(computerNumber, playerNumber);

            hint(strike, ball);
        }
    }

    public static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static void isThree(String numbers) throws IllegalArgumentException {
        if(numbers.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void hasDuplicate(String numbers) throws IllegalArgumentException {
        if (numbers.charAt(0) == numbers.charAt(1)
                || numbers.charAt(0) == numbers.charAt(2)
                || numbers.charAt(1) == numbers.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> player(String numbers) throws IllegalArgumentException {
        String[] split = numbers.split("");

        List<Integer> player = new ArrayList<>();

        for(int i=0; i<numbers.length(); i++) {
            try {
                Integer number = Integer.parseInt(split[i]);
                player.add(number);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        return player;
    }

    public static int strike(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;

        for (int i=0; i<3; i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strike++;
            }
        }

        return strike;
    }

    public static int ball(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = 0;

        for (int i=0; i<3; i++) {
            int index = computerNumber.indexOf(playerNumber.get(i));
            if (index != i && index >= 0) {
                ball++;
            }
        }

        return ball;
    }

    public static void hint(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

}
