# - 숫자 야구 구현 과정 -

## ##UTF-8 인코딩 방법##
    이 기능은 한글 출력이 필수이기 때문에 UTF-8로 인코딩을 해줘야한다.
    따라서, help-> Edit Custom VM Options에서 맨 아래줄에 -Dfile.encoding=UTF-8을 저장하고 재실행을 한다.
    만일 이래도 인코딩이 되지 않는다면, File -> Settings -> File Encodings 에서 모든 인코딩을 UTF-8로 설정한다.
---
## 구현을 위한 기능 및 예상되는 예외
- 1.게임을 위한 사용자 입력이 숫자 3개보다 많거나 작거나 없을경우

   -> 해결 방안: String 으로 받은 사용자입력을 length()를 사용해서 판별한다.


- 2.게임 재시작을 위한 사용자 입력이 1,2가 아닌경우

  -> 해결 방안: if else 문으로 예외발생시 IllegalArgumentException를 띄운다


- 3.게임을 위한 사용자 입력이 중복되는 경우

  -> 해결 방안: list에 입력을 담는 과정에서 contains()을 사용하여 중복확인을 해준다

- 4.숫자가 아닌 입력이 들어왔을때
  
    -> 굳이 예외처리를 안해도, 형변환과정에서 NumberFormatException이 일어나기에 특별한 처리는 해주지 않았다.

- --

## 함수 세부 설명

#### public static String user_input() 
    사용자입력을 받을때 BufferedReader를 사용하는데, 매번 입력을 받을때 main함수에 
    throws문을 사용할경우 현재 있는 테스트가 변해야하기 때문에 try-catch문으로 IOException처리를 한번에 해주고
    사용자입력을 string형으로 return해주는 함수

#### - public static HashMap<String,Integer> count_ball(List<Integer> target_ball, int input_ball)
    get_rand()에서 뽑은 숫자와 in_game에서 보내준 숫자와 비교해서 스트라이크 볼을 판별해 HashMap<Integer,Integer>에
    각각의 value값을 넣어주는 함수

#### - public static List<Integer> get_rand()
    게임내에서 비교할 숫자 3개를 범위에 맞게 랜덤하게 뽑아주는 함수

#### - public static int in_game(List<Integer>target_ball)
    인게임내에서 사용자입력을 받고 count_ball()함수를 통해 나온결과에 맞게 출력해주고, 3스트라이크일때 사용자 입력을 받아
    1,2둘중 하나의 수르 main함수로 보내주는 함수

#### public static void main(String[] args)
    무한루프를 돌면서 게임을 진행하고 이때 in_game()에서 return해준 결과에 맞게 break할지 continue를 할지 결정해서 결과를
    내는 함수

---
## 경험한 오류
 
구현은 한번에 쉽게 했다. 하지만 처음에 Scanner로 사용자 입력을 받아서 진행했는데 왜인지는 모르겠으나 테스트를 진행함에 있어
테스트를 각각 진행하면 오류가 없었지만, 모든 테스트를 한번에 돌렸을때 아래의 오류를 경험했다.

    java.lang.AssertionError: Expecting code to raise a throwable.
아무리 봐도 코드에는 오류가 없는데 왜 발생하는지 모르겠어서, 혹시 Scanner의 문제인지 알아보기 위해 BufferedReader를 사용했고
문제 없이 테스트가 돌아갔다. 내가 아는 둘의 차이는 속도 차이로 알고있는데 내가 모르는 무언가가 있는줄 알고 찾아봤다. 하지만 원하는 
결과를 얻지 못했다. 계속 찾아볼 계획이다. 
---