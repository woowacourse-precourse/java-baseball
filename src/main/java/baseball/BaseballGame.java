package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer;
    List<Integer> inputNum;

    public void setInputNum(String num) {
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int addNum = num.charAt(i)-'0';
            number.add(addNum);
        }
        inputNum = number;
    }

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

    public boolean checkIillgal() { //제약사항 만족 못할시 true 반환
        if(inputNum.size()!=3) return true; //3자리인가?

        List<Integer> number = new ArrayList<>(); //중복인가?
        for (int i = 0; i < 3; i++) {
            if(number.contains(inputNum.get(i))){
                return true;
            }
            number.add(inputNum.get(i));
        }

        for (int i = 0; i < 3; i++) { //각 자리가 1~9사이의 숫자인가?
            if(1<=number.get(i)&&number.get(i)<=9){
                continue;
            } else{
                return true;
            }
        }
        return false; //제약 사항을 모두 통과했다.
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
