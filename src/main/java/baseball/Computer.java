package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private BaseballList baseballList;

    public void setComputerBaseballList(){
        this.baseballList = new BaseballList(Randoms.pickUniqueNumbersInRange(1,9,3));
    }

}
