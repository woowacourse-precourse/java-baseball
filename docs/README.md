# 📕미션 - 숫자 야구 기능 구현 목록

1. 컴퓨터, 사용자의 숫자 세팅
   - 컴퓨터의 숫자 추출 List로 꺼내옴
   - 사용자의 입력 숫자 세팅
      - 숫자가 3개가 아니면 무조건 <code>IllegalArgumentException</code> 띄우기
      - 서로 다른 숫자인지 확인 아니면 <code>IllegalArgumentException</code> 띄우기
      - 사용자의 숫자를 입력시 문자열로 받아오므로 Integer로 변환 후 List로 꺼내기
2. 숫자 게임 기능 구현
   - 두 숫자 List를 비교하여 strike,ball 판정 내리기
      - 같은 인덱스에 같은 숫자인 경우 strike
      - 다른 인덱스에 같은 숫자인 경우 ball
   - 만약 strike가 3일 경우 -> 출력조건에 맞게 출력후 게임 종료 파트로 넘어감
      - 게임 재시작/종료 할지 1,2로 판별 -> 1 입력시 기능 1번 부터 다시 시작, 2 입력시 해당하는 출력물 출력 후 종료
         - 1,2도 아닌 다른 값 입력시 <code>IllegalArgumentException</code>띄우기
   - strike가 0이고 ball도 0일 경우 -> 낫싱 출력후 다음단계로 넘어감 이후 2번 과정으로 가서 다시 반복
