package baseball;

import baseball.utils.GenerateRandomNumber;
import baseball.utils.StartGame;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartGame startGame = new StartGame();
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        HintsAboutNumbers hint = new HintsAboutNumbers();

        Scanner sc = new Scanner(System.in);
        int clientNumber;

        startGame.printStartGameMessage();
        int quitGame;

        boolean isMatched;
        do{
            int randomNumber = generateRandomNumber.generateRandomNumber();
            System.out.println(randomNumber);
            do {
                startGame.printInputThreeNumber();
                clientNumber = sc.nextInt(); //사용자 숫자 입력

                isMatched = hint.hintAboutNumbers(clientNumber, randomNumber);
                //숫자 입력시 힌트 출력 메서드 추가

            } while (!isMatched); //입력한 숫자와 컴퓨터의 숫자가 같을때까지 반복

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            quitGame = sc.nextInt();
            while(!(quitGame == 1 || quitGame ==2)) { //1 또는 2 입력할 때까지 반복
                System.out.println("1 또는 2 만 입력해주십시오");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                quitGame = sc.nextInt();
            }
        } while(quitGame != 2); //1입력시 게임 재시작, 2 입력시 게임 종료

        System.out.println("게임을 종료합니다.");
    }
}
