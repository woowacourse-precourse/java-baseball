package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        String userInput;
        int status=1;

        // 1. 시작 멘트
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 2. 숫자 3개 랜덤 추출
        List<Integer> computer = new ArrayList<>();
        while (computer.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        while (status==1) {
            // 3. 사용자 입력 받기
            Scanner sc1 = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요 : ");
            userInput = sc1.next();
        }
    }
}
