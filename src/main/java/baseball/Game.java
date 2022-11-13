package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static Number computerNumber;

    public Game() {
        init();
    }

    public void init() {
        computerNumber = pickComputerNumber();
        System.out.println(computerNumber);
    }

    public void start() {
        while (true) {
            Stage stage = new Stage(computerNumber);
            stage.start();

            if (stage.isComplete()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public Number pickComputerNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(pickNumber)) {
                list.add(pickNumber);
            }
        }
        return new Number(list);
    }
}
