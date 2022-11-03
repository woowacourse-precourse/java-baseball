package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //TODO: 프로그램 구현
        //todo: 랜덤으로 3자리 숫자를 정하는 기능
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // 3스트라이크가 나올때 까지 반복
        while(true){
            // 3자리 숫자 입력 기능 실행
            int input_num = int_input();
            // 잘못된 값을 입력했을 때 예외 처리
            if(!(input_num > 99 && input_num < 1000)){
                throw new IllegalArgumentException();
            }else{
                int strike = strike(input_num_list(input_num), computer);
                int ball = ball(input_num_list(input_num), computer);
                int nothing = nothing(input_num_list(input_num), computer);
                //숫자 검증 기능(출력기능)
                print_verification(strike,ball,nothing);
            }
        }
    }
    //숫자를 입력받는 기능
    public static int int_input(){
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        sc.close();
        return result;
    }
    //input_num 를 배열로 변환하는 기능
    public static List<Integer> input_num_list(int input_num){
        List<Integer> result = new ArrayList<>();
        //100의 자리수 배열에 추가
        result.add(input_num/10/10);
        //10의 자리수 배열에 추가
        result.add(input_num/10%10);
        //1의 자리수 배열에 추가
        result.add(input_num%10);

        return result;
    }
    //strike 개수 구하는 기능
    public static int strike(List<Integer> input_num_list, List<Integer> computer){
        int strike = 0;
        //1개 이상의 숫자가 같고 자리가 같은 경우 = (맞은개수)스트라이크
        for(int i=0; i<3; i++){
            if(input_num_list.get(i) == computer.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
    //ball의 개수 구하는 기능
    public static int ball(List<Integer> input_num_list, List<Integer> computer){
        //1개 이상의 숫자가 같고 자리가 다른 경우 = (맞은개수)볼
        int ball = 0;
        if(input_num_list.get(0) == computer.get(1) || input_num_list.get(0) == computer.get(2)){
            ball += 1;
        }
        if(input_num_list.get(1) == computer.get(0) || input_num_list.get(1) == computer.get(2)){
            ball += 1;
        }
        if(input_num_list.get(2) == computer.get(0) || input_num_list.get(2) == computer.get(1)){
            ball += 1;
        }
        return ball;
    }
    //nothing 구하는 기능(낫싱이 3일경우 모두 맞지 않는 수)
    public static int nothing(List<Integer> input_num_list, List<Integer> computer){
        int nothing = 0;
        //포함되지 않는 숫자의 개수
        for(int i=0; i<3; i++){
            if(!(input_num_list.contains(computer.get(i)))){
                nothing += 1;
            }
        }
        return nothing;
    }
    //숫자 검증 기능(출력기능)
    public static void print_verification(int strike, int ball, int nothing){
        //스트라이크가 1개 이상, 볼이 0개일 경우
        if(strike > 0 && ball == 0){
            //3스트라이크 일 경우
            if(strike == 3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            //아닐 경우
            else{
                System.out.println(strike + "스트라이크");
            }
        }
        //스트라이크가 1개 이상, 볼이 1개 이상일 경우
        else if(strike > 0 && ball > 0){
            System.out.println(strike + "스트라이크" + ball + "볼");
        }
        //스트라이크가 0개, 볼이 1개이상
        else if(strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }
        //낫싱인 경우
        else if(nothing == 3){
            System.out.println("낫싱");
        }
    }
}
