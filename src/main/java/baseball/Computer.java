package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int ANSWER_LENGTH = 3;

    private List<Integer> computer;

    public void generateAnswer() {
        computer = new ArrayList<>();
        while (computer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
                System.out.print(randomNumber + " ");
            }
        }
    }

    public List<Integer> getAnswer(){
        return computer;
    }

}
