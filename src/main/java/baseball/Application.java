package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    //잘못된 입력을 받을 경우
    public static void IllegalInput(List<Integer> input) {
        //입력이 3자리의 숫자가 아님
        if(input.size()!=3){
            throw new IllegalArgumentException("3자리의 수를 입력하세요.");
        }
        //서로 다른 3자리의 숫자가 아닌 경우
        if(Objects.equals(input.get(0), input.get(1)) || Objects.equals(input.get(0), input.get(2)) || Objects.equals(input.get(1), input.get(2))){
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }
    }

    //랜덤값을 추출
    public static List<Integer> RandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //user에게 값을 받음
    public static List<Integer> InputNum(){
        List<Integer> user = new ArrayList<>();
        String[] userInput = Console.readLine().split("");
        for(int i=0; i<userInput.length; i++){
            user.add(Integer.parseInt(userInput[i]));
        }
        IllegalInput(user);
        return user;
    }

    public static String solution(){
        String answer = "";
        int strike = 0;
        int ball = 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.print("숫자 야구 게임을 시작합니다.");
        System.out.println(InputNum());
    }
}

//잘못 입력을 받는다 -> 3자리 수가 아닌 경우, 3자리의 숫자가 모두 다르지 않은 경우, int형이 아닌 경우
