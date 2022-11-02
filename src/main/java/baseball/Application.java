package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
        //todo: 3자리 숫자를 입력받는 기능
            //todo: 3자리 숫자가 입력되었을때 기능 실행
                //todo: num_verification 기능 실행
            //todo: 잘못된 값을 입력했을때 기능
                //todo: 애플리케이션 종료(IllegalArgumentException)

        //todo: 검증 기능
            //todo: 3스트라이크 일 경우
                //todo: 3스트라이크, 게임종료 출력
            //todo: 아닐 경우
                //todo: 스트라이크, 볼 개수 출력
                //todo: 3자리 숫자를 입력받는 기능 실행
    }
    public static ArrayList<Integer> num_verification(int num){
        ArrayList<Integer> result = new ArrayList<>();
        //todo: 입력한 숫자가 랜덤한 숫자와 같은지 확인하는 기능
            //todo: 1개 이상의 숫자가 같고 자리가 같은 경우 = (맞은개수)스트라이크
            //todo: 1개 이상의 숫자가 같고 자리가 다른 경우 = (맞은개수)볼
            //todo: 입력 숫자와 위치가 모두 다른 경우 = 낫싱개수
        return result;
    }
}
