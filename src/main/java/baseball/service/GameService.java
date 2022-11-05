package baseball.service;

import baseball.view.GameOutput;
import baseball.view.UserInput;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    //판단해서 점수를 산출하는 함수
    int Strikescore;
    int Ballscore;

    public void initScore() {
        Strikescore = 0;
        Ballscore = 0;
    }

    public void getStrikeCount(ArrayList<Integer> User, ArrayList<Integer> Computer) {
        //자리, 숫자가 맞으면 Strike
        for (int i = 0; i < 3; i++) {
            if (User.get(i)==Computer.get(i)) {
                Strikescore += 1;
            }
        }
    }

    public void getBallCount(ArrayList<Integer> User, ArrayList<Integer> Computer) {
        //자리는 안 맞지만 숫자는 맞으면 Ball
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i != j) && (User.get(i) == Computer.get(j))) {
                    Ballscore += 1;
                }
            }
        }
    }

    public boolean finalScore(){
        this.Strikescore = Strikescore;
        this.Ballscore = Ballscore;
        GameOutput.scoreMessage(Ballscore,Strikescore);
        if (Strikescore==3) {
            return isRestart();
        }
        return false;
    }

    public boolean isRestart(){
        this.Strikescore=Strikescore;
        UserInput.getRetryUserNumber();
        String replay_input = Console.readLine();
        return Integer.parseInt(replay_input)==1;
    }
}