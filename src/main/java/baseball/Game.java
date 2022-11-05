package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer strike;
    private Integer ball;
    private List<Integer> comNum;
    private List<Integer> userNum;

    public Game(){
        init();
    }

    //함수 호출하자마자 랜덤값 세자리 생성
    public void init(){
        comNum = new ArrayList<>();
        for(int i =0; i<3;){
            int num = Randoms.pickNumberInRange(1,9);
            if(!comNum.contains(num)){
                comNum.add(num);
                i++;
            }
        }
    }

    //사용자 세자리 입력받기
    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요");
        String userInput = Console.readLine();
        this.userNum = makeList(userInput);
    }

    
}
