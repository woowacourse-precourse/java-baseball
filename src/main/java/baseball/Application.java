package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/*
*
2. 컴퓨터(상대방)의 숫자를 설정하는 함수
3. 입력 받은 숫자를 규칙에 따라 결과를 리턴해주는 함수. 리턴값이 -1이면 맞춘것으로 하여 재시작 여부 질문
4. 재시작or종료 함수. 재시작이면 continue, 아니면 break!!
* */
public class Application {
    static List<Integer> set_Cpnum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        // DO_LIST2: 숫자 설정
        List<Integer> computer = set_Cpnum();
        while(true){

        }


    }
}
