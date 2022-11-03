package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultData {
    private List<Integer> gameNumberList = new ArrayList<>();
    private List<Integer> userNumberList = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;

    public ResultData(List<Integer> gameNumberList, List<Integer> userNumberList, int strike, int ball) {
        this.gameNumberList = gameNumberList;
        this.userNumberList = userNumberList;
        this.strike = strike;
        this.ball = ball;
        List<Integer> strikeNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            strikeNumberList = strikeCount(gameNumberList.get(i), userNumberList.get(i), strikeNumberList);
        }
    }




    public List<Integer> strikeCount(int gameNumber, int userNumber, List<Integer> strikeNumberList) {
        if (Objects.equals(gameNumber, userNumber)) {
            strike++;
            strikeNumberList.add(gameNumber);
        }
        if (gameNumberList.contains(userNumber) && !strikeNumberList.contains(userNumber)) {
            ball++;
        }
        System.out.println(gameNumberList);
        System.out.println(userNumberList);
        System.out.println(strike + "" + ball);
        return strikeNumberList;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }


}
