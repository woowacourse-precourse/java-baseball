package baseball.game;

import baseball.print.Print;
import baseball.Input.Input;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computers;
    private List<Integer> userNumbers;
    private Boolean play;
    private Boolean correct;

    public Game() {
        this.computers = new ArrayList<>();
        this.play = true;
        this.correct = false;
    }

    public List<Integer> getComputers(){
        return computers;
    }

    public List<Integer> getUserNumbers(){
        return userNumbers;
    }

    public void answerIsCorrect(){
        this.correct = true;
    }

    public void start(){
        while(play){
            init();
            while(!correct){
                userNumbers=Input.input();
                Print.score(new Score(this));
            }
            replay();
        }

    }

    public void init(){
        Print.start();
        pickNumbers();
    }

    public void replay(){
        Print.correct();
        if (Input.replay()){
            correct = false;
            return;
        }
        quit();
    }

    public void quit(){
        Print.quit();
        play = false;
    }

    private void pickNumbers(){
        computers = new ArrayList<>();

        while (computers.size() < 3){
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computers.contains(num)){
                computers.add(num);
            }
        }
    }
}
