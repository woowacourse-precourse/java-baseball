package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LetsPlayBall {

    public static List<Integer> getSetGo() {
        System.out.println("숫자를 입력해주세요. : ");
        Scanner sc = new Scanner(System.in);
        List<Integer> userNum = new ArrayList<>();
        String input = sc.next();

        for (String number : input.split(""))
            userNum.add(Integer.parseInt(number));
        if(input.length() != 3) throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        return userNum;
    }
    public static boolean restart(){
        System.out.println("축하합니다! 경기를 다시 시작하겠습니까? 다시 시작 : 1, 종료 : 2");
        Scanner sc = new Scanner(System.in);
        char answer = sc.next().charAt(0);
        return answer == '1';
    }


    static List<Integer> createRandomNumber(){
        List<Integer> comNum = new ArrayList<>();
        while (comNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }
        }
        return comNum;
    }

    public static int strikeCount(List<Integer> userNum, List<Integer> comNum){
        int strike = 0;
        for(int i=0; i<userNum.size(); i++){
            if(userNum.get(i).equals(comNum.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int ballCount(List<Integer> userNum, List<Integer> comNum){
        int ball = 0;
        for(int i=0; i<userNum.size(); i++){
            if(!userNum.get(i).equals(comNum.get(i)) && comNum.contains(userNum.get(i)))   {
                ball++;
            }
        }
        return ball;
    }

    public static Boolean nothingCount(List<Integer> userNum, List<Integer> comNum){
        boolean Nothing = true;
        for (Integer integer : userNum)
            if (comNum.contains(integer)) {
                Nothing = false;
                break;
            }
        return Nothing;
    }

    public static int compare(List<Integer> userNum, List<Integer> comNum){
        int result = 0;
        for (Integer integer : userNum) {
            if (comNum.contains(integer)) {
                result += 1;
            }
        }
        return result;
    }

    public static String gameResult(List<Integer> userNum, List<Integer> comNum) {
        int total = compare(comNum, userNum);
        int strike = strikeCount(comNum, userNum);
        int ball = ballCount(comNum, userNum);

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
