package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String randomNum = makeRandomNum();
        System.out.println("randomNum: "+randomNum);
        System.out.println("숫자를 입력해 주세요. :");
        String userNum = Console.readLine();

        List<Integer> result = analyseNumber(randomNum, userNum);

        if(result.get(0)!=3) {
            if(result.get(0)==0) {
                System.out.println(result.get(1)+"볼");
            } else if(result.get(1)==0) {
                System.out.println(result.get(0)+"스트라이크");
            } else {
                System.out.println(result.get(1)+"볼 "+result.get(0)+"스트라이크");
            }
        }
    }

    public static List<Integer> analyseNumber(String randomNum, String userNum) {
        List<Integer> result = new ArrayList<>();

        int strike = 0;
        String[] splitRandomNum = randomNum.split("");
        String[] splitUserNum = userNum.split("");

        for(int i=0; i<splitRandomNum.length; i++) {
            if(splitRandomNum[i].equals(splitUserNum[i])) {
                strike ++;
                splitUserNum[i]="!";
            }
        }

        result.add(strike);


        int ball = 0;

        for(int i=0; i<splitUserNum.length; i++) {
            if(randomNum.contains(splitUserNum[i])) {
                System.out.println("i:"+splitUserNum[i]);
                ball++;
            }
        }

        result.add(ball);

        return result;
    }

    public static String makeRandomNum() {
        String randomNum = "";
        while(randomNum.length()<3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNum.contains(ranNum+"")) {
                randomNum = randomNum + ranNum;
            }
        }
        return randomNum;
    }
}
