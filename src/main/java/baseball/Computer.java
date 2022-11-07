package baseball;

import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator;
    private List<Integer> computerNumbers;

    public Computer() {
        numberGenerator = new NumberGenerator();
    }

    public void initComputerNumber() {
        this.computerNumbers = numberGenerator.generateRandomNumber();
    }

    public String giveResult(List<Integer> playerNumber) {
        NumberComparator numberComparator = new NumberComparator(playerNumber, computerNumbers);
        numberComparator.compare();

        String compareResult = numberComparator.getCompareResult();
        printResult(compareResult);

        return compareResult;
    }

    private void printResult(String compareResult) {
        System.out.println(compareResult);
    }

}
