package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DataProcessing {
    private List<Integer> dataForProcess;
    private List<Integer> dataForCompare;
    public static final int BALL_INDEX = 0;

    DataProcessing() {
    }

    public void setData(List<Integer> inputData){
        this.dataForProcess = inputData;
    }

    public void makeRandomData(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.dataForCompare = computer;
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

    public int[] getProcessedData(){
        int[] dataProcessed = new int[2];
        makeRandomData();

        dataProcessed[BALL_INDEX] = checkBall();
        System.out.println(this.dataForProcess);
        return dataProcessed;
    }
}
