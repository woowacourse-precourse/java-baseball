package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*
2. 컴퓨터(상대방)의 숫자를 설정하는 함수
3. 입력 받은 숫자를 규칙에 따라 결과를 리턴해주는 함수. 리턴값이 -1이면 맞춘것으로 하여 재시작 여부 질문
4. 재시작or종료 함수. 재시작이면 continue, 아니면 break!!
* */
class game{
    List<Integer> computer;
    List<Integer> mynum;
    public game(){
    };
    public void setComputerNum(){
        this.computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public void get_Mynum(){

    }
    public void checker(){

    }
    public void reStarter(){

    }

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

    }
}
