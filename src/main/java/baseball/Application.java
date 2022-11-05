package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현

        // Computer creates random number
        List computerNum = Computer.getComputerNum();
        System.out.println(computerNum);

        // Starting game
        System.out.print("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : ");

        // Get and validate user input
        List userNum = User.getUserNum();
        System.out.println(userNum);

    }








}
