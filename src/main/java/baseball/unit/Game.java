package baseball.unit;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> computerNumber;

    private final List<Integer> inputNumber;


    public Game(List<Integer> computerNumber, List<Integer> inputNumber) {
        this.computerNumber = computerNumber;
        this.inputNumber = inputNumber;
    }

    public List<Integer> count(){
        List<Integer> count = new ArrayList<>();

        int countStrike = 0;
        int countBall = 0;
        for(int i=0; i<inputNumber.size(); i++){
            if(computerNumber.get(i) == inputNumber.get(i)){
                countStrike++;
            }
            else if(computerNumber.contains(inputNumber.get(i))){
                countBall++;
            }
        }

        count.add(countStrike);
        count.add(countBall);

        return count;
    }

}
