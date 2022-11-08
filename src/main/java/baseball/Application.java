package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        public static void main(String[] args) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            int com[] = new int[3]; // 컴퓨터 숫자 
            Random r = new Random();
            boolean again = true ;
            com=randomNumber(again);
            // 랜덤숫자 배정받기		
                    
            
            while(again) { //strike 3개 나올때까지 반복
                int striket=0;
                int ballt=0;			
                int[] user= userInput(); //유저 입력받기
                for(int k=0; k<3; k++) {
                    
                    
                    striket=strikeb(com,user,striket,k); //함수 안에 스트라이크값과 밖 값이 다름
                    ballt=sball(com,user,ballt,k); //함수 볼값과 밖 값이 다름
                    
                    
                }
                System.out.println(nothing(striket,ballt));
                
                
                
                if(striket == 3) {
                    again=playagain();
                    com=randomNumber(again);
    
                }
            }
        }
    
    
        public static int[] userInput(){ //user input 받기 함수
            Scanner sc = new Scanner(System.in);
            int user[] = new int[3];
            System.out.print("숫자를 입력해 주세요");
            int number=sc.nextInt();			
            user[0] = number/100;
            user[1] = (number%100)/10;
            user[2]= number%10;
                
            return user;
                    }
        
        
        
        // strike 인지 판별 함수
        public static int strikeb(int[] com,int[] user,int strike,int i){
                                
            for(int j=0; j<3; j++) {
                if(com[i] == user[j] && i==j) { // 숫자와 위치가 일치
                    strike=strike+1;
                }
        
                }
            return strike;	
                
                }
    
        // ball 인지 판별 함수
        public static int sball(int[] com,int[] user,int ball,int i){
                        
            for(int j=0; j<3; j++) {
                if(com[i] == user[j] && i!=j) { // 숫자와 위치가 일치x
                    ball=ball+1;
                }
        
                }
            return ball;	
                
                }
    
    
        //game reset
        public static boolean playagain(){
            System.out.println("3스트라이크\n"
                +"3개의 숫자를 모두 맞히셨습니다!");
            System.out.println( "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            Scanner scanner = new Scanner(System.in);
            char answer = scanner.next().charAt(0);
            if(answer == '1'){
                return true;
            }
            return false;
        }
        //숫자 배정받기 함수
        public static int[] randomNumber(boolean againS){
            int com[] = new int[3]; // 컴퓨터 숫자 
            Random r = new Random();
            if (againS==true){
                while(com[0]==0) {
                    com[0] = r.nextInt(10);
                }
                while(com[0]==com[1] || com[1]==0) {
                    com[1] = r.nextInt(10);
                }
                while(com[1]==com[2] || com[2]==0) {
                    com[2] = r.nextInt(10);
                }
            }
            return com;
        }
        //몇strike 몇ball인지 출력 함수
        public static String nothing(int numberStrike, int numberBall)
        {
            String str="";
            if(numberStrike==0&&numberBall==0)
            {
                str="낫싱";
            }
            else{
                str=numberStrike+" 스트라이크 "+numberBall+" 볼 ";
            }
            return str;
            
            
            
        
        }
    }
}
