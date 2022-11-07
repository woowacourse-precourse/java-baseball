package baseball;

import baseball.score.Score;

public class Game {
    private boolean isPlay;
    private final ScoreCalculator scoreCalculator;
    private final Reader reader;
    private final int numberLength;

    public Game(ScoreCalculator scoreCalculator, Reader reader, int numberLength) {
        isPlay = true;
        this.scoreCalculator = scoreCalculator;
        this.reader = reader;
        this.numberLength = numberLength;
    }

    public void play() {
        startPrint();
        while (isPlay) {
            int actual = RandomGenerator.getRandomNumber(numberLength);
            guessing(actual);
            winMessage();
            reGameOrEndMessage();
            int command = reader.readInt(1, 2);
            endIfCommandTwo(command);
        }
    }

    private void endIfCommandTwo(int command) {
        if (command == 2)
            isPlay = false;
    }

    private void winMessage() {
        Printer.println(numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }
    private void reGameOrEndMessage(){
        Printer.println( "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void guessing(int actual) {
        int minValue = (int) Math.pow(10, numberLength - 1);
        int maxValue = (int) Math.pow(10, numberLength) - 1;
        while (true) {
            Printer.print("숫자를 입력해주세요 : ");
            int expect = reader.readInt(minValue, maxValue);
            Score score = scoreCalculator.calculateScore(expect, actual);
            Printer.println(score);
            if (score.isSame(numberLength, 0))
                return;
        }
    }

    private void startPrint() {
        Printer.println("숫자 야구 게임을 시작합니다.");
    }

}
