package baseball;

import camp.nextstep.edu.missionutils.*;

public class MakeRandomString {

    public static String run() {
        String res = "";

        while (res.length() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!res.contains(randomNumber)) {
                res += randomNumber;
            }
        }

        return res;
    }

}
