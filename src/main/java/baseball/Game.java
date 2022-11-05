package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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
        validateUserNum();
        gameStart();
    }

    //사용자 입력받은거 리스트로 바꾸기
    public List<Integer> makeList(String userInput){
        String[] arrayInput = userInput.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for(int i=0; i<userInput.length();i++){
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }

    public void validateUserNum(){
        if(userNum.size() != 3){
            throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
        }
        if(userNum.contains(0)){
            throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
        }
        for(int i =0; i< userNum.size(); i++){
            if(Collections.frequency(userNum, userNum.get(i)) != 1){
                throw  new IllegalArgumentException("올바른 숫자가 아닙니다. 같은 숫자가 존재합니다.");
            }
        }
    }

    //컴퓨터 숫자와 사용자 숫자 비교
    public void gameStart(){
        this.strike = 0;
        this.ball = 0;
        for(int i = 0; i < userNum.size(); i++){
            //스트라이크 카운트
            if(comNum.indexOf(userNum.get(i))==i){
                strike++;
                continue;
            }
            //볼 카운트
            if(comNum.contains(userNum.get(i))){
                ball++;
            }
        }
    }

    


}
