package baseball.service;

import baseball.util.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballService {
    private ArrayList<Integer> computerNumbers;

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
}
