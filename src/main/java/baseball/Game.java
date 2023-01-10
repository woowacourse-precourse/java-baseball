package baseball;

import java.util.Scanner;

public class Game{
    Computer gameComputer;
    int ball,strike;

    public Game(){
        this.gameComputer=new Computer();
        this.ball=0;
        this.strike=0;
    }

    public void RunGame(){
        while(true){
            /* 사용자 입력값 */
            this.ball=0;
            this.strike=0;

            int input;
            Scanner sc=new Scanner(System.in);
            System.out.println("슷자를 입력해주세요: ");
            input= sc.nextInt();

            /*결과 출력 함수 실행*/
            this.Compare(input);
            if (this.printResult()){
                break;
            }/*catch (IllegalArgumentException e){
                System.out.println(e.toString());
            }*/
        }
    }

    /* 컴퓨터의 정답과 사용자 입력값 비교 */
    public void Compare(int input){
        int mod=100;
        for(Integer e:this.gameComputer.random){
            System.out.println(input/mod);
            this.Result(input/mod,e); //result 판단
            input=input-(input/mod)*mod;
            mod/=10;
        }
    }

    /*해당 자릿수를 넘겨서 어떤 result 인지 판단하는 함수
     볼, 스트라이크 개수 판단, 1도 없으면 낫싱*/
    public void Result(int input,int e){
        if (input==e){
            this.strike+=1;
        }
        else if(this.gameComputer.random.contains(input)){
            this.ball+=1;
        }
    }

    /* 성공, 실패 판단 & 결과 출력 */
    public boolean printResult(){
        if (this.strike==3){
            System.out.println(this.strike+"스트라이크");
            return true;
        } else if (this.strike==0 && this.ball==0){
            System.out.println("낫싱");
            return false;
        } else if (this.strike>0 && this.ball==0) {
            System.out.println(this.strike+"스트라이크");
            return false;
        } else if (this.ball>0 && this.strike==0) {
            System.out.println(this.ball + "볼");
            return false;
        }else{
            System.out.println(this.strike+"스트라이크 "+this.ball + "볼");
            return false;
        }
    }
}