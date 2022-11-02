package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    public void checkUserAnswerWhichIsCorrect(int userAnswer) {
        HashMap<String, Integer> StrikeAndBallCount = new HashMap<>();

        StrikeAndBallCount.put("Strike", 0);
        StrikeAndBallCount.put("Ball", 0);

        List<Integer> answer = List.of(userAnswer);
        for (Integer integer : answer) {

        }
    }

}
