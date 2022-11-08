package baseball.service;

import baseball.util.Constant;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballService {
    private ArrayList<Integer> computerNumbers;
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

    public void inputPlayerNumber() {
        System.out.print(Constant.INPUT_NUMBER_MESSAGE);
        String numbers = Console.readLine();
    }
}
