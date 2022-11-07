# 숫자야구 게임 기능 목록

+ 프로그램 시작 시 게임 시작. 
  + 현재 게임의 GameState를 RUNNING으로 변경
+ 서로 다른 세 숫자 뽑기
+ 사용자 입력 받기
  + 사용자 입력의 유효성 체크
    + invalid 할 경우 IllegalArgumentException을 발생시킨 후 Application을 종료
    + valid 할 경우 입력된 문자열을 List<Integer>로 변환
      + 사용자 입력에 따라 판정
+ 판정에 따라 힌트(볼/스트라이크/낫싱) 출력
  + 숫자와 위치가 맞을 경우 스트라이크 + 1
  + 숫자만 맞을 경우 볼 + 1
  + 한 숫자도 맞지 않는 경우 낫싱
+ 3 스트라이크의 경우 게임 종료
  + 현재 게임의 GameState를 OVER로 변경
+ 게임 종료 시 재시작 여부를 확인
  + 사용자 입력 유효성 체크
    + invalid한 경우 IllegalArgumentException을 발생 후 Application을 종료
  + 재시작 : 1, 게임종료 : 2 
+ 확인된 재시작 여부에 따라 게임 재시작 또는 종료

  