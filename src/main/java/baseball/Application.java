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
        System.out.println(userThreeInputNumber());
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

    public static ArrayList<Integer> userThreeInputNumber(){
        ArrayList<Integer> userList = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        userThreeNumber = Console.readLine();
        if(userThreeNumber.length() != 3){
            throw new IllegalArgumentException("게임 종료");
        }
        String [] userThreeNum = userThreeNumber.split("");
        for(int i = 0; i < computerThreeRandomNumber().size(); i++){
            userList.add(Integer.parseInt(userThreeNum[i]));
        }
        userNumber1 = userList.get(0);
        userNumber2 = userList.get(1);
        userNumber3 = userList.get(2);

        if ((userNumber1 == userNumber2) || (userNumber1 == userNumber3) || (userNumber2 == userNumber3)){
            throw new IllegalArgumentException("게임 종료");
        }

        return userList;
    }

}

