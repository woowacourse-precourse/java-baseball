package baseball;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {


    }


    // 컴퓨터가 3개의 랜덤 수 생성
    public static ArrayList<Integer> computerRandomNum(int min, int max, int count){
        ArrayList <Integer> comNum = new ArrayList<>();
        pickUniqueNumbersInRange(1, 9, 3);
        return comNum;
    }

    // 사용자가 3개의 수 입력
    public static userInputNum(){

    }

    // 사용자 입력 정답 검사
    public static checkAnswer{

    }

    // 정답 검사 결과 출력
    public static printAnswer{

    }

    // 종료 조건 검사
    public static checkFinish{

    }
}
