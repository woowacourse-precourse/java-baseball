package baseball.view.print;

public class MessagePrinter {

    public void printStartMessage() {
        System.out.println(Message.START_GAME_MESSAGE);
    }

    public void printEnterNumberMessage() {
        System.out.print(Message.INPUT_A_NUMBER_MESSAGE);
    }

    public void printBallAndStrikeCount(String counts) {
        System.out.println(counts);
    }

    public void printNothing() {
        System.out.println(Message.NOTHING);
    }

    public void printCorrectAnswerMessage() {
        System.out.print(Message.CORRECT_ANSWER_MESSAGE);
        System.out.println(Message.RESTART_GAME_MESSAGE);
    }
}
