package service;

import data.ComputerData;
import repository.ComputerRepository;
import repository.UserRepository;

public class BaseballGame {

    private ComputerRepository computerRepository;
    private UserRepository userRepository;
    private int strike;
    private int ball;

    public void init() throws IllegalArgumentException {
        try {
            ComputerData computerData = new ComputerData();
            computerRepository = new ComputerRepository(computerData);
            computerRepository.setRandomNum();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
