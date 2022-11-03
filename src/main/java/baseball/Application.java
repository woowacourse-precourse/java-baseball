package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.*;

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
    public static int Check(String num, List<Integer> answer){
        int strike=0;
        int ball=0;
        for (int i=0;i<answer.size();i++) {
            if (answer.get(i) == (int)num.charAt(i)){
                strike += 1;
            } else if (answer.contains((int)num.charAt(i))){
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

        return strike;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
