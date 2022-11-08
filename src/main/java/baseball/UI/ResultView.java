package baseball.UI;

import baseball.model.Result;
import baseball.model.State;
import camp.nextstep.edu.missionutils.Console;

public class ResultView {
    private Result result = Result.RESTART;

    public void printResult(State state){
        switch (state){
            case FINISH:
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                getResultNumber();
                break;
            case PROCEEDING:
                System.out.println("게임이 아직 종료되지 않았습니다.");
        }
    }

    private void getResultNumber(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int intResult;
        try{
            intResult = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요");
        }
        setResult(intResult);
    }

    private void setResult(int resultNum){
        if(resultNum == 1){
            result = Result.RESTART;
        }else if(resultNum == 2){
            result = Result.FINISH;
        }
    }

    public Result getResult() {
        return result;
    }
}
