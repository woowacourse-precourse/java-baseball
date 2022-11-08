package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.Game.printResult;

public class Validation {
    public Validation(){
    }

    public static void isCorrectType(String pattern, String str){
        boolean result = Pattern.matches(pattern, str);

        if(!result){
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplication(String str) {
        Set<Character> hs = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (hs.contains(c)) {
                throw new IllegalArgumentException();
            }
            hs.add(c);
        }
    }

    public static boolean checkAnswer(List<Integer> computer, List<Integer> user){
        int ball = 0;
        int strike = 0;

        for(int i = 0; i<user.size(); i++){
            int num = user.get(i);

            if(computer.indexOf(num) == i){
                strike++;
                continue;
            }
            if(computer.contains(num)){
                ball++;
            }
        }
        System.out.println(printResult(ball, strike));

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
