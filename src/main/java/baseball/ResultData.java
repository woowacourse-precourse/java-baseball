package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultData {
    private final List<Integer> gameNumberList;
    private int strike;
    private int ball;

    public ResultData(List<Integer> gameNumberList, List<Integer> userNumberList, int strike, int ball) {
        this.gameNumberList = gameNumberList;
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
        return strikeNumberList;
    }

    public int getStrike() {
        return strike;
    }

    public void printResult() {
        String strikeStr = "";
        String ballStr = "";

        if (strike != 0) {
            strikeStr = strike + "스트라이크";
        }
        if (ball != 0) {
            ballStr = ball + "볼 ";
        }
        String resultStr = ballStr + strikeStr;
        if (!resultStr.equals("")) {
            System.out.println(resultStr);
        } else {
            System.out.println("낫싱");
        }
    }


}
