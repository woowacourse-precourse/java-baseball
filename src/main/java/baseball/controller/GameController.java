package baseball.controller;

import baseball.model.CounterpartModel;
import baseball.model.ResultModel;
import baseball.view.AppView;

public class GameController {
    private CounterpartModel counterpart;
    private boolean isAnswerAndTerminate = false;

    public GameController() {
        this.counterpart = new CounterpartModel();
    }

    public int inputNumber() {
        AppView.output("숫자를 입력해주세요 : ");
        int myAnswer = 0;
        try {
            myAnswer = Integer.parseInt(AppView.inputLine());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(!checkRangeNum(myAnswer)) {
            throw new IllegalArgumentException();
        }

        return myAnswer;
    }

    public boolean checkRangeNum(int num) {
        // 3자리인지 체크
        if(num / 100 >= 10) return false;
        if(num / 100 == 0) return false;
        // 1자리
        if((num % 10) == 0) return false;
        // 10자리
        if(((num % 100) / 10) == 0) return false;
        // 100자리
        if((num / 100) == 0) return false;

        return true;
    }

    public void correctResult() {
        AppView.outputLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        inquiryStartOrTerminate();
    }

    public void inquiryStartOrTerminate() {
        AppView.outputLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int myResponse = 0;
        try {
            myResponse = Integer.parseInt(AppView.inputLine());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(myResponse != 1 && myResponse != 2) {
            throw new IllegalArgumentException();
        }

        if(myResponse == 1) {
            counterpart = new CounterpartModel();
        }

        if(myResponse == 2) {
            isAnswerAndTerminate = true;
        }
    }

    public void run() {
        AppView.outputLine("숫자 야구 게임을 시작합니다.");
        do {
            ResultModel aSetOfGame = new ResultModel();
            aSetOfGame.calResult(inputNumber(), counterpart.getResultNumList());
            aSetOfGame.printResult();
            if(aSetOfGame.distinguishResult()) {
                // 정답이라면
                correctResult();
            }
        } while(!isAnswerAndTerminate);
    }
}
