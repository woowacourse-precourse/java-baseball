package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    protected int answer;
    ArrayList<Integer> numberList = new ArrayList<>();

    public int randomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean checkNumber(Integer number) {
        return numberList.contains(number);
    }

    public void addNumber(Integer number) {
        numberList.add(number);
    }

    public void madeNumber() {
        while (numberList.size() < 3) {
            int randomNumber = randomNumber();
            if (!checkNumber(randomNumber)) {
                addNumber(randomNumber);
            }
        }
    }

    public void setNumber() {
        this.answer = numberList.get(0) * 100 + numberList.get(1) * 10 + numberList.get(2);
    }

    public void madeAnswer() {
        madeNumber();
        setNumber();
    }

}