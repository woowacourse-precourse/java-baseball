package baseball;

public class Rule {
    public int contain(String computer, String user) {
        int total = 0;
        for (String number : computer.split("")) {
            if (user.contains(number)) { // 몇개 숫자가 같은지
                total++;
            }
        }
        return total;
    }

    public int strike(String computer, String user) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (user.charAt(i) == computer.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }


}
