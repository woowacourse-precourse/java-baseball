package baseball.valid;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Valid {

    public static int userInput(String num){
            OutOfRange(num); //입력값의 범위를 벗어 났을 때
            List<Character> list = new ArrayList<>();
            for(int i = 0; i < num.length(); i++){
                Character c = num.charAt(i);
                NotMatch(c); //입력 받은 값이 정수가 아닐 때
                checkOverlap(list, c); // 숫자가 중복됬을 때
                list.add(c);
            }
            return Integer.parseInt(num);
    }
    public static void OutOfRange(String num) {
        if(num.length() != 3){
            throw new IllegalArgumentException("숫자의 범위를 벗어났습니다.");
        }
    }
    public static void NotMatch(Character character) {
        if(!Character.isDigit(character)){ //입력 받은 값이 숫자가 아닐 때
            throw new IllegalArgumentException("입력된 값이 정수가 아닙니다.");
        }
    }
    public static void checkOverlap(List<Character> list, Character character){
        if(list.contains(character)){       //입력 받은 값이 동일한 값이 들어 있을 때
            throw new IllegalArgumentException("중복된 숫자가 들어 왔습니다.");
        }
    }

    public static Integer userRestart(String desicion){
            String input_regex = "[1-2]{1}"; //한글자이며 숫자여야한다.
            if(!Pattern.matches(input_regex, desicion)){
                throw new IllegalArgumentException("입력된 값이 조건에 맞지 않습니다.");
            }
            return Integer.valueOf(desicion);
    }

}
