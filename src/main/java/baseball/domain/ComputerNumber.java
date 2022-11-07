package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class ComputerNumber {
    public Integer hundredNumber;
    public Integer tenNumber;
    public Integer number;
    public List<String> computerNumberList;

    public ComputerNumber(){
        hundredNumber = Randoms.pickNumberInRange(1, 9);
        tenNumber = Randoms.pickNumberInRange(1, 9);
        number = Randoms.pickNumberInRange(1, 9);
    }


}
