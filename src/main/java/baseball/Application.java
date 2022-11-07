package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

/* 기능 목록
Problem1 : 컴퓨터의 수 만들기
            (1) 1-9 중 컴퓨터의 수 하나 고르기
            (2) 3자리 수의 컴퓨터의 수 만들기
Problem2 : 게임 시도(게임 재실행 여부 1로 두고 시도),스트라이크 값 비교할 함수 호출
Problem3 : 게임 시작
            (1) 사용자의 입력값을 List에 저장
Problem3.1: 예외사항 체크
            (1) 사용자의 입력값이 길이 예외사항인지 확인
            (2) 사용자의 입력값에 0이 존재하는지 확인
            (3) 사용자의 입력값이 서로 다른 숫자로 구성되어있는지 확인
Problem4 : 스트라이크 , 볼 계산, 결과 출력
           (1) 스트라이크 계산
           (2) 볼 계산
           (3) 결과 출력
Problem5 : 스트라이크 값 확인, 3이면 게임 종료
Problem6 : 게임이 끝난 후 게임 재실행 여부 받고 재실행 or Not
Problem6.1: 재실행 여부가 잘못된 값이면 예외
 */
public class Application {
    static int strike = 0;
    static int ball = 0;
    public static List<Integer> makeComputerNum(){
        int i;
        List<Integer> ComputerNum = new ArrayList<>();
        for(i = 0;i<3;i++){
            ComputerNum.add(makeRandomNum(ComputerNum));
        }
        return ComputerNum;
    }
    public static int makeRandomNum(List<Integer> ComputerNum){
        int random = Randoms.pickNumberInRange(1,9);
        while(ComputerNum.contains(random)){
            random = Randoms.pickNumberInRange(1,9);
        }
        return random;
    };
    public static String tryGame(){
        String trynum = "1";
        while(!trynum.equals("2")){
            strike = 0;
            ball = 0;
            getStrike();
        }
        return trynum;
    }

    public static int getStrike(){
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}