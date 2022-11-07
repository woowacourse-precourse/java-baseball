package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int answer = answerNum();
        int input = inputNumber();

    }
    // 서로 다른 임의의 수 3개 선택
    public static int answerNum(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> ansL = new ArrayList<>();

        int count=0;
        while(count!=3){
            int randpick = Randoms.pickNumberInRange(1,9);
            if(!ansL.contains(String.valueOf(randpick))) {
                ansL.add(String.valueOf(randpick));
                count++;
            }
        }
        String str = "";
        for(int i=0;i<ansL.size();i++){
            str += ansL.get(i);
        }
        int answer = Integer.parseInt(str);
        return answer;
    }
    public static int inputNumber() throws NullPointerException {
        System.out.print("숫자를 입력해주세요 : ");
        int input = 0;

        try{
            input = Integer.parseInt(Console.readLine());
            String str = String.valueOf(input);
            if(input<100 || input>999){
                throw new IllegalArgumentException();
            }
        }
        catch (NullPointerException e){

        }
        return input;

    }
}
