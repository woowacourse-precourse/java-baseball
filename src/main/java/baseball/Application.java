package baseball;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

    }
    public static void checkException(int num){
        String numString = Integer.toString(num);
        if (numString.length() != 3){
            throw new IllegalArgumentException();
        }
        if (numString.contains("0")){
            throw new IllegalArgumentException();
        }
        if (!containSameNumber(numString)){
            throw new IllegalArgumentException();
        }
    }
    public static boolean containSameNumber(String numString){
        HashMap<Character, Integer> checkSameNumber = new HashMap<>();
        for (int i = 0; i < numString.length(); i++) {
            if (checkSameNumber.containsKey(numString.charAt(i))){
                return false;
            }
            checkSameNumber.put(numString.charAt(i), i);
        }
        return true;
    }
}
