package baseball.component;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameRule {

    private List<Integer> computerNumbers;

    public BaseballGameRule(){
        computerNumbers = new ArrayList<>();
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }


}
