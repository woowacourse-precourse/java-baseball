package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DataProcessing {
    private List<Integer> dataForProcess;
    private List<Integer> dataForCompare;

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
        dataForCompare = computer;
    }

    public int[] getProcessedData(){
        int[] data = new int[3];
        System.out.println(this.dataForProcess);
        return data;
    }
}
