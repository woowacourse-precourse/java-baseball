package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.CheckException;
import baseball.ScoreBoard;

public class Game {

    private final Scanner scanner;
    private boolean isGameOver = false;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public Game play(List<Integer> targetNumber) {

        ScoreBoard scoreBoard = new ScoreBoard();

        while (!isGameOver) {
            System.out.print("숫자를 입력해주세요 : ");
            String predictedValue = CheckException.inputGameValid(scanner.nextLine());
            scoreBoard.action(targetNumber, convertToList(predictedValue));
            isGameOver = checkCorrectAnswer(scoreBoard.getStrikeScore());
        }
        return new Game(scanner);
    }

    private List<Integer> convertToList(String predictedValue) {

        List<Integer> predictedNumber = new ArrayList<>();
        for (int index = 0; index < predictedValue.length(); index++) {
            predictedNumber.add(Character.getNumericValue(predictedValue.charAt(index)));
        }
        return predictedNumber;
    }

    private boolean checkCorrectAnswer(int strikeScore) {

        return strikeScore == 3;
    }
}
