package baseball;

import java.util.List;

public class BaseballGameHint {
    private static final int NUMBER_LENGTH = 3;

    private static final String MESSAGE_BALL = "볼";
    private static final String MESSAGE_STRIKE = "스트라이크";
    private static final String MESSAGE_NOTHING = "낫싱";

    private List<Integer> computer;
    private List<Integer> player;
    private int ball;
    private int strike;

    public String generateHint(List<Integer> computerNumbers, List<Integer> playerNumbers){
        computer = computerNumbers;
        player = playerNumbers;
        ball = 0;
        strike = 0;

        for(int i=0;i<NUMBER_LENGTH;i++)
            checkBall(i);

        return printHintOfGame();
    }

    private String printHintOfGame() {
        StringBuilder hint = new StringBuilder();

        if(ball==0 && strike==0)
            hint.append(MESSAGE_NOTHING);
        if(ball != 0)
            hint.append(ball).append(MESSAGE_BALL);
        if(strike != 0){
            if(hint.length() != 0)
                hint.append(" ");
            hint.append(strike).append(MESSAGE_STRIKE);
        }
        return hint.toString();
    }

    private void checkBall(int index){
        int playerNumber = player.get(index);

        if(computer.contains(playerNumber)){
            if(!isStrike(playerNumber, index)){
                ball++;
            }
        }
    }

    private boolean isStrike(int playerNumber, int index){
        int computerNumber = computer.get(index);
        if(computerNumber == playerNumber){
            strike ++;
            return true;
        }
        return false;
    }

}
