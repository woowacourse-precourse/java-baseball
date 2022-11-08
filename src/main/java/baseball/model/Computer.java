package baseball.model;

import baseball.controller.RandomNumberGenerator;

import java.util.ArrayList;

public class Computer {
    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public ArrayList<Integer> makeComputerNumber() {
        ArrayList<Integer> computer = randomNumberGenerator.RandomNumberGenerator();

        return computer;
    }
}
