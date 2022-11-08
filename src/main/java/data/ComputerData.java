package data;

import camp.nextstep.edu.missionutils.Randoms;
import util.Utils;

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

    //랜덤으로 컴퓨터 값 생성
    public void setRandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Utils.Numlen) {
            int randomNumber = Randoms.pickNumberInRange(Utils.STARTNUM, Utils.ENDNUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setComputerData(computer);
    }

    //랜덤으로 받은 숫자 인덱스에 숫자 위치 값 저장
    public void setComputerData(List<Integer> data){;
        int index=1;
        for(Integer integer: data) {
            computerData.set(integer, index);
            index++;
        }
    }

    //숫자 인덱스 값 반환 = 숫자 위치 값 변환
    public Integer getDataIndex(Integer integer){
        return computerData.get(integer);
    }
}
