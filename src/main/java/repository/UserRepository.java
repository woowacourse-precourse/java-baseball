package repository;

import data.UserData;

public class UserRepository {
    private UserData userData;

    public UserRepository(UserData userData) {
        this.userData = userData;
    }

    public String inputanswer(String userInput) throws IllegalArgumentException {
        String answer = userInput;
        userData.setUserData(answer);
        return userInput;
    }
}