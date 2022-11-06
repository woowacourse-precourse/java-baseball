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
    }

    public String calculateCount(int i, List<Integer> playerNumber, List<Integer> computerNumber) {
        if (computerNumber.contains(playerNumber.get(i))) {
            if (computerNumber.indexOf(playerNumber.get(i)) == i)
                return "strike";
            else
                return "ball";
        }
    return "nothing";
    }

}
