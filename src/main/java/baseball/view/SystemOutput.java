package baseball.view;

import baseball.model.UserNumber;
import baseball.util.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class SystemOutput {
    public static void printResultMessage(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println(Message.NOTHING_MESSAGE);
        }
        if(ball != 0 && strike == 0){
            System.out.println(ball + Message.BALL_MESSAGE);
        }
        if(strike != 0 && ball == 0){
            System.out.println(strike + Message.STRIKE_MESSAGE);
        }
        if(ball != 0 && strike != 0){
            System.out.println(ball + Message.BALL_MESSAGE + strike + Message.STRIKE_MESSAGE);
        }
    }

    public static void printThreeStrikeMessage(){
        System.out.println(Message.GAME_CLEAR_MESSAGE);
    }

    public static List<Integer> printUserInput(){
        String word = "";
        System.out.println(Message.SET_USER_INPUT_NUMBER_MESSAGE + word);
        word = Console.readLine();

        UserNumber userNumber = new UserNumber(word);
        return userNumber.getUserNumber(word);
    }
}
