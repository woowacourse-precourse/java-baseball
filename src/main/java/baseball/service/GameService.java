package baseball.service;

import baseball.utils.Constants;
import baseball.utils.Exceptions;
import baseball.view.GameOutput;
import baseball.view.UserInput;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameService {

    int Strikescore;
    int Ballscore;

    public void initScore() {
        Strikescore = 0;
        Ballscore = 0;
    }

    public void getStrikeCount(ArrayList<Integer> User, ArrayList<Integer> Computer) {
        //자리, 숫자가 맞으면 Strike
        for (int i = 0; i < Constants.INPUT_SIZE; i++) {
            if (User.get(i)==Computer.get(i)) {
                Strikescore += 1;
            }
        }
    }

    public void getBallCount(ArrayList<Integer> User, ArrayList<Integer> Computer) {
        //자리는 안 맞지만 숫자는 맞으면 Ball
        for (int i = 0; i < Constants.INPUT_SIZE; i++) {
            if (Computer.contains(User.get(i)) && User.get(i)!=Computer.get(i)){
                Ballscore += 1;
            }
        }
    }

    public int finalScore(){
        GameOutput.scoreMessage(Ballscore,Strikescore);
        if (Strikescore==Constants.THREE_STRIKE) {
            return isRestart();
        }
        return 0;
    }

    public int isRestart(){
        UserInput.getRetryUserNumber();
        String str = Console.readLine();
        Exceptions.restartInput(str);
        int replay_input=Integer.parseInt(str);
        if (replay_input==Constants.END_GAME){
            GameOutput.finishGame();
        }
        return replay_input;
    }
}
