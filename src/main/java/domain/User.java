package domain;

import java.util.List;

public class User {
    private static List<Integer> Number_List;
    public static void number_set(String input) {
        for(int index=0; index<input.length(); index++) {
            User.Number_List.add(Integer.valueOf(input.charAt(index)));
        }
    }

}
