package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Integer> computer;

    public Game() {
        this.computer = initComputer();
    }

    private List<Integer> initComputer() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber;

        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public void play(String input) {
        int strike = 0;
        int ball = 0;
        List<Integer> player = inputToArrayList(input);

        strike = getStrike(computer, player);
        ball = getBall(computer, player);

        printResult(ball, strike);
    }

    public List<Integer> inputToArrayList(String input) {
        List<Integer> player = new ArrayList<>();
        int number;

        for (int i = 0; i < input.length(); i++) {
            number = Character.getNumericValue(input.charAt(i));
            player.add(number);
        }

        return player;
    }

    public int getStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strike++;
            }
        }

        return strike;
    }

    public int getBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        int playerNumber;

        for (int i = 0; i < player.size(); i++) {
            playerNumber = player.get(i);
            if ((computer.contains(playerNumber)) && (computer.indexOf(playerNumber) != i)) {
                ball++;
            }
        }

        return ball;
    }

    public void printResult(int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        resolver(ball, strike);
    }

    public void resolver(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public boolean isEnd(String input) {
        List<Integer> player = inputToArrayList(input);

        return player.equals(computer);
    }
}
