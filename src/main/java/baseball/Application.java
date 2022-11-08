package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        //랜덤숫자를 리스트에 넣기
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

//        System.out.println(computer);

        List<Integer> strike = new ArrayList<>();

        while (strike.toArray().length < 3) {
            strike = new ArrayList<>(); //스트라이크 초기화
            System.out.print("숫자를 입력해 주세요 : ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            //입력한 숫자를 리스트에 넣기
            int dv = 100;

            List<Integer> input_list = new ArrayList<>();
            for (int i=0;i<3;i++) {
                input_list.add(input/dv);
                input = input%dv;
                dv = dv/10;
            }

            for (int i = 0; i < 3; i++) {
                if (input_list.get(i) == computer.get(i)) {
                    strike.add(0);
                }
            }

            //볼 처리
            List<Integer> ball = new ArrayList<>();
            if (computer.get(0) == input_list.get(1) || computer.get(0) == input_list.get(2)) {
                ball.add(0);
            }
            if (computer.get(1) == input_list.get(0) || computer.get(1) == input_list.get(2)) {
                ball.add(0);
            }
            if (computer.get(2) == input_list.get(0) || computer.get(2) == input_list.get(1)) {
                ball.add(0);
            }

            //출력을 위한 if문
            if (ball.size()==0 && strike.size()!=0) {
                System.out.println(strike.size() + "스트라이크");
            } else if (strike.size()==0 && ball.size()!=0) {
                System.out.println(ball.size() + "볼");
            } else if (ball.size()!=0 && strike.size()!=0) {
                System.out.println(ball.size() + "볼 " + strike.size() + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
            if (strike.size()==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

    }
}
