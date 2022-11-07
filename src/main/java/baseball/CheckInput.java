package baseball;

import java.util.Arrays;
import java.util.List;

public class CheckInput {
    private CheckInput(){
    }
    public static boolean check_input(String str) {
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        List<String> nums = Arrays.asList(num);
        int len = str.length();
        for(int i= 0; i<len ; i++){
            char c = str.charAt(i);
            String s = Character.toString(c);
            if(!nums.contains(s)){
                return false;
            }
        }
        if(str.equals("1") | str.equals("2")){
            return true;
        }
        if(len != 3){
                return false;
        }
        return validate_duplication(str);
    }

    public static boolean validate_duplication(String str){
        return !(str.charAt(0) == str.charAt(1) | str.charAt(0) == str.charAt(2) | str.charAt(1) == str.charAt(2));
    }
    public static void make_error(String ans){
        try {
            if(!check_input(ans)){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
