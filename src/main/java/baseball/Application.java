package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//1.랜덤한 3자리수를 생성한다.
//2.플레이어에게 세자리 수를 입력받는다.
//3.입력받은 세 자리 수 중 컴퓨터가 생성한 랜덤한 수와 같은 숫자가 있으면 1볼
//4.그 중에 자리까지 같으면 1스트라이크가 된다.
//5.최종 결과를 보고 다 맞추면 3스트라이크
//6.아니라면 힌트를 반환
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public static List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
