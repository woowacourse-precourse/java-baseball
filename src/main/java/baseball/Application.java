package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List comList = comNumber();
        List userList = userNumber();
        score(comList, userList);
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
    
    // 점수 판단 기능
    public static void score(List comList, List userList) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<comList.size(); i++) {
            if(comList.get(i) == userList.get(i)) {
                strike++;
                userList.set(i, 0);
            } else if (userList.contains(comList.get(i))) {
                ball++;
            }
        }

        System.out.println(strike +" 스트라이크 " +ball +" 볼");
    }
}
