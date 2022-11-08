package baseball;

import java.io.IOException;

public class BaseBallGame {
    // TODO: 랜덤 수 생성
    // TODO: 입력받기
    // TODO: 숫자 비교

    static InputHandler inputHandler = new InputHandler();
    static OutputHandler outputHandler = new OutputHandler();


    public void baseballGame(String randomNum) throws IOException {
        while(true) {
            String myNum = inputHandler.getInput_returnMyNum();

            int strike = findStrike(randomNum, myNum);
            int ball = findBoll(randomNum, myNum, strike);

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

    public int findBoll(String comNum, String myNum, int strikeCnt) {
        int ballCnt = 0 ;
        for(int i=0; i<comNum.length(); i++){
            if(myNum.contains(comNum.substring(i, i+1))){
                ballCnt +=1;
            }
        }
        if(strikeCnt ==0) return ballCnt;
        else return ballCnt - strikeCnt;
    }
}
