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
            int input_num = input();
            // 잘못된 값을 입력했을 때 예외 처리
            if(!(input_num > 99 && input_num < 1000)){
                throw new IllegalArgumentException();
            }
        }
        //todo: 검증 기능
            //todo: 3스트라이크 일 경우
                //todo: 3스트라이크, 게임종료 출력
            //todo: 아닐 경우
                //todo: 스트라이크, 볼 개수 출력
                //todo: 3자리 숫자를 입력받는 기능 실행
    }
    //숫자를 입력받는 기능
    public static int input(){
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        sc.close();
        return result;
    }
    //숫자가 computer 와 위치, 값이 같은지 확인하는 기능
    public static ArrayList<Integer> num_verification(int num){
        ArrayList<Integer> result = new ArrayList<>();
            //todo: 1개 이상의 숫자가 같고 자리가 같은 경우 = (맞은개수)스트라이크
            //todo: 1개 이상의 숫자가 같고 자리가 다른 경우 = (맞은개수)볼
            //todo: 입력 숫자와 위치가 모두 다른 경우 = 낫싱개수
        return result;
    }
}
