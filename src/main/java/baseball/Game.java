package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private String answerNumber="";
    public void startGame(){
        for(int i=0;i<3;i++){
            answerNumber+=Integer.toString(pickNumberInRange(1,9));
        }
        do{
            System.out.println("숫자를 입력해주세요: ");
            String getNumber=readLine();
            rightNumber();
        }while(true);
    }
    public void rightNumber(){
        if(answerNumber.length()!=3) throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        for(int i=0;i<3;i++){
            if(answerNumber.charAt(i)<1||answerNumber.charAt(i)>9) throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
