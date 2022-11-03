package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {

    public int generateRandomNumber() {
        String hundred = String.valueOf(Randoms.pickNumberInRange(1,9));
        String ten = String.valueOf(Randoms.pickNumberInRange(1,9));
        String one = String.valueOf(Randoms.pickNumberInRange(1,9));

        StringBuffer sb = new StringBuffer();
        sb.append(hundred);
        sb.append(ten);
        sb.append(one);

        String strNumber = sb.toString();
        int computerNumber = Integer.parseInt(strNumber);

        return computerNumber;
    }
}
