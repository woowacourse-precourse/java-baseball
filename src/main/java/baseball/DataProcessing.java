package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DataProcessing {
    private List<Integer> dataForProcess;
    private List<Integer> dataForCompare;
    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;

    DataProcessing() {
    }

    public void setData(List<Integer> inputData){
        this.dataForProcess = inputData;
    }

    public void makeRandomData() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.dataForCompare = computer;
    }

    private int checkStrike() {
        int count = 0;

        for (int i = 0; i < this.dataForProcess.size(); i++){
            int tempInputNumber = dataForProcess.get(i);
            int tempCompareNumber = dataForCompare.get(i);
            if (tempInputNumber == tempCompareNumber) {
                count += 1;
            }
        }
        return count;
    }

    private int checkBall() {
        int count = 0;

        for (int i = 0; i < this.dataForProcess.size(); i++){
            int tempInputNumber = dataForProcess.get(i);
            if (dataForCompare.contains(tempInputNumber)) {
                count += 1;
            }
        }
        return count;
    }

    public int[] getProcessedData() {
        int[] dataProcessed = new int[2];
        dataProcessed[STRIKE_INDEX] = checkStrike();
        dataProcessed[BALL_INDEX] = checkBall() - dataProcessed[STRIKE_INDEX]; // 스트라이크와 중복 빼주기
        return dataProcessed;
    }
}
