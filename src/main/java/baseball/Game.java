package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Integer> result;
    public boolean runState = true;

    private List<Integer> computer;
    private List<Integer> user;

    public void setComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computer = computer;
    }

    public void setUserNumber(String userInput) {
        List<Integer> user = new ArrayList<>();
        userInput.chars().map(x -> x-'0').forEach(user::add);
        this.user = user;
    }

    public void calculateBallAndStrikeResult() {
        result = List.of(ballCounter(), strikeCounter());
    }
    private int strikeCounter() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i)) {
                count++;
            }
        }
        return count;
    }
    private int ballCounter() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                count++;
            }
        }
        return count - strikeCounter();
    }

    public void retry(String retryCommand) {
        if (retryCommand.equals("1")) {
            runState = true;
            setComputerNumber();
            return;
        }

        runState = false;
    }
}
