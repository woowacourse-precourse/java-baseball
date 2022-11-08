package baseball;

import camp.nextstep.edu.missionutils;
import java.util.*;

public class Application {

    List<Integer> computer = new ArrayList<>();
    List<Integer> userlist = new ArrayList<>();

    int user;
    int a1; // 사용자의 입력값중 첫번째 숫자
    int a2; // 사용자의 입력값중 두번째 숫자
    int a3; // 사용자의 입력값중 세번째 숫자

    static void make_computer_number(){ // 컴퓨터 숫자 생성 함수
        while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                }
            }
    }

    static void make_user_number(){ // 유저 숫자 입력 함수
        System.out.print("숫자를 입력해주세요 : ");
        user = camp.nextstep.edu.missionutils.Console.readLine();
        a1 = user / 100;
        a2 = user / 10 % 10;
        a3 = user % 10;
    }

    static int catchillegal() throws IllegalArgumentException{ // user 리스트에 유저가 입력한 숫자를 넣는 함수. 동시에 잘못된 숫자를 입력하였는지도 확인함.
        int k = 1;
        if( a1 > 10 || a1 == a2 || a2 == a3 || a3 == a1 ) {
            k = -1;
            throw new IllegalArgumentException();
        }
        userlist.add(a1);
        userlist.add(a2);
        userlist.add(a3);
        return k;
    }

    static boolean if3strike(){ // 3스트라이크 인지 (정답인지) 를 체크해주는 함수
        boolean isanswer = true;
        for(int i = 0 ; i < 3 ; i++){
            if(computer.get(i) != userlist.get(i)) {
                isanswer = false;
            }
        }

        if(isanswer) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return isanswer;
    }

    static void check_ball(){ // 볼의 개수 카운트 함수
        int count = 0;
    }
    
    static void check_strike(){ // 스트라이크 개수 카운트 함수

    }

    static void nothine(){ // 낫싱 인지를 체크해주는 함수

    }

    static void run(){ // 게임 진행 함수
        System.out.println("숫자 야구 게임을 시작합니다.");
        int continue = 1;
        while (continue = 1){
            make_computer_number();
            make_user_number();
            if( catchillegal() == -1 ) return;
            if(!if3strike()){
                check_ball();
                check_strike();
                check_nothing();
                make_user_number();
            }
            computer.clear();
            user.clear();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continue = camp.nextstep.edu.missionutils.Console.readLine();
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }
}
