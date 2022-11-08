package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    static void game(){

    }
    static boolean finish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int restart = Integer.parseInt(bufferedReader.readLine());
            if(restart == 1) return false;
            else if(restart == 2) return true;
        }catch(Exception e) {}
        return true;
    }
    public static void main(String[] args) {

        do{
            game();
        }while(!finish());
    }
}
