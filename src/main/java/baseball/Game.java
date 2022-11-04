package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
Input_Output IO = new Input_Output();

public void Print()
{
    int Strike_count=0;
    int Ball_count=0;

    IO.Computer_RandomNumber();
    System.out.println(IO.computer);
    IO.User_enter();


    Strike_count = Strike_Check(IO.computer,IO.Scan,Strike_count);
    Ball_count = Ball_Check(IO.computer,IO.Scan,Ball_count);

    System.out.println(Strike_count + " 스트라이크 "+ Ball_count + "볼");


}

public static int Strike_Check(List<Integer> computer,List<Integer> User_Number,int Strike_count)
{
    for(int i=0; i<computer.size();i++)
      Strike_count = Number_Check(computer.get(i), User_Number.get(i),Strike_count);

   return Strike_count;
}

public static int Ball_Repeat(int computer, List<Integer> User, int repeat_Number,int Ball_count)//볼을 확인하기 위한 반복
{
    for(int j =0; j<User.size();j++)
        if(repeat_Number != j)//스트라이크 제외하기
           Ball_count = Number_Check(computer,User.get(j),Ball_count);

    return Ball_count;
}

    public static int Ball_Check(List<Integer> computer,List<Integer> User,int Ball_count)
    {
        for(int i =0;i<computer.size();i++)
            Ball_count =Ball_Repeat(computer.get(i),User,i,Ball_count);

        return Ball_count;
    }

    public static int Number_Check(int computer,int User,int count)//같은 숫자가 맞는지 확인
    {
        if (Objects.equals(computer, User))
            count++;

        return count;
    }



}
