package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberVO {

    private List<Integer> randomNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }
}
