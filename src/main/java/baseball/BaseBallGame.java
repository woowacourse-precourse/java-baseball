package baseball;

import java.io.IOException;

public class BaseBallGame {

    static InputHandler inputHandler = new InputHandler();
    static OutputHandler outputHandler = new OutputHandler();


    public void baseballGame(String randomNum) {
        while(true) {
            String myNum = inputHandler.getInput_returnMyNum();

            int strike = findStrike(randomNum, myNum);
            int ball = findBall(randomNum, myNum, strike);

            outputHandler.Strike_andBall_result_print(strike, ball);
            if(strike==3){
                break;
            }
        }
    }
    public static int findStrike(String comNum, String myNum) {
        int strikeCnt = 0;
        for(int i=0; i<comNum.length(); i++){
            if(myNum.charAt(i)==comNum.charAt(i)){
                strikeCnt +=1;
            }
        }
        return strikeCnt;
    }

    public int findBall(String comNum, String myNum, int strikeCnt) {
        int ballCnt = 0 ;
        for(int i=0; i<comNum.length(); i++){
            if(myNum.contains(comNum.substring(i, i+1))){
                ballCnt +=1;
            }
        }
        return ballCnt - strikeCnt;
    }
}
