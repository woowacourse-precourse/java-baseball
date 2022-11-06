package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    Input_Output IO = new Input_Output();
    static int Strike_count=0;
    static int Ball_count=0;
    public void Game_Progress()
    {


        IO.Computer_RandomNumber();//Input_Output에서 받은 컴퓨터의 수를 호출
        System.out.println(IO.computer);
        IO.User_enter();//Input_Output에서 받은 사용자의 수를 호출
        BaseNumber_Check(IO.computer,IO.Scan);
        System.out.println(Print_Current_Game());

    }
    public String Print_Current_Game()
    {
        if(Strike_count>0 && Ball_count==0)
            return (Strike_count+ "스트라이크");

        if(Strike_count==0 && Ball_count>0)
            return (Ball_count+"볼");

        if(Strike_count > 0 && Ball_count > 0)
            return (Strike_count + "스트라이크 "+ Ball_count + "볼");

        return ("낫싱");
    }


    public static void BaseNumber_Check(List<Integer> computer,List<Integer> User)//받은 값을 스트라이크와 볼인지 분류
    {
        for(int i=0; i<computer.size();i++)
        {
            if(Number_Check(computer.get(i),User.get(i)))
                Strike_count++;
            else
                Ball_Repeat(computer.get(i),User);

        }
    }

    public static boolean Ball_Repeat(int computer, List<Integer> User)//볼을 확인하기 위한 반복
    {
        for(int j =0; j<User.size();j++)
        {
            if(Number_Check(computer,User.get(j)))
                Ball_count++;
        }

        return false;
    }

    public static boolean Number_Check(int computer,int User)//같은 숫자가 맞는지 확인
    {
        if (Objects.equals(computer, User))
            return true;

        return false;
    }



}
