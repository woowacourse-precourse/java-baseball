package baseball;

import java.util.List;

public class BaseballGame {
    private  int ballCount;
    private int strikeCount;
    private List<Integer> userNumber;
    private List<Integer> computerNumber;

    public BaseballGame(List<Integer> user, List<Integer> computer) {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.userNumber = user;
        this.computerNumber = computer;
    }

    public void start() {
        System.out.println(GameMessage.start);
    }

    public void isNothing() {
        List<Integer> userNumber = User.userNumber();
        List<Integer> computerNumber = Computer.computerNumber();

        if(!computerNumber.contains(userNumber)) {
            System.out.println(GameMessage.nothing);
        }
    }

    public boolean isStrike() {
        boolean isStrike = false;

        for (int strikeCountIndex = 0; strikeCountIndex < computerNumber.size(); strikeCountIndex++) {
            if (computerNumber.get(strikeCountIndex).equals(userNumber.get(strikeCountIndex))) {
                strikeCount++;
                isStrike = true;
            }
        }

        return isStrike;
    }

    public boolean isBall() {
        boolean isBall = false;

        if ((computerNumber.contains(userNumber)) && (!isStrike())) {
            ballCount++;
            isBall = true;
        }

        return isBall;
    }
}
