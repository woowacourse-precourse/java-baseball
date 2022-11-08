package baseball;

import java.util.List;

public class Game {
    Computer computer = new Computer();
    private List<Integer> ComputerNumbers;
    public Game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void playGame(){
        getComputerNumbers();
    }
    public void getComputerNumbers(){
        computer.selectNumbers();
        ComputerNumbers = computer.getSelectedNum();
    }
}
