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

    public static int checkBall(Computer computer, User user) {
        int ballCount = 0;
        for (int i = 0; i < user.getNumbers().size(); i++) {
            Integer userNumber = user.getNumbers().get(i);
            if (computer.getNumbers().contains(userNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static boolean printHint(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            return true;
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount+"볼 " + strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount + strikeCount == 0) {
            System.out.println("낫싱");
        }
        return false;
    }

}