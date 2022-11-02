package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game extends IO{
    final static int PLAYING = 1;
    final static int END = 2;

    int state;
    public void start(){
        while(state != END){
            match();
            askContinue();
        }
    }
    public void askContinue(){
        this.state = readInt("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(this.state==END)
            System.out.println("게임 종료");
        else if(this.state != PLAYING)
            throw new IllegalArgumentException("잘못된 선택입니다.");
    }

    public void match(){
        Player computer = new Player();
        int resultCode;
        do {
            String input = readStr("숫자를 입력해주세요 : ");
            Player user = new Player(input);
            resultCode = computer.printCompareTo(user);
        } while (resultCode != Player.HAS_ALL_STRIKES);
    }
}