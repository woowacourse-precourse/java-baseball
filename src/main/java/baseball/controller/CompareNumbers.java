package baseball.controller;

import baseball.model.User;

import java.util.ArrayList;

public class CompareNumbers {

    User user = new User();

    public CompareNumbers(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {
        for (int i = 0; i < 3; i++) {
            countStrike(userNumberList.get(i), computerNumberList.get(i));
            countBall(userNumberList.get(i), computerNumberList.get(i), computerNumberList);
        }
    }

    public void countStrike(int userNumber, int computerNumber) {
        if (userNumber == computerNumber) {
            user.addStrike();
        }
    }

    public void countBall(int userNumber, int computerNumber, ArrayList<Integer> computerNumberList) {
        if (computerNumberList.contains(userNumber)) {
            if (userNumber != computerNumber) {
                user.addBall();
            }
        }
    }
}
