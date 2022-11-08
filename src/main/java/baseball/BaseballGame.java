package baseball;

import java.util.HashMap;
import java.util.Scanner;

public class BaseballGame {

    private Scanner scanner = new Scanner(System.in);
    private View view = new View(scanner);
    private GameFunction gameFunction= new GameFunction();
    private Generator generator = new Generator();
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String CORRECT_MESSAGE ="3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public BaseballGame(){

    }


    public int GameStart(){
        view.viewMessage(START_MESSAGE);
        HashMap<Character, Integer> computer = generator.Generator();
        while(gameFunction.Homerun()) {
            String userInput = view.userRequestNumber();
            view.viewMessage(gameFunction.GameFunction(userInput, computer));
        }
        view.viewMessage(CORRECT_MESSAGE);
        return view.restOrExit();
    }
}
