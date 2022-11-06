package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play(List<Integer> targetNumbers) {
        List<Integer> targetNumber = targetNumbers;
        List<Integer> predictedNumber = convertToList(scanner.nextLine());

    }

    private List<Integer> convertToList(String predictedValue) {

        List<Integer> predictedNumber = new ArrayList<>();
        for(int index = 0; index < predictedValue.length(); index++) {
            predictedNumber.add(Character.getNumericValue(predictedValue.charAt(index)));
        }
        return predictedNumber;
    }

}
