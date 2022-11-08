package baseball;

import java.util.List;

public class Strike {
    public int count(List<String> computer, List<String> user) {
        int count = 0;
        for(int i=0;i<3;i++) {
            if(checkStrike(i, computer, user)) {
                count++;
            }
        }
        return count;
    }
    public boolean checkStrike(int index, List<String> computer, List<String> user) {
        return computer.get(index).equals(user.get(index));
    }
}
