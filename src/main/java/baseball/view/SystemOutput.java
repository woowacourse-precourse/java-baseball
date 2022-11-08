package baseball.view;

import baseball.util.Message;
import camp.nextstep.edu.missionutils.Console;


public class SystemOutput {
    public static void printResultMessage(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println(Message.NOTHING_MESSAGE);
        }else if(ball == 0){
            System.out.println(strike + Message.STRIKE_MESSAGE);

        }else if(strike == 0){
            System.out.println(ball + Message.BALL_MESSAGE);
        }else{
            System.out.println(ball + Message.BALL_MESSAGE + strike + Message.STRIKE_MESSAGE);

        }
    }

    public static void printThreeStrikeMessage(){

        System.out.println(Message.GAME_CLEAR_MESSAGE);
    }

    public static String printUserInput(){
        System.out.println(Message.SET_USER_INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
