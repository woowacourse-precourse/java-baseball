package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class GameSet {
    private List<Integer> computerAnswer;
    private List<Integer> userAnswer;
    private Integer strike;
    private Integer ball;

    public GameSet() {
        setComputerAnswer();
    }
    public void setComputerAnswer(){
        computerAnswer = new ArrayList<>();
        while(computerAnswer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerAnswer.contains(randomNumber))
                computerAnswer.add(randomNumber);
        }
    }
    public List<Integer> playBaseballGame(){
        PrintMessage.inputUserNum();
        String inputNumber = Console.readLine();
        this.userAnswer = makeUserAnswer(inputNumber);
    }

    public List<Integer> makeUserAnswer(String inputNumber){

    }
}
