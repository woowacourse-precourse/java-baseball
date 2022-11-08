package baseball.controller;

import baseball.model.UserNumber;

import java.util.ArrayList;

public class CompareNumbers {

    UserNumber userNumber = new UserNumber();

    public CompareNumbers(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {
        countStrike(userNumberList, computerNumberList);
        countBall(userNumberList, computerNumberList);
    }

    public void countStrike(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {
        for (int i = 0; i < 3; i++) {
            if (userNumberList.get(i) == computerNumberList.get(i)) {
                userNumber.addStrike();
            }
        }
    }

    public void countBall(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {
        for (int i = 0; i < 3; i++) {
            if (computerNumberList.contains(userNumberList.get(i))) {
                if (userNumberList.get(i) != computerNumberList.get(i)) {
                    userNumber.addBall();
                }
            }
        }
    }
}
