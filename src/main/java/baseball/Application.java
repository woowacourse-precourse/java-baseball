package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {

    static final int MINIMUM_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static int comNumber1, comNumber2, comNumber3;
    static int userNumber1, userNumber2, userNumber3;
    static String userThreeNumber;
    static int strikeCount = 0;
    static int ballCount = 0;
    static int gameButton = 0;


    public static void main(String[] args) {
    }

    public static ArrayList<Integer> computerThreeRandomNumber(){
        ArrayList<Integer> comList = new ArrayList<>();
        while(true) {
            comNumber1 = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            comNumber2 = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            comNumber3 = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
            if((comNumber1 != comNumber2) && (comNumber1 != comNumber3) && (comNumber2 != comNumber3)){
                comList.add(comNumber1);
                comList.add(comNumber2);
                comList.add(comNumber3);
                break;
            }
        }
        return comList;
    }

}

//  인덴트 문제 존재