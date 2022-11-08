package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    protected int answer;
    ArrayList<Integer> check = new ArrayList<>();

    public int randomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean checkNumber(Integer number) {
        return check.contains(number);
    }

    public void addNumber(Integer number) {
        check.add(number);
    }

    public void madeNumber() {
        while (check.size() < 3) {
            int randomNumber = randomNumber();
            if (!check.contains(randomNumber)) {
                addNumber(randomNumber);
            }
        }
    }

    public void setAnswer() {
        madeNumber();
        this.answer = (check.get(0) * 100) + (check.get(1) * 10) + check.get(2);
    }

}