package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class Input {
    private final static int LENGTH_MAX = 3;

    static String computer () {
        String number = new String();
        while (number.length() < LENGTH_MAX) {
            String str = String.valueOf(Randoms.pickNumberInRange(1,9));
            if (!number.contains(str)) {
                number = number.concat(str);
            }
        }
        return number;
    }

    static String
}


