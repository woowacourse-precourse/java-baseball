package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {

        System.out.println(computerNumber());
    }


    // 컴퓨터가 3개의 랜덤 수 생성

    public static ArrayList<Integer> computerNumber() {
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            int randomNum = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            if (!list.contains(randomNum)) {
                list.add(randomNum);
            }
        }
        return list;
    }

//     사용자가 3개의 수 입력
//    public ArrayList<Integer> userNumber(){
//        ArrayList <Integer> userNum = new ArrayList<>();
//        String usersNum = Console.readLine();
//        for (int i = 0; i < 3; i++){
//
//        }
//
//
//        return userNum;
//    }
//
//    // 사용자 입력 정답 검사
//    public static checkAnswer{
//
//    }
//
//    // 정답 검사 결과 출력
//    public static printAnswer{
//
//    }
//
//    // 종료 조건 검사
//    public static checkFinish{
//
//    }
//}

    
}
