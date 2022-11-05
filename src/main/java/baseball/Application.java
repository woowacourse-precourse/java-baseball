package baseball;

import baseball.number.client.ClientNumbers;
import baseball.number.client.HintsAboutNumbers;
import baseball.number.computer.ComputerNumbers;
import baseball.number.game.PlayGames;
import baseball.utils.validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {

    public static void main(String[] args){
        // TODO: 프로그램 구현
        ComputerNumbers computerNumbers = new ComputerNumbers();
        HintsAboutNumbers hint = new HintsAboutNumbers();
        ClientNumbers clientNumbers = new ClientNumbers();
        PlayGames playGames = new PlayGames();

        int quitGame;
        List<Integer> client;
        boolean isMatched;

        playGames.playGames();
//        do{
//            List<Integer> computerNumber = computerNumbers.generateRandomNumbers();
//            for (Integer integer : computerNumber) {
//                System.out.print(integer); //for test
//            }
//            do {
//                System.out.print("숫자를 입력해주세요 : ");
//
//                try {
//                    client = clientNumbers.clientNumberToList();
//                } catch (IOException e) {
//                    throw new IllegalArgumentException("문자 변환 에러");
//                }
//
//                isMatched = hint.hintAboutNumbers(client, computerNumber);
//                //숫자 입력시 힌트 출력 메서드 추가
//
//            } while (!isMatched); //입력한 숫자와 컴퓨터의 숫자가 같을때까지 반복
//
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//
//            quitGame = quitGame();
//            while(!(quitGame == 1 || quitGame ==2)) { //1 또는 2 입력할 때까지 반복
//                System.out.println("1 또는 2 만 입력해주십시오");
//                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
//                quitGame = quitGame();
//            }
//        } while(quitGame != 2); //1입력시 게임 재시작, 2 입력시 게임 종료

        System.out.println("게임을 종료합니다.");
    }

//    static int quitGame() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int quit = 0;
//        try {
//            quit = Integer.parseInt(br.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return quit;
//    }
}
