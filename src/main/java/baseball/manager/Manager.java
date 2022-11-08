package baseball.manager;

import static baseball.checker.Checker.*;
import static baseball.utility.Utility.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class Manager {
    private String userInput;
    private String answer;
    private String choice;
    public Manager(){
        System.out.println(OPENING);
    }

    public void printResult(List<Integer> list){
        int Strike = list.get(0);
        int ball = list.get(1);

        StringBuilder sb = new StringBuilder("");
        if(ball != 0) {
            sb.append(Integer.toString(ball));
            sb.append(BALL);
        }
        if(Strike != 0){
            if(sb.length() > 0) sb.append(" ");
            sb.append(Integer.toString(Strike));
            sb.append(STRIKE);
        }

        if(sb.length() == 0) {
            System.out.println(NOTHING);
        }
        if(sb.length() > 0){
            System.out.println(sb.toString());
        }
    }

    public boolean play(){
        answer = makeThreeRandomNumber();
        try{
            do{
                System.out.print(INPUT_MENT);
                userInput = readLine();
                if(IsInvalidInput(userInput))
                    throw new IllegalArgumentException("입력 규칙 위반");

                List<Integer> list = CalculateBallAndStrike(userInput, answer);
                printResult(list);
            }while(CompareUserInputWithAnswer(userInput, answer) != 1);

            System.out.println(ENDING);
            System.out.println(CONTINUE_MENT);

            choice = readLine();
            if(IsInvalidChoice(choice))
                throw new IllegalArgumentException("선택 규칙 위반");

        }catch(IllegalArgumentException e){
            System.out.println("사용자 입력이 잘못되어 프로그램이 종료됩니다.");
            return false;
        }
        return true;
    }
}
