package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    
    public static String random(){
        boolean check = true;
        ArrayList<Integer> num = new ArrayList<>();
        while(check){
            int random = Randoms.pickNumberInRange(1,9);
            if(!num.contains(random)){
                num.add(random);
            }
            if(num.size() == 3){
                check = false;
            }
        }
        return num.toString();
    }
    
    public static boolean checkRepeat(String number){
        ArrayList<Character> charList = new ArrayList<>();
        for(int n = 0;n < 3; n++){
            if(charList.contains(number.charAt(n))){
                return true;
            }
            if(charList.size() == 3){
                return false;
            }
            else {
                charList.add(number.charAt(n));
            }
        }
        return true;
    }
    
    public static Boolean checkInput(String input){
        if (input.strip().length() == 3){
            try{
                Integer.valueOf(input);
                return false;
            }
            catch(IllegalArgumentException e){
                return true;
            }
        }
        else{
            return true;
        }
    }
    
    public static boolean input(String input){
        boolean result = true;
        result = checkInput(input);
        if (result == false){
            result = checkRepeat(input);
            if (result == false){
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return true;
        }
    }
    
    public void compare(String answer, String input){
        String reply = "";
        int strike = 0, ball = 0, miss = 0;
        for(int n = 0; n < 3; n++){
            if(answer.charAt(n) == input.charAt(n)){
                strike++;
            }
            if(answer.charAt(n) != input.charAt(n) && answer.contains("" + input.charAt(n))){
                ball++;
            }
            else {
                miss++;
            }
        }
        if(miss == 3){
            System.out.println("낫싱");
        }
        if(strike == 3){
            System.out.println("3스트라이크");
        }
        if(strike == 0){
            System.out.println(ball + "볼");
        }
        else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }
}
