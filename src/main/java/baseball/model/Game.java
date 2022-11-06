package baseball.model;

import baseball.utility.Utility;

public class Game {
    User user;
    Computer computer;
    Referee referee;
    
    public Game(){
        user = new User();
        computer = new Computer();
        referee = new Referee();
    }

    public void startGame(){
        System.out.println(Utility.START_MESSAGE);
    }

    public int UserAsk(){
        return user.ask();    
    }

    public String judgeTheUser(int questionNumber){
        String judgement = referee.judge(questionNumber, computer.getRandom3Digits());
        System.out.println(judgement);
        return judgement;
    }

    public boolean endGame(String judgment){
        if(judgment.equals(String.format(Utility.STRIKE_MESSAGE, 3))){
            System.out.println(Utility.END_MESSAGE_1);
            return true;
        }
        else
            return false;
    }

    public boolean askUserToRestart(){
        System.out.println(Utility.END_MESSAGE_2);
        if(user.wantRestart())
            return true;
        else
            return false;
    }
}
