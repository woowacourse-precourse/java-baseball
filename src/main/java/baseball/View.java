package baseball;

public class View {
    private String s;

    public void printLine(String s){
        try {
            System.out.printf(s);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
