package baseball;

import java.util.ArrayList;

public class User {

    private ArrayList<Integer> UserBalls;

    public User(String userInput) {
        ArrayList<Integer> UserBalls = new ArrayList<>();

        for (char ball : userInput.toCharArray()) {
            UserBalls.add((int) ball);
        }
    }

    public ArrayList<Integer> getUserBalls() {
        return UserBalls;
    }

}
