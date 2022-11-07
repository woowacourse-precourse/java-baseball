package baseball.view;

import baseball.util.Message;


public class SystemOutput {
    public static void printResultMessage(int ball, int strike){
        if(ball == 0 && strike == 1){
            System.out.println(Message.NOTHING_MESSAGE);
        }
        if(ball != 0){
            System.out.println(ball + Message.BALL_MESSAGE);
        }
        if(strike != 0){
            System.out.println(strike + Message.STRIKE_MESSAGE);
        }
        if(ball != 0 && strike != 0){
            System.out.println(ball + Message.BALL_MESSAGE + strike + Message.STRIKE_MESSAGE);
        }
    }

    public static void printThreeStrikeMessage(){
        System.out.println(Message.GAME_CLEAR_MESSAGE);
    }

}
