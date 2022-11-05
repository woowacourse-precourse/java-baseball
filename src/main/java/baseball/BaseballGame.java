package baseball;

import java.util.List;

public class BaseballGame {
    private static final int MAX_STRIKE = 3;
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

    public void printCompareResult(){
        String result = "";

        if ((strikeCount == 0) && (ballCount == 0)) {
            result += GameMessage.nothing;
        }
        if ((strikeCount == 0) && (ballCount != 0)) {
            result += (ballCount + GameMessage.ball);
        }
        if ((strikeCount != 0) && (strikeCount ==0)) {
            result += (strikeCount + GameMessage.strike);
        }
        if ((strikeCount != 0) && (ballCount != 0)) {
            result += (ballCount + GameMessage.ball);
            result += " ";
            result += (strikeCount + GameMessage.strike);
        }

        System.out.println(result);

        if (strikeCount == MAX_STRIKE) {
            System.out.println(GameMessage.end);
        }
    }
}
