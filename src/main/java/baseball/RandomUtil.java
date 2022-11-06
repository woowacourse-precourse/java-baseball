package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomUtil {

    public List<String> giveComputerNumber(){
        RandomUtil randomUtil = new RandomUtil();
        CheckUtil checkUtil = new CheckUtil();

        List<String>comNum = randomUtil.makeComputerNumber();
        checkUtil.checkIsDuplicated(comNum);

        return comNum;
    }

    private List<String> makeComputerNumber(){
        List<String> comNumberList = new ArrayList<>();
        boolean[] ch=new boolean[10];
        while (comNumberList.size()<3) {
            int tmp = Randoms.pickNumberInRange(1,9);
            if(!ch[tmp]){
                comNumberList.add(Integer.toString(tmp));
                ch[tmp]=true;
            }
        }
        return comNumberList;
    }
}
