package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static String NewGameNumber(){
        String targetNumber = "";
        while(targetNumber.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!targetNumber.contains(Integer.toString(randomNumber))){
                targetNumber += Integer.toString(randomNumber);
            }
        }

        return targetNumber;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean newNumberFlag = true;
        String gameNumber = null;

        System.out.println("숫자 야구 게임을 시작합니다.\n");

        while(true){
            if (newNumberFlag == true) {
                gameNumber = NewGameNumber();
            }

            newNumberFlag = false;
        }
    }
}
