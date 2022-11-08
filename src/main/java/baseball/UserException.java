package baseball;

import java.util.List;

public class UserException {

    public void checkUserHasException(List<Integer> user) {

        if(!(user.size() == 3)) { throw new IllegalArgumentException(); }

        for(Integer number : user) {
            if(number == 0) { throw new IllegalArgumentException(); }
        }


        for(int userIndex = 1; userIndex < user.size(); userIndex++) {
            int zeroNum = user.get(0);
            int firstNum = user.get(1);

            if(zeroNum == user.get(userIndex)) { throw new IllegalArgumentException(); }

            if(userIndex != 2) { continue; }

            if(firstNum == user.get(userIndex)) { throw new IllegalArgumentException(); }

        }
    }

}
