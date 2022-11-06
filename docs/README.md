## 구현 요구 사항
1. indent depth를 3이 넘지 않도록 구현한다.
2. 3항 연산자를 쓰지 않는다. 
3. 함수가 한가지 일만 하도록 최대한 작게 만들어라.  
4. 테스트 도구를 사용하여 기능 목록이 정상 동작함을 확인하라.

## Method 목록

method 1. void start_new_Baseball_Game( )

method 2. String select_Random_Number()

method 3. void game_play()

method 4. List<Integer> compare_two_case(String computer, String user)

method 5. Integer is_Strike_or_Ball(String computer, String user , int index)

method 6. String calculate_Result(List<Integer> list_result)

method 7. boolean continue_or_exit( )

method 8. void Input_num_exception_test()

## 기능 목록
**1. 게임의 시작**	

method 1. start_new_Baseball_Game( )
1) 게임 시작 문구의 출력("숫자 야구 게임을 시작합니다.")
2) method2 수행(임의의 숫자 3개를 선택)
3) 사용자가 숫자를 입력
4) 사용자와 컴퓨터의 숫자를 비교
5) 비교 결과를 통해 게임이 끝났는지, 진행중인지 판단

    5.1 만일 3스트라이크가 아니라면 3)으로 돌아가서 다시 수행
   
    5.2 만일 3스트라이크라면 6)으로 나아감
6) 게임종료 후 다시 사용자에게 값을 받아 다시 게임을 시작할지, 끝낼지 판단

    6.1 만일 종료를 원하다면, method1. 함수를 return
    6.2 만일 진행을 원한다면, 다시 method1. 을 수행 (Recrusion call로 구현 하지말기)
	
**2. 컴퓨터가 임의의 서로 다른 숫자 3개를 선택컴퓨터가 임의의 서로 다른 숫자 3개를 선택 후, 그 값을 저장**

method 2. select_Random_Number( ) 
	
**3. 사용자가 숫자를 입력**

method 3. void game_play()
사용자는 서로 다른 숫자 3가지를 입력해야한다.( 만일 중복이 있거나, 3자리의 숫자가 아닌경우 예외 처리가 필요)

사용자의 숫자 Console.readLine()을통하여 String 형으로 한번에 처리. 

기능 4,5번을 다시 큰 method로 묶어주어야함

**예외**

method 8. void Input_num_exception_test()
1. 사용자가 숫자를 하나만 불렀을 때(ex. '1')
2. 사용자가 숫자를 3개 초과로 불렀을 떄(ex. '1234')
3. 사용자가 숫자를 중복하여 불렀을 때(ex. '111')

**4. 사용자의 숫자를 바탕으로 컴퓨터와  숫자를 비교 후 결과를 제시**

1) 하나도 없는경우 > "낫싱"

2) 숫자만 맞춘경우 (위치는 맞추지 못함) > 볼

3) 위치와 숫자를 맞춘경우 > 스트라이크	
	
method 4. List<Integer> compare_two_case(String computer, String user)

method 5. Integer is_Strike_or_Ball(String computer, String user , int index)

method 6. String calculate_Result(List<Integer> list_result) 
    
    1 Sting equals( ) method를 통해 낫싱의 경우 탐색
    
    2 computer.contains(user.charAt(0~2)) 를 통하여 크게 있는지 없는지 구분 

    3 만일 contain != -1 이라면, computer와 user의 index를 비교한는 method4 수행

    4 Method 5 에서 수행한 Integer를 List에 넣어줌

    5 Method 6. 에서 나온 String 을 return.

**5. 결과를 통해 다시 수행할 것인지, 종료할 것인지 설정**

1) 3스트라이크인경우, 출력 "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

> list_result의 index 2의 값이 3이면 

2) 3스트라이크가 아닌경우, method 3과 method 4 를 다시 수행.

> method4, 5를 수행하는 큰 method가 필요.
	
**6. 사용자에게 게임을 계속할 것인지 아닌지 값을 받기** 

method 7. boolean continue_or_exit( ) 

**7. 사용자의 값을 바탕으로 게임을 진행 혹은 종료**

자료구조 초기화, main함수로 나왔다가 다시 수행. (recursion call 사용 하지 않기)
