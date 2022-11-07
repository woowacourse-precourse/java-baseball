package baseball.game;

import baseball.print.Print;
import baseball.Input.Input;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computers;
    private Boolean play;
    private Boolean correct;
    private final Input user;

    public Game(Input user) {
        this.user = user;
        this.computers = new ArrayList<>();
        this.play = true;
        this.correct = false;
    }

    public List<Integer> getComputers(){
        return computers;
    }

    public List<Integer> getUserNumbers(){
        return user.getNumbers();
    }

    public void answerIsCorrect(){
        this.correct = true;
    }

    public void start(){
        while(play){
            init();
            while(!correct){
                user.input();
                Print.score(new Score(this));
            }
        }

    }

    public void init(){
        Print.start();
        pickNumbers();
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
