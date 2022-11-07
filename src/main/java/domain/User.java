package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static String input;

    public static void setNumber(String input) {
        User.input=input;
    }
    public static String getNumber(){
        return User.input;
    }

    public static int strike_count() {
        int strike_count = 0;
        for (int index = 0; index < 3; index++) {
            if (Computer.getNumber().charAt(index) == User.getNumber().charAt(index)) {
                strike_count++;
                continue;
            }
        }
        return strike_count;
    }

    public static int ball_count(){
        int ball_count=0;

        for(int index=0; index<3; index++){
            if(Computer.getNumber_List().get(index)==Character.getNumericValue(User.getNumber().charAt(index))) {
                continue;
            }
            if(Computer.getNumber_List().contains(Character.getNumericValue((User.getNumber().charAt(index))))) {
                ball_count++;
            }
        }
        return ball_count;
    }
}


