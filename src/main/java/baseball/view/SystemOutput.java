package baseball.view;

import baseball.util.Message;

import java.util.List;

public class SystemOutput {
    public static void printResultMessage(List<Integer> result){
        if(result.get(0) == 0 && result.get(1) == 1){
            System.out.println(Message.NOTHING_MESSAGE);
        }
        if(result.get(0) != 0){
            System.out.println(result.get(0) + Message.BALL_MESSAGE);
        }
        if(result.get(1) != 0){
            System.out.println(result.get(1) + Message.STRIKE_MESSAGE);
        }
    }

}
