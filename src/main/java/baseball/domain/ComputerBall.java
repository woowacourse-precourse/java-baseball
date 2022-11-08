package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBall {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int COMPUTER_NUM_LENGTH = 3;
    public ArrayList<Integer> computerNumber;

    public ComputerBall() {
        computerNumber = new ArrayList<>();
    }

    public void generateComputerNum(){
        Set<Integer> generateNumSet = new HashSet<>();

        while (generateNumSet.size() != COMPUTER_NUM_LENGTH){
            generateNumSet.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }

        computerNumber = new ArrayList<Integer>(generateNumSet);
    }
}
