package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerList;

    public Computer() {
        this.computerList = createComputerNumberList();
    }
    //컴퓨터의 난수생성
    private List<Integer> createComputerNumberList(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getComputerList() {
        return computerList;
    }
}
