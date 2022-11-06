package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private List<Integer> targetNumber;
    private List<Integer> predictedNumber;
    private int strikeCount;
    private int ballCount;


    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
        predictedNumber = convertToList(scanner.nextLine());

        System.out.println(targetNumber);
        System.out.println(predictedNumber);
        scoreCalculator();
        System.out.println(strikeCount);
    }

    private List<Integer> convertToList(String predictedValue) {

        List<Integer> predictedNumber = new ArrayList<>();
        for(int index = 0; index < predictedValue.length(); index++) {
            predictedNumber.add(Character.getNumericValue(predictedValue.charAt(index)));
        }
        return predictedNumber;
    }

    private void scoreCalculator() {

        this.strikeCount = getStrikeCount();
        //this.ballCount = getBallCount();
    }

    private int getStrikeCount() {

        int count = 0;
        for(int index = 0; index < 3; index++) {
            if(Objects.equals(targetNumber.get(index), predictedNumber.get(index))) count++;
        }
        return count;
    }

//    private int getBallCount() {
//
//    }
}
