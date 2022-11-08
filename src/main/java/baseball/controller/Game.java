public class Game {
    private static int newGameCode = 1;
    private static int shutDownCode = 2;
    public static int getNewGameCode() {
        return newGameCode;
    }
    public static int getShutDownCode() {
        return shutDownCode;
    }
    private static int getInputNums() {
        showRequestInput();
        int nums = 0;
        try {
            nums = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            // 0인채로 리턴
        }
        return nums;
    }
}
