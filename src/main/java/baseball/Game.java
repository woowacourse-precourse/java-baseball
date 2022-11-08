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

        while (computer.size() < Application.GAME_SIZE) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public void play(String input) {
        List<Integer> player = inputToArrayList(input);
        int strike = getStrike(computer, player);
        int ball = getBall(computer, player);

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
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    public int getBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        int playerIndexInComputer;

        for (int i = 0; i < player.size(); i++) {
            playerIndexInComputer = computer.indexOf(player.get(i));
            if ((playerIndexInComputer != -1) && (playerIndexInComputer != i)) {
                ball++;
            }
        }

        return ball;
    }

    public void printResult(int ball, int strike) {
        if (strike == Application.GAME_SIZE) {
            System.out.println(Application.GAME_SIZE + "스트라이크");
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public boolean isEnd(String input) {
        List<Integer> player = inputToArrayList(input);

        return player.equals(computer);
    }
}
