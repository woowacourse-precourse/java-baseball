package baseball;

import java.util.HashMap;

public class GameFunction {

    private static int ball;
    private static int strike;

    public GameFunction(String userInput,HashMap<Character,Integer> computer){

    }

    public static void HintMaker(String userInput,HashMap<Character,Integer> computer){
        
        for(int i=0;i<userInput.length();i++){
                BallOrStrike(userInput.charAt(i),i,computer);
        }
    }

    public static void BallOrStrike(char number,int index,HashMap<Character,Integer> computer){
        if(computer.containsKey(number)){
            if(computer.get(number)==index)strike++;
            else ball++;
        }
    }


}
