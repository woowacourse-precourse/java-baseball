package baseball.domain;

public class Game {
    private final Computer computer;
    private final User user;
    private final Referee referee;

    public Game(){
        user = new User();
        computer = new Computer();
        referee = new Referee();
    }
}
