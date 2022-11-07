package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer;
    List<Integer> inputNum;

    public void makeRandomNum() {
        List<Integer> number = new ArrayList<>();
        while (number.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!number.contains(randomNumber)){
                number.add(randomNumber);
            }
        }
        answer = number;
    }

    public void checkIllegal(String num) { //inputNum이 제약사항을 만족하는지 확인
        inputNum = new ArrayList<>();
        if(num.length()!=3){
            throw new IllegalArgumentException(); //3자리인가?
        }
        
        for (int i = 0; i < 3; i++) {//중복인가?
            int addNum = num.charAt(i)-'0';
            if(inputNum.contains(addNum)){
                throw new IllegalArgumentException();
            }
            inputNum.add(addNum);
        }

        for (int i = 0; i < 3; i++) { //각 자리가 1~9사이의 숫자인가?
            if(1<=inputNum.get(i)&&inputNum.get(i)<=9){
                continue;
            } else{
                throw new IllegalArgumentException();
            }
        }
        //제약 사항을 모두 통과했다.
    }

    public String getResult() { //스트라이크 낫싱 볼
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) { //스트라이크와 볼의 개수 카운트
            if(inputNum.get(i)==answer.get(i)){
                strike++;
            } else if(answer.contains(inputNum.get(i))){
                ball++;
            }
        }

        if(strike==0&&ball==0){
            return "낫싱";
        } else{
            if(strike==0) return ball+"볼";
            else if(ball==0) return strike+"스트라이크";
            else{
                return ball+"볼 "+strike+"스트라이크";
            }
        }
    }
}
