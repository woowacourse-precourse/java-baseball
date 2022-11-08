package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Objects;
public class Computer {
    public Computer() {}

    private final ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>();

    public void chooseThreeNumbers(){
        while(numbersChosenByTheComputer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            identifyDuplicateNumbers(randomNumber);
        }
    }

    private void identifyDuplicateNumbers(int randomNumber) {
        if(!numbersChosenByTheComputer.contains(randomNumber)){
            numbersChosenByTheComputer.add(randomNumber);
        }
    }

    public ArrayList<Integer> getNumbersChosenByTheComputer() {
        return numbersChosenByTheComputer;
    }

    @Override
    public String toString() {
        return "컴퓨터가 고른 3개의 숫자 :"
                + " [" + numbersChosenByTheComputer.get(0) + "]"
                + " [" + numbersChosenByTheComputer.get(1) + "]"
                + " [" + numbersChosenByTheComputer.get(2) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(getNumbersChosenByTheComputer(), computer.getNumbersChosenByTheComputer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbersChosenByTheComputer());
    }
}
