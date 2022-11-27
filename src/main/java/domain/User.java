package domain;

import Controller.validation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String INPUT;

    public User(String input) {
        validation.check_input(input);
        INPUT=input;
    }

    public String getNumber() {
        return INPUT;
    }

    public int strike_count() {
        int STRIKE_COUNT_NUMBER=0;
        for (int index = 0; index < 3; index++) {
            if (Computer.getNumber().charAt(index) == getNumber().charAt(index)) {
                STRIKE_COUNT_NUMBER++;
            }
        }

        return STRIKE_COUNT_NUMBER;
    }

    public int ball_count() {
        int BALL_COUNT_NUMBER=0;
        for (int index = 0; index < 3; index++) {
            if (Computer.getNumber_List().contains(Character.getNumericValue((getNumber().charAt(index))))) {
                BALL_COUNT_NUMBER++;
            }

        }
        return BALL_COUNT_NUMBER-strike_count();
    }
}


