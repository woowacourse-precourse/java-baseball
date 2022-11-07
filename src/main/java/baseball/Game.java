package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Computer computer;
    public Game(){
    }

    public void init(Computer computer){
        System.out.println("숫자 야구 게임을 시작합니다.");

        this.computer = computer;

        String inputNumber = input();


    }

    private String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }


}
