package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    List<Integer> targetList;
    List<Integer> predictedList;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }


    public void play(List<Integer> randomValues) {

        this.targetList = randomValues;
        this.predictedList = convertToList(scanner.nextLine());
        System.out.println(targetList);
        System.out.println(predictedList);
    }

    private ArrayList<Integer> convertToList(String predictedValue) {

        ArrayList<Integer> predictedNumList = new ArrayList<>();
        for(int index = 0; index < predictedValue.length(); index++) {
            predictedNumList.add(Character.getNumericValue(predictedValue.charAt(index)));
        }
        return predictedNumList;
    }

}
