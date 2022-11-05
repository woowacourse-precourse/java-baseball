package baseball.number.game;

import baseball.number.client.ClientNumbers;
import baseball.number.client.HintsAboutNumbers;
import baseball.number.computer.ComputerNumbers;
import baseball.utils.validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class PlayGames {

    ComputerNumbers computerNumbers = new ComputerNumbers();
    HintsAboutNumbers hint = new HintsAboutNumbers();
    ClientNumbers clientNumbers = new ClientNumbers();

    Scanner sc = new Scanner(System.in);
    boolean isMatched;

    public void playGames() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int quitGame = 0;
        do{
            List<Integer> computerNumber = computerNumbers.generateRandomNumbers();
//            for (Integer integer : computerNumber) {
//                System.out.print(integer); //for test
//            }

            matchNumber(computerNumber);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            quitGame = Integer.parseInt(sc.next());

        } while(quitGame != 2); //1입력시 게임 재시작, 2 입력시 게임 종료
    }

    public void matchNumber(List<Integer> computerNumber) {
        boolean isMatched;
        do {
            String number = sc.next();

            List<Integer> client = clientNumbers.clientNumberToList(number);

            isMatched = hint.hintAboutNumbers(client, computerNumber);
            //숫자 입력시 힌트 출력 메서드 추가

        } while (!isMatched); //입력한 숫자와 컴퓨터의 숫자가 같을때까지 반복
    }

}
