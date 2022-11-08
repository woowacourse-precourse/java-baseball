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
        checkInputNum(myAnswer);

        return Integer.parseInt(myAnswer);
    }

    public void checkInputNum(String myAnswer) {
        int num = 0;
        try {
            num = Integer.parseInt(myAnswer);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        // 3자리인지 , 각 자리수가 1~9 인지 , 하나라도 같은 자리수가 있는지
        if((num / 100 >= 10) ||
                (num / 100 == 0) ||
                ((num % 10) == 0) ||
                (((num % 100) / 10) == 0) ||
                ((num / 100) == 0) ||
                ((num % 10) == ((num % 100) / 10)) ||
                ((num % 10) == (num / 100)) ||
                (((num % 100) / 10) == (num / 100))
        ) throw new IllegalArgumentException();
    }

    public void inquiryStartOrTerminate() {
        AppView.outputLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        AppView.outputLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String myResponse = AppView.inputLine();
        checkResponseNum(myResponse);
    }

    public void checkResponseNum(String myResponse) {
        int num = 0;
        try {
            num = Integer.parseInt(myResponse);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(num != 1 && num != 2) {
            throw new IllegalArgumentException();
        }

        if(num == 1) {
            counterpart = new CounterpartModel();
        }

        if(num == 2) {
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
                inquiryStartOrTerminate();
            }
        } while(!isAnswerAndTerminate);
    }
}
