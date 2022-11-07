package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    static boolean endOfGame;
    
    public static void main(String[] args) {
        baseball();
    }
    
    public static String random(){
        String num ="";
        while(true){
            int random = Randoms.pickNumberInRange(1,9);
            if(!num.contains("" +random)){
                num += random;
            }
            if(num.length() == 3){
                break;
            }
        }
        return num;
    }
    
    public static boolean checkRepeat(String number){
        ArrayList<Character> charList = new ArrayList<>();
        for(int n = 0;n < 3; n++){
            if(charList.contains(number.charAt(n))){
                return true;
            }
            else {
                charList.add(number.charAt(n));
            }
        }
        return false;
    }
    
    public static Boolean checkInput(String input) throws IllegalArgumentException{
        if (input.strip().length() == 3){
            try {
                Integer.valueOf(input);
                return false;
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException("");
            }
        }
        else{
            throw new IllegalArgumentException();
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
    
    public static void compare(String answer, String input){
        System.out.println(answer +":" + input);
        int strike = 0, ball = 0, miss = 0;
        for(int n = 0; n < 3; n++){
            int answern, inputn;
            answern = Character.valueOf(answer.charAt(n));
            inputn = Character.valueOf(input.charAt(n));
            if(answern == inputn){
                strike++;
            }
            else if(answern != inputn && answer.contains("" + input.charAt(n))){
                ball++;
            }
            else {
                miss++;
            }
        }
        System.out.println(strike+ ":" + ball + ":" + miss);
        if(miss == 3){
            System.out.println("낫싱");
        }
        else if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! (1)다시 시작 (2)나가기");
            endOfGame = true;
        }
        else if(strike == 0){
            System.out.println(ball + "볼");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
    
    public static void baseball(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean run = true, newRandom = false;
        String random = random();
        while(run){
            if(newRandom == true){
                random = random();
                newRandom = false;
            }
            String input = Console.readLine();
            System.out.println(input);
            boolean check = input(input);
            if (check == true){
                break;
            }
            else{
                compare(random.toString(), input);
                if(endOfGame == true){
                    boolean result = endGame();
                    newRandom = result;
                    run = result;
                }
            }
        }
    }
    
    public static  boolean endGame(){
        if(Console.readLine().equals("1")){
            System.out.println("숫자 야구 게임을 시작합니다.");
            return true;
        }
        if(Console.readLine().equals("2")){
            System.out.println("게임 종료");
        }
        return false;
    }
}
