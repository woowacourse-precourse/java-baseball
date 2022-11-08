package baseball;

import baseball.pitch.PitchResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> number = new ArrayList<>();

    public Computer() {}

    public void createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        this.number = computer;
    }

    public PitchResult compareToInputNumber(List<Integer> inputNumber) {

        int ball = 0;
        int strike = 0;

        for (int index = 0; index < 3; index++) {
            int value = inputNumber.get(index);

            if (this.number.get(index).equals(value)) {
                strike++;
                continue;
            }

            if (this.number.contains(value)) {
                ball++;
            }
        }

        return new PitchResult(ball, strike);
    }
}