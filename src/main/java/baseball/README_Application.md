### 우아한 테크 코스 2주차 과제: 숫자 야구
- [ ] 각 자리의 수가 다른 3자리 수(int computer) 생성
  - camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용
  - input 받기

- [ ] 1차 반복문:
  - "숫자 야구 게임을 시작합니다." 출력
  - [ ] 1차 조건문: 게임이 끝난 상태인지 확인
    - int strike 변수의 값이 3이라면 게임이 끝난 상태
    - True:
      - 1 = 재시작
      - 2 = 종료
    - False:
      - [ ] 2차 조건문: 입력값 확인
        - 3자리 수
        - 각 자리 숫자가 달라야 함
        - True:
          - 스트라이크/볼/낫싱 검수
        - False:
          - IllegalArgumentException 반환 + 애플리케이션 종료.

### 클린 코드 요구 사항
- [ ] indent depth 2 이하
- [ ] 삼항 연산자(condition ? true:false) 사용 X
- [ ] 1함수 1기능