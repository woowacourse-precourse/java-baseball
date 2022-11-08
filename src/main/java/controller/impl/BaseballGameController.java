package controller.impl;

import controller.GameController;
import domain.RandNumVO;
import util.Comparator;
import util.Inputer;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController implements GameController {
    private int conut = 0;
    private RandNumVO randnumVO;
    private Comparator comparator;
    private List<Integer> input;    // 입력
    private List<Integer> sig;      // 입력에 대한 스트라이크, 볼 정보
    private Inputer inputer;
    private boolean flag;

    public BaseballGameController(RandNumVO randnumVO, Comparator comparator, Inputer inputer) {
        this.randnumVO = randnumVO;
        this.comparator = comparator;
        this.inputer = inputer;
        this.flag = true;
    }
    @Override
    public void doGame() throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    private void playGame() throws IllegalArgumentException{
        while(flag){
            System.out.print("숫자를 입력해주세요 : ");
            input = inputer.getInput();
            sig = comparator.doIntCompare(randnumVO.getRandNum(), input);
            printGame();
            checkGameOver();
        }
        inputer.initInputer();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(inputer.getInput().get(0) == 1)
        {
            initGame();
            playGame();
        }
    }

    private void printGame() {
        String result = "";
        if(sig.get(0) > 0) {
            result += sig.get(0)+"볼 ";
        }
        if(sig.get(1) > 0){
            result += sig.get(1)+"스트라이크 ";
        }
        if(sig.get(2) == 1){
            result = "낫싱";
        }
        System.out.println(result);
    }

    private void checkGameOver(){
        if(sig.get(1) == 3) {
            flag = false;
        }
    }


    private void initGame(){
        this.flag = true;
        this.randnumVO = new RandNumVO();
    }
}
