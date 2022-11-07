package baseball;

import java.util.ArrayList;
import java.util.List;

public class Transformation_function {
    public static String Integer_list_2_String(List<Integer> number) {
        return number.toString().replaceAll("[^0-9]","");
    }

    public static List<String> String_2_String_list(String string){
        List<String> String_list = new ArrayList<>();

        for(int index = 0; index<string.length(); index++){
            String_list.add(String.valueOf(string.charAt(index)));
        }

        return String_list;
    }
}
