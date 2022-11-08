package baseball;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms;


public class Application {

    public static ArrayList<Integer> randomNum() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList A = randomNum();
    }
}