package baseball.service;

import baseball.utils.Exceptions;
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
            if (Computer.contains(User.get(i)) && User.get(i)!=Computer.get(i)){
                Ballscore += 1;
            }
        }
    }

    public void getCount(int User, int Computer,int score){
        if (User==Computer){
            score+=1;
        }
    }
    public Integer finalScore(){
        this.Strikescore = Strikescore;
        this.Ballscore = Ballscore;
        GameOutput.scoreMessage(Ballscore,Strikescore);
        if (Strikescore==3) {
            return isRestart();
        }
        return 0;
    }

    public Integer isRestart(){
        this.Strikescore=Strikescore;
        UserInput.getRetryUserNumber();
        String str = Console.readLine();
        Exceptions.restartInput(str);
        Integer replay_input=Integer.parseInt(str);
        if (replay_input==2){
            GameOutput.finishGame();
        }
        return replay_input;
    }
}