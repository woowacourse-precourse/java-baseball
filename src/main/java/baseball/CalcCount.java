package baseball;

import java.util.ArrayList;
import java.util.List;

public class CalcCount {

    public List<Integer> CountStrike(String userRandNumber, List<Integer> correctRandNumber) {
        // count STRIKE
        int countStrike = 0;
        for (int i = 0; i < correctRandNumber.size(); i++) {
            int eachUserNumber = userRandNumber.charAt(i) - '0';
            if (eachUserNumber == correctRandNumber.get(i)) {
                countStrike++;
            }
        }

        //count BALL
        int countBall = 0;
        for (int i = 0; i < correctRandNumber.size(); i++) {
            int eachUserNumber = userRandNumber.charAt(i) - '0';
            if (eachUserNumber == correctRandNumber.get(i)) {
                countBall = countBall;
            } else if (correctRandNumber.contains(eachUserNumber)) {
                countBall++;
            }
        }

        List<Integer> countStrBall = new ArrayList<>();
        countStrBall.add(countStrike);
        countStrBall.add(countBall);

        return countStrBall;
    }
}
