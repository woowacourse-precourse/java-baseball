package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public List<Integer> setComputer() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }

        return computer;
    }
    public void checkUserHasException(List<Integer> user) throws Exception{
        Exception userException = new IllegalArgumentException();

        if(!(user.size() == 3)) { throw  userException; }

        for(Integer number : user) {
            if(number == 0) { throw userException; }

            if(user.contains(number)) { throw userException; }
        }

    }

}
