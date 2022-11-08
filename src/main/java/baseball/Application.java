package baseball;

public class Application {

    public static void main(String[] args){

        try{
            App app = new App();
            app.play();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
