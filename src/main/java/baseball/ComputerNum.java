package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum implements Number {

    public ComputerNum() {}

    @Override
    public List<Integer> createNumber() {
        List<Integer> num = new ArrayList<>();
        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }

    @Override
    public void verifyNumber(List<Integer> presnum) {
        for (int number : presnum) {
            if (number < 1 || number > 9) {    //1~9까지 숫자 제한
                throw new IllegalArgumentException();
            } else if (presnum.size() != 3 || presnum.size() != presnum.stream().distinct().count()) {    //중복이랑 3개 제한
                throw new IllegalArgumentException();
            }
        }
    }
}
