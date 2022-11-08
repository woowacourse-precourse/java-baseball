package baseball;

public class Result {
    public static void printHint(int[] computerHint) {
        if (computerHint[0] != 0) {
            System.out.print(computerHint[0] + Message.BALL_MESSAGE + " ");
        }

        if (computerHint[1] != 0) {
            System.out.print(computerHint[1] + Message.STRIKE_MESSAGE + " ");
        }

        if (computerHint[0] == 0 && computerHint[1] == 0) {
            System.out.print(Message.NOTHING_MESSAGE + " ");
        }
        System.out.println();
    }
}
