package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    List<Integer> computer;

    Game() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int inputUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public checkUserAnswerWhichIsCorrect(int userAnswer) {

    }

}
