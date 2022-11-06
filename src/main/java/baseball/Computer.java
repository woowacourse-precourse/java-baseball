package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final String computerNumbers;
    private final List<Integer> computerNumbersList;

    public Computer(){
        this.computerNumbersList = setComputerNumbersByList();
        this.computerNumbers = setComputerNumbersToString(this.computerNumbersList);
    }
    private List<Integer> setComputerNumbersByList() {
        List<Integer> newComputerNumber = new ArrayList<>();
        while (newComputerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newComputerNumber.contains(randomNumber)) {
                newComputerNumber.add(randomNumber);
            }
        }
        return newComputerNumber;
    }
    public List<Integer> getComputerNumbersList(){
        return this.computerNumbersList;
    }
    // set 수정 필요
    private String setComputerNumbersToString(List<Integer> computerNumbersList){
        return this.computerNumbers;
    }
}
