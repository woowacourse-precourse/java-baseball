package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    // userInput의 볼, 스트라이크를 검사하는 함수
    static int CheckNumber(List<Integer> computer, String userInput){
        // 스트라이크, 볼 변수 선언
        int strike=0;
        int ball=0;

        // 숫자 3개로 분리하기
        int firstNum=userInput.indexOf(0);
        int secondNum=userInput.indexOf(1);
        int thirdNum=userInput.indexOf(2);

        if (computer.indexOf(0) == firstNum){
            strike++;
        }
        else if (computer.indexOf(0) == secondNum || computer.indexOf(0)==thirdNum){
            ball++;
        }

        if (computer.indexOf(1) == secondNum){
            strike++;
        }
        else if (computer.indexOf(1)==firstNum||computer.indexOf(1)==thirdNum){
            ball++;
        }

        if (computer.indexOf(2) == thirdNum){
            strike++;
        }
        else if (computer.indexOf(2)==firstNum || computer.indexOf(2)==secondNum){
            ball++;
        }

        if (strike==3){
            System.out.println(strike+"스트라이크");
            System.out.println(strike+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        }

        if(ball!=0 || strike!=0){
            if (ball==0) { //strike만 존재
                System.out.println(strike + "스트라이크");
            }
            else if (strike==0){ //ball만 존재
                System.out.println(ball+"볼");
            }
            else{   //strike, ball 둘 다 존재
                System.out.println(ball+"볼"+strike + "스트라이크");
            }
        }else{
            System.out.println("낫싱");
        }
        return 0;
    }
    public static void main(String[] args) {
        String userInput = null;
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
        // 4. 숫자 검사
        if (CheckNumber(computer, userInput)==1){
            return;
        }
        // 5. 새로 시작 or 종료
        Scanner sc2=new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        status = Integer.valueOf(sc2.next());
    }
}
