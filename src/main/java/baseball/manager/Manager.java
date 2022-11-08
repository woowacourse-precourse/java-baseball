package baseball.manager;

import static baseball.checker.Checker.*;
import static baseball.utility.Utility.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class Manager {
    private String userInput;
    private String answer;
    public Manager(){
        System.out.println(OPENING);
    }

    public void printResult(List<Integer> list){
        int Strike = list.get(0);
        int ball = list.get(1);

        StringBuilder sb = new StringBuilder("");
        if(ball != 0) {
            sb.append(Integer.toString(ball));
            sb.append(BALL);
        }
        if(Strike != 0){
            if(sb.length() > 0) sb.append(" ");
            sb.append(Integer.toString(Strike));
            sb.append(Strike);
        }

        if(sb.length() == 0) {
            System.out.println(NOTHING);
        }
        if(sb.length() > 0){
            System.out.println(sb.toString());
        }
    }
}
