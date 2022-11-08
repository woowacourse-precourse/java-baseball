package baseball;

import java.util.List;

public class BaseBallGame {

    public static void baseBallGame(){
        List<Integer> computer = ComputerNumber.randomNumber();
        List<Integer> user;
        List<Integer> result;
        String resultOutput;

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            user = UserInput.userInput();
            result = CollectResult.compareUserComputer(user,computer);
            resultOutput = ResultOutput.resultString(result);

            if(resultOutput.equals("3스트라이크")){
                System.out.println(resultOutput);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            System.out.println(resultOutput);
        }
    }
}
