package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private List<Integer> targetNumber;
    private List<Integer> predictedNumber;
    private int strikeScore;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
        predictedNumber = convertToList(scanner.nextLine());

        System.out.println(targetNumber);
        System.out.println(predictedNumber);
        scoreCalculator();
    }

    private List<Integer> convertToList(String predictedValue) {

        List<Integer> predictedNumber = new ArrayList<>();
        for(int index = 0; index < predictedValue.length(); index++) {
            predictedNumber.add(Character.getNumericValue(predictedValue.charAt(index)));
        }
        return predictedNumber;
    }

    private void scoreCalculator() {

        this.strikeScore = getStrikeScore();
        int ballScore = getBallScore();
        System.out.println(strikeScore);
        System.out.println(ballScore);
    }

    private int getStrikeScore() {

        int strikeScore = 0;
        for(int index = 0; index < 3; index++) {
            if(Objects.equals(targetNumber.get(index), predictedNumber.get(index))) strikeScore++;
        }
        return strikeScore;
    }

    private int getBallScore() {

        int sameValueCnt = 0;
        for(int index = 0; index < 3; index++) {
            if(targetNumber.contains(predictedNumber.get(index))) sameValueCnt++;
        }
        return sameValueCnt - strikeScore;
    }
}
