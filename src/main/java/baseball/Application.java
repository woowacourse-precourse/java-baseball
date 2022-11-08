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
        int myNum = Integer.parseInt(Console.readLine());
        if(myNum >= 1000)
            throw new IllegalArgumentException(); // 사용자가 잘못된 값을 입력할 경우
        makeMyNumList(); // 사용자로부터 입력받은 값을 리스트로 변환
    }

    public void strikeBall() {

    }

     public void message() {

     }

    // 사용자로부터 입력받은 값을 리스트로 변환
     public void makeMyNumList() {

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
            }
        }

    }

}
