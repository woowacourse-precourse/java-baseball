package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BaseballGame {
    Scanner sc = new Scanner(System.in);
    List<Integer> num_list = new ArrayList<>();
    List<Integer> my_list = new ArrayList<>();
    int ballCount;
    int strikeCount;
    int myNum;
    int reStart;
    int end;

    public BaseballGame() {
        makeNumList();
        initalizeBall();
    };

    // 서로 다른 3자리의 수 생성
    public void makeNumList() {
        while(num_list.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!num_list.contains(num))
                num_list.add(num);
        }
    }

    // ball과 strike count를 0으로 초기화
    public void initalizeBall() {
        int ballCount = 0;
        int strikeCount = 0;
    }

    // 3자리 수 입력
    public void writeMyNumList() {
        System.out.print("숫자를 입력해주세요 : ");
        myNum = Integer.parseInt(Console.readLine());
        if(myNum >= 1000)
            throw new IllegalArgumentException(); // 사용자가 잘못된 값을 입력할 경우
        makeMyNumList(); // 사용자로부터 입력받은 값을 리스트로 변환
    }

    // 스트라이크와 볼 판별
    public void strikeBall() {
        initalizeBall();
        for(int i = 0; i < num_list.size(); i++) {
            if(num_list.get(i) != my_list.get(i) && num_list.contains(my_list.get(i)))
                ballCount += 1;
            else if(num_list.get(i) == my_list.get(i))
                strikeCount += 1;
        }
    }

    // 판별 내용으로 메시지 출력 & 게임 재시작 유무 판별 체크
     public void message() {
        if(ballCount + strikeCount == 0)
            System.out.println("낫싱");
        else if(strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
            reStart = Integer.parseInt(Console.readLine());
            if(reStart == 1)
                this.end = 0;
            else
                this.end = 1;
        }
        else {
            if(ballCount == 0) {
                System.out.printf("%d스트라이크\n", strikeCount);
            }
            else if(strikeCount == 0) {
                System.out.printf("%d볼\n", ballCount);
            }
            else {
                System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
            }
        }

     }

    // 사용자로부터 입력받은 값을 리스트로 변환
     public void makeMyNumList() {
         if(my_list.size()>0){
             my_list.clear();
         }

         my_list.add(myNum/100);
         my_list.add((myNum%100)/10);
         my_list.add(myNum%10);
     }

}

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        loop:
        while(true) {
            BaseballGame baseballGame = new BaseballGame();
            while(true) {
                baseballGame.writeMyNumList();
                baseballGame.strikeBall();
                baseballGame.message();
                if(baseballGame.end == 0)
                    break;
                else if(baseballGame.end == 1) {
                    System.out.println("게임 종료");
                    break loop;
                }
            }
        }

    }

}
