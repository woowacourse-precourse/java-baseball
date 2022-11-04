package baseball.service;

import baseball.domain.User.*;

import java.util.ArrayList;

public class GameService {
    //판단하는 함수
    int Strikescore;
    int Ballscore;

    public void initScore() {

        Strikescore = 0;
        Ballscore = 0;
    }

    public void getStrikeCount(ArrayList<Integer> User, ArrayList<Integer> Computer) {
        //자리, 숫자가 맞으면 Strike
        for (int i = 0; i < 5; i++) {
            if (User.get(i) == Computer.get(i)) {
                Strikescore += 1;
            }
        }
    }

    public void getBallCount(ArrayList<Integer> User, ArrayList<Integer> Computer) {
        //자리는 안 맞지만 숫자는 맞으면 Ball
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j && User.get(i) == Computer.get(j)) {
                    Ballscore += 1;
                }
            }
        }
    }
}