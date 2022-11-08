package baseball;


import java.util.List;

public class BaseBallGame {

    static InputHandler inputHandler = new InputHandler();
    static OutputHandler outputHandler = new OutputHandler();


    public void baseballGame(List<Integer> randomNum) {

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
    public static int findStrike(List<Integer> comNum, String myNumList) {

        int strikeCnt = 0;
        char[] myNum = myNumList.toCharArray();

        for (int i = 0; i < comNum.size(); i++) {
            if (comNum.indexOf(Character.getNumericValue(myNum[i])) == i) {
                strikeCnt += 1;
            }
        }
        return strikeCnt;
    }

    public int findBall(List<Integer> comNum, String myNumList, int strikeCnt) {
        int ballCnt = 0;
        char[] myNum = myNumList.toCharArray();
        for(int i=0; i<comNum.size(); i++){
            if(comNum.contains(Character.getNumericValue(myNum[i]))){
                ballCnt +=1;
            }
        }
        return ballCnt - strikeCnt;
    }
}
