package baseball.model;

import java.util.ArrayList;
import java.util.List;

enum ResultList {
    Ball("볼"),
    STRIKE("스트라이크"),
    NOTTING("낫싱");

    final private String result;

    ResultList(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}

public class ResultModel {
    private int ballNum;
    private int strikeNum;

    public ResultModel() {
        this.ballNum = 0;
        this.strikeNum = 0;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public void setStrikeNum(int strikeNum) {
        this.strikeNum = strikeNum;
    }

    public void injectElementToList(List<Integer> NumList, int num) {
        NumList.add(num % 10);
        NumList.add((num / 10) % 10 % 10);
        NumList.add(num / 100 % 10);
    }

    public void compareInputNumWithResultNum(int inputNum, int resultNum) {
        List<Integer> inputNumList = new ArrayList<>();
        List<Integer> resultNumList = new ArrayList<>();
        injectElementToList(inputNumList, inputNum);
        injectElementToList(resultNumList, resultNum);
    }
}
