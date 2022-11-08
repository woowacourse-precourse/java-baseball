package baseball.entity;

import baseball.number.NumberHandler;

import java.util.List;

public class User {
    private List<Integer> userNumberList;

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

    public void setUserNumberList(String userInputNumber) {
        int userNumbers = Integer.parseInt(userInputNumber);
        this.userNumberList = NumberHandler.splitNumber(userNumbers);
    }
}
