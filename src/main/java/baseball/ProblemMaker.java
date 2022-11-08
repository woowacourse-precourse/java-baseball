package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ProblemMaker extends Player {
    public void makeProblem(int sizeOfNumbers) {
        initialize();

        while (getNumbers().size() < sizeOfNumbers) {
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if (!getNumbers().contains(randomNum)) {
                addNumber(randomNum);
            }
        }
    }

    public boolean hasNumber(int number) {
        return getNumbers().contains(number);
    }

    public boolean isSameAtGivenLocation(int number, int index) {
        return getNumbers().get(index).equals(number);
    }
}
