package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import Exception.CheckException;


public class Game {

    private final Scanner scanner;
    private List<Integer> targetNumber;
    private List<Integer> predictedNumber;
    private boolean isGameOver = false;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public Game play(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;

        while (!isGameOver) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputValue = scanner.nextLine();
            CheckException.inputGameValid(inputValue);
            predictedNumber = convertToList(inputValue);
            scoreCalculator();
            isGameOver = checkCorrectAnswer(getStrikeScore());
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

    private void scoreCalculator() {

        int strikeScore = getStrikeScore();
        int ballScore = getBallScore(strikeScore);
        printScoreBoard(strikeScore, ballScore);
    }

    private int getStrikeScore() {

        int strikeScore = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(targetNumber.get(index), predictedNumber.get(index))) strikeScore++;
        }
        return strikeScore;
    }

    private int getBallScore(int strikeScore) {

        int sameValueCnt = 0;
        for (int index = 0; index < 3; index++) {
            if (targetNumber.contains(predictedNumber.get(index))) sameValueCnt++;
        }
        return sameValueCnt - strikeScore;
    }

    private void printScoreBoard(int strikeScore, int ballScore) {

        if (strikeScore == 0 && ballScore == 0) {
            System.out.println("낫싱");
        } else if (strikeScore == 3 || ballScore == 0) {
            System.out.println(strikeScore + "스트라이크");
        } else if (ballScore == 3 || strikeScore == 0) {
            System.out.println(ballScore + "볼");
        } else {
            System.out.println(ballScore + "볼 " + strikeScore + "스트라이크");
        }
    }

    private boolean checkCorrectAnswer(int strikeScore) {

        return strikeScore == 3;
    }
}
