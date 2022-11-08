package baseball.model;

import baseball.view.AppView;

import java.util.ArrayList;
import java.util.List;

public class ResultModel {
    private int ballNum;
    private int strikeNum;

    public ResultModel() {
        this.ballNum = 0;
        this.strikeNum = 0;
    }

    public void injectElementToList(List<Integer> NumList, int num) {
        NumList.add(num / 100);
        NumList.add((num % 100) / 10);
        NumList.add(num % 10);
    }

    public void compareInputListWithResultList(List<Integer> inputNumList, List<Integer> resultNumList, int idx) {
        if(resultNumList.contains(inputNumList.get(idx))) {
            if(resultNumList.get(idx) == inputNumList.get(idx)) {
                strikeNum = strikeNum + 1;
            }

            if(resultNumList.get(idx) != inputNumList.get(idx)) {
                ballNum = ballNum + 1;
            }
        }
    }

    public void calResult(int inputNum, List<Integer> resultNumList) {
        List<Integer> inputNumList = new ArrayList<>();
        injectElementToList(inputNumList, inputNum);

        for(int idx=0 ; idx<3 ; idx++) {
            compareInputListWithResultList(inputNumList, resultNumList, idx);
        }
    }

    public void printResult() {
        if(ballNum == 0 && strikeNum == 0) {
            AppView.outputLine("낫싱");
            return;
        }

        if(strikeNum == 3) {
            AppView.outputLine("3스트라이크");
            return;
        }

        if(ballNum != 0 && strikeNum != 0) {
            AppView.outputLine(Integer.toString(ballNum)+"볼 " + Integer.toString(strikeNum)+"스트라이크");
            return;
        }

        if(ballNum == 0) {
            AppView.outputLine(Integer.toString(strikeNum)+"스트라이크");
            return;
        }

        if(strikeNum == 0) {
            AppView.outputLine(Integer.toString(ballNum)+"볼");
        }
    }

    public boolean distinguishResult() {
        if(strikeNum == 3) {
            return true;
        }

        return false;
    }
}
