# 기능 목록
+ main loop
  + public static java/baseball/Application.main(String args[]) => void
  + 게임의 시작,종료를 관리
  + 시작문구 출력
  + 게임 진행
    1. startGame() 으로 게임 진행
    2. 게임이 끝나면 게임을 새로 시작할지 종료할지 입력받음
  + 새로 시작한다면 게임 진행 반복
  

+ baseball game UI
  + public static java/baseball/Application.startGame() => void
  + 숫자 야구 게임의 플레이 흐름 구
  + 랜덤값 3자리 수 생성, Integer 리스트로 변환
  + 사용자 숫자 입력, Integer 리스트로 변환, 잘못된 값이면 IllegalArgumentException 발생
  + 스트라이크,볼 판단 결과 출력
  + 종료문구 출력
  

  
+ random generation
  + public static java/baseball/Application.getRandomNum() => List\<Integer>
  + 자릿수간의 중복이 없는 랜덤 3자리 숫자 생성 함수
  + 생성한 숫자의 각 자릿수를 리스트로 반환

  
+ parse user input
  + public static java/baseball/Application.parseUserInput(String ipt) => List\<Integer>
  + 유저의 문자열 숫자 입력을 자릿수별로 Integer 리스트로 반환
  + 잘못된 입력의 경우 IllegalArgumentException발생
  + 잘못된 입력 case
    + 숫자 이외의 문자가 존재
    + 3자리수가 아님
    + 자릿수간에 중복된 숫자가 존재


+ get result String
  + public static java/baseball/Application.getResultStr(int StrikeCnt, int BallCnt) => String
  + Strike 개수와 Ball 개수를 합쳐서 결과 문장 생성


+ check strike
  + public static java/baseball/Application.getStrikeCnt(List\<Integer> A, List\<Integer> B) => int
  + A와 B간의 스트라이크 개수 반환
  

+ check ball
  + public static java/baseball/Application.getBallCnt(List\<Integer> A, List\<Integer> B) => int
  + A와 B간의 볼 개수 반환
  