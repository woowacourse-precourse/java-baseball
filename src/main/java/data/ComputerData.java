package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerData {

    //1~9의 숫자가 몇번째 인덱스에 들어갔는지 저장하는 곳
    private List<Integer> computerData = new ArrayList<>(
            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));


    public List<Integer> getComputerData() {
        return computerData;
    }
}
