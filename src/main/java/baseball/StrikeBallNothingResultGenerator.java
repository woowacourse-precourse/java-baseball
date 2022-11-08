package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrikeBallNothingResultGenerator {

    private static final String BALL_STR = "볼";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";

    private int[] player;
    private int[] computer;

    private int strike;
    private int ball;


    ArrayList<int[]> playerLists = new ArrayList<int[]>();
    ArrayList<int[]> computerLists = new ArrayList<int[]>();


    public void Match() {
    }

    public void Match(int[] player, int[] computer) {
        this.player = player;
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;


        List<int[]> playerList = Arrays.asList(player);
        List<int[]> computerList = Arrays.asList(computer);

        for (int i = 0; i < 3; i++) {
            this.playerLists.add(playerList.get(i));
            this.computerLists.add(computerList.get(i));
        }


    }


    public void countStrike() {

        for (int position = 0; position < 3; position++) {

            if (computerLists.contains(playerLists.get(position))) {

                if (computerLists.indexOf(playerLists.get(position)) == position) {

                    strike++;
                    //strike 상황
                } else if (computerLists.indexOf(playerLists.get(position)) != position) {

                    ball++;
                    //ball 상황
                }

            }

        }


    }
    public void printResult() {
        System.out.println(getResultString());
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private String getResultString() {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        }
        StringBuilder stringMaker = new StringBuilder();
        if(ball > 0 ) {
            stringMaker.append(ball).append(BALL_STR);
        }
        if(strike > 0) {
            stringMaker.append(strike).append(STRIKE_STR);
        }
        return stringMaker.toString();
    }


}
