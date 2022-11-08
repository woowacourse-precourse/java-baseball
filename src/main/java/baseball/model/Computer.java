package baseball.model;

import baseball.controller.RandomNumberGenerator;

import java.util.ArrayList;

public class Computer {

    public ArrayList<Integer> makeComputerNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        ArrayList<Integer> computer = randomNumberGenerator.RandomNumberGenerator();

        return computer;
    }
}
