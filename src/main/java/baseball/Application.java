package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static Integer restartCounter;
    public static void main(String[] args) {
        do{
            List<Integer> computer = randomNumberGenerator();






            restartCounter  = sc.nextInt();
        }while(restartCounter==2);
    }

    public static List<Integer> randomNumberGenerator(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        System.out.println("숫자를 입력해주세요 : ");
        String input = sc.nextLine();
        String[] sc =

        return temp;
    }
}
