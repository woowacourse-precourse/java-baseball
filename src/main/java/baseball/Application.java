package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    // 스트라이크의 개수를 return
    public static int countStrike(List<Integer> computer, List<Integer> user){
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            if(computer.get(i) == user.get(i)) cnt++;
        }
        return cnt;
    }

    // 볼의 개수를 return;
    public static int countBall(List<Integer> computer, List<Integer> user){
        int cnt = 0;
        for(int i= 0; i < 3; i++){
            int val = computer.get(i);
            int index = user.indexOf(val);
            if(i == index) continue;    // 스트라이크일 경우
            else if(index != -1) cnt++; // 볼일 경우
        }
        return cnt;
    }

    public static void playGame(){
        // 컴퓨터가 정한 답
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String ans = Console.readLine();

            checkInput(ans);

            List<Integer> user = new ArrayList<>(); // 서로 다른 3개의 숫자
            for(int i = 0; i < 3; i++){
                user.add(Character.getNumericValue(ans.charAt(i)));
            }

            // 스트라이크 및 볼 결과 출력
            int strike = countStrike(computer, user);
            int ball = countBall(computer, user);
            print(strike, ball);

            // 답을 맞춘 경우 게임 종료
            if(compare(computer, user)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    // user의 입력이 잘 됬는지 체크. 아니면 exceptino
    public static void checkInput(String user){
        if(user.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    // 스트라이크 및 볼 결과 출력
    public static void print(int strike, int ball){
        if(ball == 0 && strike != 0){
            System.out.println(strike + "스트라이크");
        }else if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }else if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    // 사용자가 정답을 맞추면 true return
    public static boolean compare(List<Integer> computer, List<Integer> user){
        boolean correctFlag = true; // 답이 맞으면 true
        for(int i= 0; i < 3; i++){
            if(computer.get(i) != user.get(i)){
                correctFlag = false;
                break;
            }
        }
        return correctFlag;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String select = Console.readLine();

            if(select.equals("2")) break;
        }

    }
}
