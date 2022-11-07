package baseball.gameconsole;

import camp.nextstep.edu.missionutils.Console;

public class GameClientConsole implements ClientConsole {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void outEndingSentence() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void outResultScoreSentence(String resultScoreSentence) {
        System.out.println(resultScoreSentence);
    }

    @Override
    public void outRequestInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    @Override
    public void outStartGameSentence() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void outEndGame() {
        System.out.println("게임 종료");
    }
}
