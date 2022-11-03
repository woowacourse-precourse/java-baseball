package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballCount {

    public int strikecount = 0;
    public int ballcount = 0;
    public List<Integer> computernums;
    public List<Integer> usernums;

    public BaseballCount(List<Integer> computernum, List<Integer> usernum) {
        this.computernums = computernum;
        this.usernums = usernum;
        BaseballStart();
    }


    public void BaseballStart() {
        for (int i = 0; i < computernums.size(); i++) {
            if (usernums.get(i) == computernums.get(i)) {
                strikecount++;
                continue;
            }
            if (computernums.contains(usernums.get(i))) {
                ballcount++;
            }

        }
    }


}
