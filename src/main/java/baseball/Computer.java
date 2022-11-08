package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private int startNumber = 1;
    private int endNumber = 9;
    private int location = 3;

    private List<Integer> computerNumber = new ArrayList<>();

    public void computerGameSetting() {
        Set<Integer> setNumber = new HashSet<>();

        while (setNumber.size() != location) {
            setNumber.add(Randoms.pickNumberInRange(startNumber, endNumber));
        }
        computerNumber = new ArrayList<>(setNumber);
    }


    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
