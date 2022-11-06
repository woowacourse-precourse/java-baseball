package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Implement {
    final static int ANSWER_SIZE = 3;

    public Game checkBallStrike(List<Integer> computerAnswer, List<Integer> UserAnswer){
        Game game = new Game();
        for (int aLetter : UserAnswer) {
            if (letterIncludeAnswerCheck(computerAnswer, aLetter)) {
                game.addBall();
                if (computerAnswer.indexOf(aLetter) == UserAnswer.indexOf(aLetter)) {
                    game.addStrike();
                }
            }
        }
        return game;
    }

    public boolean letterIncludeAnswerCheck(List<Integer> computerAnswer, int aLetter) {
        if (computerAnswer.contains(aLetter)) {
            return true;
        }
        return false;
    }
//    public void letterSamePositionAnswerCheck()
}
