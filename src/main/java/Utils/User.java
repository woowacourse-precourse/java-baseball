package Utils;

import java.util.List;

public class User {
    public static List<Integer> threeNumber_List;
    public static void set_UserNumber(String input) {
        for(int index=0; index<input.length(); index++) {
            User.threeNumber_List.add(Integer.valueOf(input.charAt(index)));
        }
    }
}
