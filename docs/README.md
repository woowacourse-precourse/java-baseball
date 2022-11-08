1. Game이라는 class 생성
- 게임을 시작하는 동시에 클래스 객체를 생성하여 생성자 함수를 호출한다.  생성자는 사용자가 맞춰야 할 각 자리수가 다른 세 자리 숫자 targetNumber를 생성한다.
2. Game class 내에서 사용자의 Input을 받아 리턴하는 멤버 함수 생성
- Input과 targetNum이 일치하는 넘버가 있는지 check하는 멤버함수 생성, 있다면 strike_num++
- ball을 check하기 위한 배열 생성 후 strike를 check하기 위한 과정을 수행할 때 배열[Input 각 자릿수]를 1로 설정한다. strike라면 배열[Input 각 자릿수]를 2로 설정한다.
- Input과 targetNum의 자리는 다르지만 같은 숫자가 있는 경우 (배열[idx]의 값이 1인경우) check하는 기능 구현
- ball의 개수와 strike의 개수 출력하는 함수 구현
3. 게임 종료 시의 이벤트 구현
- game_clear 플래그를 1로 set
- 게임을 새로 시작 할 지, 종료할 지를 구현
4. 입력을 받는 부분의 예외 처리 구현 =>check_user_num()
- 숫자를 입력해주세요 부분
  - 길이가 3인가? => check_user_input_len()
  - 숫자인가? => check_user_input_isnum()
  - 같은 숫자가 있는가? => check_user_input_isEqualExist()
5. 게임을 새로 시작할 지 종료할 지를 입력받는 부분의 예외 처리 구현 => check_new_game()
- 숫자인가? 
- 값이 1혹은 2인가? 



