package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        comNumber();
        userNumber();
    }

    // 컴퓨터의 서로 다른 숫자 3개 저장
    public static List comNumber() {
        List<Integer> comList = new ArrayList<>();

        for (int i=0; i<3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);

            if(!comList.contains(num)) {
                comList.add(num);
            } else {
                i--;
            }
        }

        return comList;
    }

    // 사용자의 숫자 저장
    public static List userNumber() {
        List<Integer> userList = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        String userNum = Console.readLine();

        for (int i=0; i<3; i++) {
            userList.add(userNum.charAt(i) - '0');
        }

        return userList;
    }
}
