package baseball;

import java.util.ArrayList;

public class DataProcessing {
    private ArrayList<Integer> dataForProcess;

    DataProcessing() {
    }
    public void setData(ArrayList<Integer> inputData){
        this.dataForProcess = inputData;
    }
    public int[] get_processed_data(){
        int[] data = new int[3];
        System.out.println(this.dataForProcess);
        return data;
    }
}
