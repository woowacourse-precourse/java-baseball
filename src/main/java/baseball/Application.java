package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console;


public class Application {

    public static ArrayList<Integer> randomNum() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static ArrayList<Integer> userInput(){
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> already = new ArrayList<>();
        for(int i=0; i<3; i++){
            int number = Integer.valueOf(Console.readLine());
            already.add(number);
            if(!input.contains(number)){
                input.add(number);
            }
            if(input.get(i)==0){
                throw new IllegalArgumentException();
            }
        }
        return input;
    }

    public static void game(ArrayList<Integer> a, ArrayList<Integer> b){
        int strike=0, ball = 0;
        for(int i=0; i<3; i++){
            if (a.get(i) == b.get(i)) {
                strike++;
            }
            else if (a.contains(b.get(i)) && a.get(i)!=b.get(i)){
                ball++;
            }
        }
        if(strike==3){
            System.out.println(strike+"스트라이크.\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return;
        }
        else if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList A = randomNum();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 :");
        Scanner scanner = new Scanner(System.in);
        ArrayList B = userInput();

        game(A,B);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = scanner.nextInt();
        if(num==1){
            game(A,B);
        }
        else if(num==2){
            return;
        }
    }
}
