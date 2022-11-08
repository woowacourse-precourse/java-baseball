package baseball.Controller;

import static baseball.Constants.Constants.ANSWER;
import static baseball.Constants.Constants.GAME_END;
import static baseball.Constants.Constants.GAME_RESTART;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.Constants.Constants;
import baseball.Domain.ThrowBall;
import baseball.Service.Rule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Rule rule = new Rule();
    public String gameStart()
    {
        List<Integer> computerAnswer = new ArrayList<>();
        while(computerAnswer.size()<3) {
            int tmp = Randoms.pickNumberInRange(1, 9);
            if(!computerAnswer.contains(tmp))
            {
                computerAnswer.add(tmp);
            }
        }
        String answer;
        System.out.println(Constants.GAME_START);

        do {
        String input = readLine();
        if(input.length()>=4)
        {
            throw new IllegalArgumentException();
        }
        ThrowBall throwBall = new ThrowBall(input);
        answer = rule.ruleCheck(computerAnswer,throwBall);
        System.out.println(answer);
    }while(!answer.equals("3스트라이크"));
        System.out.println(ANSWER+" "+GAME_END);
        return answer;
    }

    public boolean gameRestart()throws IllegalArgumentException{
        System.out.println(GAME_RESTART);
        String input = readLine();
        if (input.equals("1")) {
            gameStart();
            return true;
        } else if (input.equals("2")) {
            return false;
        }else{
           throw new IllegalArgumentException();
        }
    }
}
