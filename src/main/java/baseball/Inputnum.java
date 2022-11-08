package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inputnum {
    //사용자가 입력한 수를 String형태로 반환
    public static String InsertNum(Scanner scan){
        String num;

        System.out.print("숫자를 입력해 주세요 : ");
        num = scan.nextLine();

        return num;
    }
    //랜덤한 3개의 수를 List에 담기
    public static List<Integer> Randomnum(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    //List에 있는 수를 String으로 변환
    public static String changeString(List<Integer> computer){
        String computerNum = "";

        for (int item : computer){
            computerNum += item; //Integer 자료형이더라도 +는 int -> String으로 자동으로 바꿔준다!
        }

        return computerNum;
    }
}
