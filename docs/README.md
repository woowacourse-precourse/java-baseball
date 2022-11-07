구현 필요 기능 목록
- 

1. 랜덤 값 생성
   *  camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
2. 사용자 입력 값 읽기
   * camp.nextstep.edu.missionutils.Console의 readLine()을 활용
   * 서로 다른 3자리의 수
3. 스트라이크 / 볼 / 낫싱 판별
   * 함수화
   * 출력 
     * ?볼 ?스트라이크
     * 낫싱
     * 3스트라이크
       * 3개의 숫자를 모두 맞히셨습니다! 게임 종료
4. 예외 값 입력시 IllegalArgumentException 발생 후 종료
5. 정답 입력시 게임 종료
   * 종료 후 재시작/종료를 구분하는 1과 2중 하나의 수 읽기
6. 테스트 코드


주의 사항
-
1. 인덴트 2까지 허용
2. 함수는 한 가지 일만 하도록 최대한 작게 구성


로직
- 

int status = 1;
1. 시작 안내문구 출력
- DO
2. 랜덤 숫자 생성
3. 사용자 값 입력
4. 판별 메소드 (while 활용)
5. 재시작 / 종료 값 입력
   6. 재시작 status = 1;
   7. 종료 status = 2;
      8. while 종료
- WHILE (status == 1)