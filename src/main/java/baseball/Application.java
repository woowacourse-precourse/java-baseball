package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void playBaseball(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computerNumber = new Computer();
        computerNumber.setComputerNumbers();

        User userNumber = new User();
        userNumber.setUserNumbers();

//        for(int a : computerNumber.computerNumbers) System.out.print(a+" ");
//        for(int a : userNumber.userNumbers) System.out.print(a+" ");
    }

    public static void main(String[] args) {
        playBaseball();
    }
}

