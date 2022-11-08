package baseball;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

public class Game {
    private Computer computer;
    private Player player;
    private List<Integer> computerNumbers;
    public Game(){
        computer = new Computer();
        player = new Player();
    }
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        getComputerNumbers();
        guessNumbers();
    }

    public void getComputerNumbers(){
        computer.selectNumbers();
        computerNumbers = computer.getSelectedNum();
    }

    public void guessNumbers(){
        String playerNumber;
        do{
            player.selectNumber();
            playerNumber = player.getSelectedNumber();
            Validate.validateInputNumber();
        }
        while(judge(userNumber));
    }

    public boolean judge(String num){
        int cntBall=0;
        int cntStrike = 0;
        for(int i=0;i<3;i++){
            int cur = num.charAt(i)-'0';
            if(cur == computerNumbers.get(i)){
                cntStrike++;
            }
            else if(computerNumbers.contains(cur)){
                cntBall++;
            }
        }
        printJudgeResult(cntBall,cntStrike);
        return(cntStrike!=3);

    }
    public void printJudgeResult(int cntBall, int cntStrike){
        if(cntBall+cntStrike==0){
            System.out.println("낫싱");
        }
        else if(cntBall==0){
            System.out.println(cntStrike+"스트라이크");
        }
        else{
            System.out.println(cntBall+"볼 "+cntStrike+"스트라이크");
        }
    }

}
