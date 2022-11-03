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
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String num = numberInput();
            checkstrike = Check(num, answer);
            if (checkstrike == 3) {
                gostop = readLine();
                break;
            }
        }
        return gostop;
    }
    public static void main(String[] args) {
        while(true) {
            if (gamePlay().equals(String.valueOf('2'))) {
                break;
            }
        }
    }
}
