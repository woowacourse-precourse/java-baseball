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
        String myAnswer = AppView.inputLine();
        return Integer.parseInt(myAnswer);
    }

    public void correctResult() {
        AppView.outputLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        inquiryStartOrTerminate();
    }

    public void inquiryStartOrTerminate() {
        int myResponse = 0;

        while(myResponse != 1 || myResponse != 2) {
            AppView.outputLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            myResponse = Integer.parseInt(AppView.inputLine());
            if(myResponse == 1) {
                counterpart = new CounterpartModel();
            }

            if(myResponse == 2) {
                isAnswerAndTerminate = true;
            }
        }
    }

    public void run() {
        AppView.outputLine("숫자 야구 게임을 시작합니다.");
        do {
            ResultModel aSetOfGame = new ResultModel();
            aSetOfGame.calResult(inputNumber(), counterpart.getResultNum());
            aSetOfGame.printResult();
            if(aSetOfGame.distinguishResult()) {
                // 정답이라면
                correctResult();
            }
        } while(!isAnswerAndTerminate);
    }
}
