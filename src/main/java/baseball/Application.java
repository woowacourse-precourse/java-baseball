package baseball;

public class Application {
    public static int[] makenumber(){
        int[] randomNumber = new int[3];
        for(int i=0;i<randomNumber.length;i++){
            randomNumber[i]=(int) (Math.random()*10);
            for(int j=0;j<i;j++){
                if(randomNumber[i]==randomNumber[j]){
                    i--;
                }
            }
        }
        return randomNumber;
    }
    public static void main(String[] args) {
        int answer[]= new int[3];


        }
    }

