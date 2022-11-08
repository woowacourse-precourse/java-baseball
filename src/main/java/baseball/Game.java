package baseball;

import java.util.List;

public class Game {
    Computer computer;

    public void run() {
        setInitialSetting();
        play();
    }

    public void setInitialSetting() {
        computer = new Computer();
    }

    public void play() {
        List<Integer> randomNumbers = computer.getRandomNumbers();
    }
}
