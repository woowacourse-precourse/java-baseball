package baseball;

import java.util.List;

public class CompareComputerWithUser {


    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        for (int position = 0; position < 3; position++) {
            if (computerNumber.contains(userNumber.get(position))) {

                if (computerNumber.indexOf(userNumber.get(position)) == position) {

                    strikeCount++;
                    //strike 상황
                }
            }
        }

        return strikeCount;

    }


}
