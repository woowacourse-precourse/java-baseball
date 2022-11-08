package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static String INPUT;

    public static void setNumber(String input) {
        User.INPUT=input;
    }
    public static String getNumber(){
        return User.INPUT;
    }

    public static int strike_count() {
        int STRIKE_COUNTERNUMBER=0;
        for (int index = 0; index < 3; index++) {
            if (Computer.getNumber().charAt(index) == getNumber().charAt(index)) {
                STRIKE_COUNTERNUMBER++;
                continue;
            }
        }
        return STRIKE_COUNTERNUMBER;
    }

    public static int ball_count(){
        int BALL_COUNTNUMBER=0;
        for(int index=0; index<3; index++){
            if(Computer.getNumber_List().get(index)==Character.getNumericValue(User.getNumber().charAt(index))) {
                continue;
            }
            if(Computer.getNumber_List().contains(Character.getNumericValue((User.getNumber().charAt(index))))) {
                BALL_COUNTNUMBER++;
            }
        }
        return BALL_COUNTNUMBER;
    }
}


