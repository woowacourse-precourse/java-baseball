package baseball;

import static baseball.Constant.*;

public class Hint {

    private static int strike;
    private static int ball;
    static boolean threeStrike;

    public static void printHintMessage(){
        if(strike==3){
            System.out.println(strike+ strikeMessage);
        }
        else if(strike==0 && ball==0) {
            System.out.println(nothingMessage);
        }
        else System.out.println(ball + ballMessage + " " + strike + strikeMessage);
    }
    public static void hintCalculator(String comNumber,String userNumber){
        strike=0;
        ball=0;
        threeStrike=false;
        for(int comIndex=0;comIndex<comNumber.length();comIndex++) {
            if (comNumber.charAt(comIndex) == userNumber.charAt(comIndex)) {
                strike++;
                continue;
            }
            for(int userIndex=0;userIndex<userNumber.length();userIndex++){
                if(comNumber.charAt(comIndex) == userNumber.charAt(userIndex)){
                    ball++;
                }
            }
        }
        if(strike==3) threeStrike=true;
        printHintMessage();
    }
}
