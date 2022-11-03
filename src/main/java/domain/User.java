package domain;

import java.util.List;

public class User {
    private static List<Integer> number_List;
    public static void number_set(String input) {
        for(int index=0; index<input.length(); index++) {
            User.number_List.add(Integer.valueOf(input.charAt(index)));
        }
    }
    public static String number_get(){
        String numbers="";
        for(Integer item: User.number_List){
            numbers.concat(String.valueOf(item));
        }
        return numbers;
    }

}
