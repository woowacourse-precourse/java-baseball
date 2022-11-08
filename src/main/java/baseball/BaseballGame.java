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
        // TODO 2-2. 예외 처리하기
        checkInputFormat(newInput);
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

    private void checkInputFormat(String newInput){
        if(newInput.length() != 3){
            throw new IllegalArgumentException("userInput is index out of range: 3");
        }
        for (int i = 0; i < 3; i++){
            if( newInput.charAt(i) < '1' || newInput.charAt(i) > '9') {
                throw new IllegalArgumentException("userInput is not configured from number : 1 o 9");
            }else if(newInput.charAt(i) == newInput.charAt((i+1)%3)) {
                throw new IllegalArgumentException("duplicate number found in use Input");
            }
       }
    }
}
