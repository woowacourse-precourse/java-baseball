package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ServiceImpl implements Service{

    @Override
    public void startGame() {
    }

    private List<Integer> pick() {
        Set<Integer> numSet = new HashSet<>();
        while (numSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numSet.add(randomNumber);
        }
        List<Integer> numList = new ArrayList<>(numSet);
        return numList;
    }

    private List<Integer> getUserNumber(){
        String input = Console.readLine();
        List<Integer> currInput = parser(input);
        return currInput;
    }




}
