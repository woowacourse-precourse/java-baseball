package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args)  {
        System.out.println(computerNumber());
        System.out.println(userNumber());
    }


    // 컴퓨터가 3개의 랜덤 수 생성  -> computerNumber() 로 호출

    public static ArrayList<Integer> computerNumber() {
        ArrayList<Integer> computerList = new ArrayList<>();
        while (computerList.size() != 3) {
            int randomNum = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            if (!computerList.contains(randomNum)) {
                computerList.add(randomNum);
            }
        }
        return computerList;
    }

//     사용자가 3개의 수 입력

    public static int[] userNumber() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String userInputNumber = br.readLine();
        Scanner sc = new Scanner(System.in);
        String userInputNumber = sc.nextLine();
        int[] userList = new int[computerNumber().size()];

        if (userInputNumber.length() == 3) {
            String[] usersList = userInputNumber.split("");
            for (int i = 0; i < userInputNumber.length(); i++) {
                userList[i] = Integer.parseInt(usersList[i]);
            }
        } else {
            throw new IllegalArgumentException("put three numbers");
        }

        return userList;
    }
//
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
