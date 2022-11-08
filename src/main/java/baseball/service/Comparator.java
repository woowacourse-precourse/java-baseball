package baseball.service;


import baseball.model.Computer;
import baseball.model.User;

public class Comparator {

    public static int checkStrike(Computer computer, User user) {
        int strikeCount = 0;
        for (int i = 0; i < user.getNumbers().size(); i++) {
            Integer userNumber = user.getNumbers().get(i);
            if (computer.getNumbers().get(i).equals(userNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

}