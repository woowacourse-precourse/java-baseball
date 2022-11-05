## 프로그램 구현 사항
---
- 

## 프로그램 제한 사항 정리
---
- 게임 종료 후 다시 시작하거나 완전히 종료 가능하다. 프로그램 종료 선택 가능
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시킨 후 종료한다.

## 구현 제한 사항 정리
---
- indent는 2까지만 사용 가능 (함수 분리 필요)
- 3항 연산자 쓰지 않기
- 메소드는 한 가지 일만 하도록 구성하기
- JUnit5/AssertJ을 사용하여 테스트 하기

## 라이브러리 제한 사항 정리
---
- `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현
- Random 값 추출은 pickNumberInRange() 활용
- 사용자 입력 값은 readLine() 활용
