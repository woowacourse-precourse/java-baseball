package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    protected int answer;
    ArrayList<Integer> computer = new ArrayList<>();

    public int randomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean checkNumber(Integer number) {
        return computer.contains(number);
    }

    public void addNumber(Integer number) {
        computer.add(number);
    }

    public void madeNumber() {
        while (computer.size() < 3) {
            int randomNumber = randomNumber();
            if (!checkNumber(randomNumber)) {
                addNumber(randomNumber);
            }
        }
    }

    public void setNumber() {
        this.answer = (computer.get(0) * 100) + (computer.get(1) * 10) + computer.get(2);
    }

    public void madeAnswer(){
        madeNumber();
        setNumber();
    }

}