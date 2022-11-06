package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    public List<Integer> makesDifferenceThreeNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> findStrikeAndBall(String user, List<Integer> computer) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            int num = user.charAt(i) - '0';

            int idx = computer.indexOf(num);

            if (idx == i) {
                strike++;
            } else if (idx != -1) {
                ball++;
            }
        }

        return List.of(strike, ball);
    }

    public void printStrikeAndBall(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    public boolean isCorrectAllNumber(int strike) {
        return strike == 3;
    }

    public int getRestart() {
        return Integer.parseInt(Console.readLine());
    }

    public boolean isCorrectInput(String user) {
        if(user.length() != 3) return false;

        Set<Integer> duplicatedCheck = new HashSet<>();

        for (int i = 0; i < user.length(); i++) {
            int number = user.charAt(i) - '0';

            duplicatedCheck.add(number);
            if(number <= 0) return false;
        }

        return duplicatedCheck.size() == 3;
    }
}
