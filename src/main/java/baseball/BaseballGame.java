package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> number;
    private Boolean gameRestart = false;

    public void run(){
        // TODO 1. 랜덤 숫자 생성
        generateNumber();
//        System.out.println(number);

        // TODO 2-1. 사용자 입력 받기
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String newInput = Console.readLine();
        System.out.println(newInput);
    }

    private void generateNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.number = computer;
    }
}
