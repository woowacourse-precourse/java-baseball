package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<Integer> number_List=new ArrayList<>();

    public static User getInstance(){
        return new User();
    }

    public static void setNumber(String input) {
        for(int index=0; index<input.length(); index++) {
            User.number_List.add(Character.getNumericValue(input.charAt(index)));
        }
    }

    public static String getNumber(){
        String numbers="";
        System.out.print(User.number_List.toString());
        for(Integer item: User.number_List){
            numbers+=Integer.toString(item);
        }
        return numbers;
    }

}
