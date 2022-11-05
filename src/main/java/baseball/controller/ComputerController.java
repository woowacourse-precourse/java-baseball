package baseball.controller;

import baseball.model.Ball;
import baseball.service.ComputerService;

import java.util.List;

public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    public List<Ball> generateRandomBalls() {
        return computerService.generateRandomBalls();
    }
}
