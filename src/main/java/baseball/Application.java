package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    static List<Integer> randomize() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static List<Integer> splitInt(int a) {
        List<Integer> result = new ArrayList<>();
        while (a>0) {
            result.add(a%10);
            a/=10;
        }
        return result;
    }
    static void printResult(int strike, int ball, int nothing) {
        if(nothing == 3) {
            System.out.println("낫싱");
        } else if(ball != 0 && strike != 0) {
            System.out.println(ball+"볼"+" "+strike+"스트라이크");
        } else if(ball == 0) {
            System.out.println(strike+"스트라이크");
        } else {
            System.out.println(ball+ "볼");
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = randomize();
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        // 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        // 게임 무한루프
        int flag = 0;
        while(flag == 0) {
1
        }
        int inputInit;
        List<Integer> inputNum;
        Scanner scanner = new Scanner(System.in);
        inputInit = scanner.nextInt();
//        입력받은 번호 세개로 쪼개기
        inputNum = splitInt(inputInit);
//        자리비교
        for(int i=0; i<3; i++) {
            if(Objects.equals(computer.get(i), inputNum.get(i))) {
                strike++;
            }else if(!Objects.equals(computer.get(i), inputNum.get(i)) && computer.contains(inputNum.get(i))){
                ball++;
            } else{
                nothing++;
            }
        }
//        결과 출력
        printResult(strike, ball, nothing);
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
