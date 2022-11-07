package baseball.players;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer implements Player {

    private String computerNumbers = "";

    public String generateNumbers() {
        while (computerNumbers.length() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumbers.contains(number))
                this.computerNumbers += number;
        }

        return computerNumbers;
    }
}
