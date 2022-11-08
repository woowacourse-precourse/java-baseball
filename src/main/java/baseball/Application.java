package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.nio.sctp.IllegalReceiveException;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        playBaseball();
    }

    public static void playBaseball() {
        List<Integer> result = new ArrayList<>();
        result.add(0); // strike 수
        result.add(0); // ball 수

        System.out.println("숫자 야구 게임을 시작합니다.");

        String randomNum = makeRandomNum();
        System.out.println("randomNum :" +randomNum);

        while(result.get(0)!=3) {
            System.out.println("숫자를 입력해 주세요. :");
            String userNum =isRightUserNum(Console.readLine());
            result = analyseNumber(randomNum, userNum);

            printResult(result);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String choice = isRightChoice(Console.readLine());
        if(choice.equals("1")) {
            playBaseball();
        } else {
            System.out.println("게임을 종료합니다.");
        }


    }

    public static String isRightChoice(String readLine) {
        if(!readLine.equals("1") && !readLine.equals("2")) {
            throw new IllegalArgumentException("올바른 값을 입력하세요. 게임을 종료합니다.");
        }
        return readLine;
    }

    public static String isRightUserNum(String readLine) throws IllegalArgumentException {
        char[] split = readLine.toCharArray();
        for(int i=0; i<readLine.length(); i++) {
            if(!Character.isDigit(split[i])) {
                throw new IllegalArgumentException("올바른 값을 입력하세요. 게임을 종료합니다.");
            }
        }

        for(int i =0; i<readLine.length()-1; i++) {
            if(split[i]==split[i+1]) {
                throw new IllegalArgumentException("올바른 값을 입력하세요. 게임을 종료합니다.");
            }
        }

        if(!(readLine.length()==3)) {
            throw new IllegalArgumentException("올바른 값을 입력하세요. 게임을 종료합니다.");
        }

        return readLine;
    }

    public static void printResult(List<Integer> result) {
        int strike = result.get(0);
        int ball = result.get(1);
        if(strike==0 && ball ==0){
            System.out.println("낫싱");
        } else if(ball==0) {
            System.out.println(result.get(0)+"스트라이크");
        } else if(strike==0) {
            System.out.println(result.get(1)+"볼");
        } else {
            System.out.println(result.get(1)+"볼 "+result.get(0)+"스트라이크");
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
