package baseball;

import java.util.List;

public class Output {
    private Hint hint;

    public static void askRestart(){
        System.out.println(Message.RESTART.getMessage());
    }

    public static void getNumber(){
        System.out.println(Message.INPUT_ASK);
    }

    public void giveHint(List<Integer> playerAnswer, List<Integer> answer){
        System.out.println(hint.compareNumber(playerAnswer, answer));
    }

}
