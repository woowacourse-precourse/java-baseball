package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseball {
    private List<Integer> CorrectAnswer;

    public List<Integer> getAnswer(){
        return CorrectAnswer;
    }

    public void setAnswer(int first, int second, int third){
        CorrectAnswer.set(0, first);
        CorrectAnswer.set(1, second);
        CorrectAnswer.set(2, third);
    }

    public NumberBaseball(){ // generate answer by Randoms library
        CorrectAnswer = new ArrayList<Integer>();
        CorrectAnswer.add(Randoms.pickNumberInRange(0, 9));
        for(int i = 0; i < 2; i++){
            int temp;
            do{
                temp = Randoms.pickNumberInRange(0, 9);
            }
            while(CorrectAnswer.contains(temp));
            CorrectAnswer.add(temp);
        }
        //CorrectAnswer = Randoms.pickUniqueNumbersInRange(0,9,3);
    }

    public void playBall(){
        int[] MyAnswer = new int[3];

        do{ // repeat until victory
            System.out.print("숫자를 입력해주세요 : ");
            // convert numbers from Ascii to integer value
            String input = Console.readLine();
            // check the input value
            if(!checkInput(input)){
                throw new IllegalArgumentException();
            }
        }
        while ();

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean checkInput(String input){
        // get String as an input
        // length check
        if(input.length() >= 4){
            return false;
        }
        // ascii value check
        for(int i = 0; i < 3; i++){
            if((input.charAt(i) < 48)
                    || (input.charAt(i) > 57)){
                return false;
            }
        }
        return true;
    }

    private int countStrike(int[] MyAnswer){
        int result = 0;
        for(int i = 0; i < 3; i++){
            if(MyAnswer[i] == CorrectAnswer.get(i)){
                result++;
            }
        }
        return result;
    }

}
