package baseball;

import static baseball.Constant.*;

public class Util {
    public static void isWeirdSize(String input_Number){
        if(input_Number.length() != GAMEPLAY_SIZE){
            throw new IllegalArgumentException();
        }
    }
    public static void isNumber(String input_Number){
        for(int i=0; i<input_Number.length();i++){
            char number = input_Number.charAt(i);
            char start_num = (char)(MIN_NUM+'0');
            char end_num = (char)(MAX_NUM+'0');
            if(number >= start_num && number <= end_num);
            else{throw new IllegalArgumentException();}
        }
    }
    public static void isSameEachNumber(String input_Number){
        for(int i=0; i<input_Number.length()-1;i++){
            String each_number = input_Number.substring(i+1);
            if(each_number.contains(Character.toString(input_Number.charAt(i)))){
                throw new IllegalArgumentException();
            }
        }
    }
}
