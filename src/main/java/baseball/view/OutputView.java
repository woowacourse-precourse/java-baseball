package baseball.view;

public class OutputView {
    public static void printHint(int[] hint){
        if(hint[0] != 0){
            System.out.print(hint[0] + "볼 ");
        }
        if(hint[1] != 0){
            System.out.print(hint[1]+"스트라이크 ");
        }
        if(hint[0] == 0 && hint[1] == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
