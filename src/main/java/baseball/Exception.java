package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    //사용자가 숫자를 잘 입력했는지 확인.
    public static boolean exception(String userNumber){
        if (checkLength(userNumber) && checkDigit(userNumber) && doubleCheck(userNumber)){
            return true;
        }
        return false;
    }

    //입력한 수의 갯수가 3개가 맞는지 검사
    public static boolean checkLength(String userNumber){
        if (userNumber.length() != 3)
            return false;
        return true;
    }

    //입력한 수들중 숫자만 들어왔는지 검사
    public static boolean checkDigit(String userNumber){
        for (int i = 0; i < userNumber.length(); i++){
            checkIndexDigit(userNumber, i);
        }
        return true;
    }

    public static boolean checkIndexDigit(String userNumber, int index){
        if (!Character.isDigit(userNumber.charAt(index))){
            return false;
        }
        return true;
    }

    //중복검사
    public static boolean doubleCheck(String userNumber){
        Set<Character> number = new HashSet<>();

        for (int i = 0; i < userNumber.length(); i++){
            number.add(userNumber.charAt(i));
        }
        if (number.size() != 3) {
            return false;
        }
        return true;
    }
}
