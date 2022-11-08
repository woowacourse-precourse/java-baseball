package baseball.service;

import baseball.util.Constant;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class BaseballService {
    private ArrayList<Integer> computerNumbers;
    private ArrayList<Integer> playerNumbers;
    private int ball;
    private int strike;
    private final Validator validator;

    public BaseballService() {
        validator = new Validator();
    }

    public void gameStart() {
        System.out.println(Constant.GAME_START_MESSAGE);
    }

    public void generateComputerNumber() {
        Set<Integer> randomNumberList = new HashSet<>();
        while (randomNumberList.size() < Constant.LENGTH) {
            randomNumberList.add(Randoms.pickNumberInRange(Constant.MIN, Constant.MAX));
        }
        computerNumbers = new ArrayList<>(randomNumberList);
    }

    public boolean checkGameStatus() {
        if (strike == Constant.LENGTH) {
            return checkRestart();
        }
        return true;
    }

    public boolean checkRestart() {
        System.out.println(Constant.GAME_OVER_MESSAGE);
        System.out.print(Constant.CHECK_RESTART_MESSAGE);
        String checkRestartNumber = Console.readLine();
        return true;
    }

    public void inputPlayerNumber() {
        System.out.print(Constant.INPUT_NUMBER_MESSAGE);
        String numbers = Console.readLine();
        validator.validatePlayerNumber(numbers);
        parseStringToArrayList(numbers);
    }

    public void parseStringToArrayList(String numbers) {
        List<Integer> numberList = Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayList<Integer> userNumber = new ArrayList<>(numberList);
        playerNumbers = new ArrayList<>(userNumber);
    }

    public void comparator() {
        ball = 0;
        strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = playerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            isBall(computerNumbers, computerNumber);
            isStrike(computerNumbers.get(i), playerNumber);
        }
        ball -= strike;
    }

    public void isBall(ArrayList<Integer> computerNumbers, int playerNumber) {
        if (computerNumbers.contains(playerNumber)) {
            ball += 1;
        }
    }

    public void isStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strike += 1;
        }
    }

    public void outputHint() {
        if (strike == Constant.LENGTH) {
            System.out.println(strike + Constant.STRIKE);
        } else if (ball == Constant.ZERO && strike == Constant.ZERO) {
            System.out.println(Constant.NOTHING);
        } else {
            System.out.println(ball + Constant.BALL + strike + Constant.STRIKE);
        }
    }
}
