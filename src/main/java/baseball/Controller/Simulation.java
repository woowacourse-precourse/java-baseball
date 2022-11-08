package baseball.Controller;

import baseball.View.User;
import baseball.Model.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Simulation {
    Computer computer = new Computer();
    User user = new User();

    public void simulate() {
        user.startSimulation();
        play();
    }

    public void play() {
        List<Integer> randomNumList = computer.createNumber();
        while (true) {
            List<Integer> inputNumList = user.inputNumber();
            List<Integer> strikeBallList = computer.checkStrikeBall(randomNumList, inputNumList);

            String result = computer.getResult(strikeBallList);
            boolean isEnd = user.outputResult(result, strikeBallList);
            if (isEnd) {
                break;
            }
        }
        rePlay();
    }

    public void rePlay() {
        String inputCheck = Console.readLine();
        if (inputCheck.equals("1")) {
            play();
        }
    }
}
