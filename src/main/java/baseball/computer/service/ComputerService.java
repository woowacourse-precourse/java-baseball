package baseball.computer.service;

import baseball.computer.entity.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class ComputerService extends Computer {
    private final Set<Integer> usedNumbers;

    public ComputerService() {
        this.usedNumbers = new HashSet<>();
    }

    public void setRandomNumber() {
        for(int i = 0; i < computerNumbers.length; i++) {
            randomNumber = getRandomNumber();
            computerNumbers[i] = getRandomNumber(randomNumber, i);
        }

        clearUsedNumbersSet();
    }

    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public Integer getRandomNumber(int randomNumber, int index){
        if(!usedNumbers.contains(randomNumber)) {
            usedNumbers.add(randomNumber);
        } else {
            randomNumber = getRandomNumber();
            randomNumber = getRandomNumber(randomNumber, index);
        }

        return randomNumber;
    }

    public void clearUsedNumbersSet(){
        usedNumbers.clear();
    }
}

