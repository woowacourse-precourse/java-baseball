package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class User {
    List<Integer> user;
    int userNum;

    public User() {
        this.user = new ArrayList<>();
        this.userNum = 0;
    }

    void input() {
        userNum = Integer.parseInt(readLine());
    }

    void exception() {
        int tmp = userNum;

        while(tmp > 0) {
            user.add(0, tmp % 10);
            tmp = tmp / 10;
        }

        if(user.size() != 3) {
            throw new IllegalArgumentException();
        } else if(user.contains(0)) {
            throw new IllegalArgumentException();
        } else if(user.get(0).equals(user.get(1)) || user.get(0).equals(user.get(2)) || user.get(1).equals(user.get(2))) {
            throw new IllegalArgumentException();
        }
    }

    List<Integer> userNumber() {
        return user;
    }
}
