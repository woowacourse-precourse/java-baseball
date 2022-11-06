package baseball;

import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator;
    private List<Integer> computerNumber;

    public Computer() {
        numberGenerator = new NumberGenerator();
    }

    public void initComputerNumber() {
        this.computerNumber = numberGenerator.generateRandomNumber();
        System.out.println("생성된 숫자!!"+computerNumber);
    }

    public String giveResult(List<Integer> playerNumber) {
        NumberComparator numberComparator = new NumberComparator(playerNumber, computerNumber);
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        printResult(compareResult);
        return compareResult;
    }

    private void printResult(String compareResult) {
        System.out.println(compareResult);
    }

}
