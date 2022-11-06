package baseball;

import java.util.List;

public class Computer {
    private int strikeCount = 0;
    private int ballCount = 0;
    private Number numFactory;
    private List<Integer> computerNumber;
    public Computer() {
        numFactory = new ComputerNum();
        computerNumber = numFactory.createNumber();
        numFactory.verifyNumber(computerNumber);
    }

    public void calculateCount(int i, List<Integer> playerNumber) {
        if (computerNumber.contains(playerNumber.get(i))) {
            if (computerNumber.indexOf(playerNumber.get(i)) == i)
                strikeCount++;
            else
                ballCount++;
        }
    }

}
