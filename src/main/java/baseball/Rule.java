package baseball;

import java.util.List;

public class Rule {
    int strike;
    int ball;

    public void strikeRule(List<Integer> computerNumbers, List<Integer> userNumbers) {

        int computerNumber1 = computerNumbers.get(0);
        int computerNumber2 = computerNumbers.get(1);
        int computerNumber3 = computerNumbers.get(2);

        int userNumber1 = userNumbers.get(0);
        int userNumber2 = userNumbers.get(1);
        int userNumber3 = userNumbers.get(2);

        if (computerNumber1 == userNumber1) {
            strike++;
        }

        if (computerNumber2 == userNumber2) {
            strike++;
        }

        if (computerNumber3 == userNumber3) {
            strike++;
        }
    }

    public void ballRule(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int computerNumber1 = computerNumbers.get(0);
        int computerNumber2 = computerNumbers.get(1);
        int computerNumber3 = computerNumbers.get(2);

        int userNumber1 = userNumbers.get(0);
        int userNumber2 = userNumbers.get(1);
        int userNumber3 = userNumbers.get(2);

        if (computerNumber1 != userNumber1 && computerNumbers.contains(userNumber1)) {
            ball++;
        }
        if (computerNumber2 != userNumber2 && computerNumbers.contains(userNumber2)) {
            ball++;
        }
        if (computerNumber3 != userNumber3 && computerNumbers.contains(userNumber3)) {
            ball++;
        }
    }


}