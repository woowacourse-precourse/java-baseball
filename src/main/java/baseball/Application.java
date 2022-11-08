package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Application {
    private List<Integer> computer;

    public Application() {
        this.computer = new ArrayList<>();
    }

    public void pickRandomNumber() {
        while (this.computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computer.contains(randomNumber)) {
                this.computer.add(randomNumber);
            }
        }
    }

    public boolean playGame() {
        boolean end_state = false;

        return end_state;
    }

    public static void main(String[] args) {
        Application app = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(app.playGame());

    }
}
