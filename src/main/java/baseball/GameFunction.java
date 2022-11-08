package baseball;

import java.util.HashMap;

public class GameFunction {

    private static int ball;
    private static int strike;

    public String GameFunction(String userInput,HashMap<Character,Integer> computer){
        init();
        HintMaker(userInput,computer);
        return HintResult();
    }

    public static void HintMaker(String userInput,HashMap<Character,Integer> computer){
        
        for(int i=0;i<userInput.length();i++){
            BallOrStrike(userInput.charAt(i),i,computer);
        }
    }

    public static void BallOrStrike(char number,int index,HashMap<Character,Integer> computer){
        if(computer.containsKey(number)){
            if(computer.get(number)==index){
                strike++;
            }
            else {
                ball++;
            }
        }
    }
    public static void init(){
        ball=0;
        strike=0;
    }

    public String HintResult(){
        StringBuilder result = new StringBuilder();

        if(ball>0){
            result.append(String.format("%d볼 ",ball));
        }
        if(strike>0){
            result.append(String.format("%d스트라이크",strike));
        }
        if(ball==0&&strike==0){
            result.append(String.format("낫싱"));
        }
        return result.toString();
    }

    public boolean Homerun(){
        if(strike==3){
            init();
            return false;
        }
        else return true;
    }


}
