package baseball;

import camp.nextstep.edu.missionutils.Console;
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
    
    public boolean compare(String answer, String input){
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
            return false;
        }
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! (1)다시 시작 (2)나가기");
            return true;
        }
        if(strike == 0){
            System.out.println(ball + "볼");
            return false;
        }
        else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
            return false;
        }
    }
    
    public void baseball(){
        boolean run = true, newRandom = false;
        String random = random();
        while(run){
            if(newRandom){
                random = random();
                newRandom = false;
            }
            String input = Console.readLine();
            boolean check = input(input);
            if (check == true){
                break;
            }
            else{
                if(compare(random,input)){
                    newRandom = endGame();
                    run = endGame();
                }
            }
        }
    }
    
    public static  boolean endGame(){
        if(Console.readLine() == "1"){
            System.out.println("새로운 게임 시작!");
            return true;
        }
        if(Console.readLine() == "2"){
            System.out.println("게임 끝");
            return false;
        }
        else{
            return false;
        }
    }
}
