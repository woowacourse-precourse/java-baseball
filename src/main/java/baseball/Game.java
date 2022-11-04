package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static final int DIGIT = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public void run() {

    }

    public List<Integer> getComputerNum() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            computer.add(randomNumber);
        }
        return convertSettoList(computer);
    }

    private List<Integer> convertSettoList(Set<Integer> set){
         return new ArrayList<>(set);
    }



}
