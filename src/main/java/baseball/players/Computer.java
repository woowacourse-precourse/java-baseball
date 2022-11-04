package baseball.players;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {

    private String computerNumbers = "";

    public Computer() {
        while (computerNumbers.length() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumbers.contains(number))
                this.computerNumbers += number;
        }
    }

    public String getComputerNumbers() {
        return computerNumbers;
    }
}
