package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.*;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class Application {
    public static List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static String numberInput(){
        System.out.println("숫자를 입력해주세요 : ");
        String num = readLine();
        return num;
    }
    public static int duplicateCheck1(String num, int comparison1, int comparison2){
        int duplicateCount=0;
        if (num.charAt(comparison1)==num.charAt(comparison2)){
            duplicateCount+=1;
        }
        return  duplicateCount;
    }
    public static void duplicateCheck2(String num){
        int duplicateCount=0;
        for(int comparison1=0;comparison1<num.length();comparison1++){
            for(int comparison2=comparison1+1;comparison2<num.length();comparison2++){
                duplicateCount+=duplicateCheck1(num,comparison1,comparison2);
            }
        }
        if (duplicateCount != 0){
            throw new IllegalArgumentException("입력숫자의 중복을 확인하세요");
        }
    }
    public static int Check(String num, List<Integer> answer){
        int strike=0;
        int ball=0;
        for (int i=0;i<answer.size();i++) {
            if (answer.get(i) == (int)num.charAt(i)-48){
                strike += 1;
            } else if (answer.contains((int)num.charAt(i)-48)){
                ball += 1;
            }
        }
        if (strike==0 && ball==0){
            System.out.println("낫싱");
        } else if (strike==0){
            System.out.println(ball+"볼");
        } else if (ball==0) {
            System.out.println(strike+"스트라이크");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        if (strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return strike;
    }
    public static String gamePlay() {
        int checkstrike;
        String gostop;
        List<Integer> answer = getRandomNum();
        while (true) {
            String number = numberInput();
            if (number.length() !=3) {
                throw new IllegalArgumentException("입력숫자 길이를 확인하세요");
            }
            duplicateCheck2(number);
            checkstrike = Check(number, answer);
            if (checkstrike == 3) {
                gostop = readLine();
                break;
            }
        }
        return gostop;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            if (gamePlay().equals(String.valueOf('2'))) {
                break;
            }
        }
    }
}
