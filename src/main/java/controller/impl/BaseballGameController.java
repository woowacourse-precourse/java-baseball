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

    public BaseballGameController(RandNumVO randnumVO, Comparator comparator) {
        this.randnumVO = randnumVO;
        this.comparator = comparator;
        this.inputer = new Inputer();
        this.flag = true;
    }

    @Override
    public void doGame() {
        try{
            while(flag){
                input = inputer.getInput();
                sig = comparator.doIntCompare(randnumVO.getRandNum(), input);
                validateGame();
            }
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            return;
        } finally {
            inputer.initInputer();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(inputer.getInput().get(0) == 1)
            {
                initGame();
            }
            else {
                return;
            }
        }
    }

    private void validateGame() {
        String result = "";
        if(sig.get(1) == 3) {
            flag = false;
        }
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


    private void initGame(){
        this.flag = true;
        this.randnumVO = new RandNumVO();
    }
}
