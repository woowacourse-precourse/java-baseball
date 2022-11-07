package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    InputValidation inputValidation = new InputValidation();

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        play();
    }

    public void play(){

        List<Integer> computer = makeComputerNumber();

    }

    public static List<Integer> makeComputerNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
