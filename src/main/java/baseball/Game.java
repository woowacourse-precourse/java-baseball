package baseball;
import java.util.List;

public class Game {
    private ComputerRandomNumber computerRandomNumber;
    private UserInputToList userInputToList;
    private Referee referee;

    public Game() {
        computerRandomNumber = new ComputerRandomNumber();
        userInputToList = new UserInputToList();
        referee = new Referee();
    }

    public void run() {
        List<Integer> comNumber = computerRandomNumber.makeComputerNumber();

        do{
            userInputToList.userNumList(UserInput.userNumberInput());
        }while (referee.refereeCheck(userInputToList.getUserNum(), comNumber));

        if(UserInput.replayOrStop().equals("1"))
            run();
    }
}
