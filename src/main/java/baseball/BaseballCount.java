package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballCount {

    public int strikecount = 0;
    public int ballcount = 0;
    public BaseballCount(List<Integer> computernums, List<Integer> usernums) {
        BaseballStart(computernums,usernums);
    }


    public void BaseballStart(List<Integer> computernums, List<Integer> usernums) {
        for (int i = 0; i < computernums.size(); i++) {
            if (Strike(computernums,usernums,i)) {
                strikecount++;
                continue;
            }
            if (Ball(computernums,usernums,i)) {
                ballcount++;
            }

        }
    }
    private boolean Strike(List<Integer> computernum, List<Integer> usernum,int index){
        return usernum.get(index) == computernum.get(index);
    }
    private boolean Ball(List<Integer> computernum, List<Integer> usernum,int index){
        return computernum.contains(usernum.get(index));
    }


}
