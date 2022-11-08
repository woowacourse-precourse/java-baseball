package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static boolean isPlaying = true;
    // 1. 랜덤 넘버 생성기.(input void, output List<Integer>)
    public static ArrayList<Integer> computerNumberMaker(){
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // 2. input들어온 수가 조건에 맞는가? (input String, output boolean)
    // 3. input들어온 수를 List로 (input int, output List<Integer>)
    // 4-1. 스트라이크의 개수 (input List<Integer> usernumber, List<Integer> computernumber, output int)
    // 4-2. 볼의 개수 (input List<Integer> usernumber, List<Integer> computernumber, output int)
    // 5. 매회 player 가 input을 넣을때마다 출력해야 할 것들 만들어줄 함수 (input int strikenum, int ballnum, output String)
    // 6. main 함수 꾸미기
    public static void main(String[] args) {
    }
}