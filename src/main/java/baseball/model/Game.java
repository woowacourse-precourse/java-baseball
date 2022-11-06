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
}
