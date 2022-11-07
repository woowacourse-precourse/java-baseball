package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    private List<Integer> computerNum;

    public Computer(Game game) {
        pickComputerNum(game);
    }

    private void pickComputerNum(Game game) {
        computerNum = new ArrayList<>();
        while (computerNum.size() < game.getDigit()) {
            int randomNumber = Randoms.pickNumberInRange(game.getStartRange(), game.getEndRange());
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }
}