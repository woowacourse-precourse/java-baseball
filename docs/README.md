# 과제 풀이 방향성

 * 컴퓨터가 제공하는 3자리의 수를 구현
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
 
 * 사용자의 3자리 수 입력 받기 
 
 * 규칙 설정
 
 * 규칙에 따른 출력 설정
 
 * 게임을 끝낼 것인지 다시 시작할 것인지 설정
 
 
# 입출력 사항
  * 프로그램 시작 메세지 출력
  
      ```
      숫자 야구 게임을 시작합니다. 
      ```
  * 숫자 입력
  
      ```
      숫자를 입력해주세요. 
      ```
      - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
      - 변수에 저장.
  * 결과 출력
    
     ```
     낫싱
     1볼
     1스트라이크
     3스트라이크
     ...
     ```
     - 입력된 수와 랜덤 수 비교 후 결과 출력
     - **비교 하는 기능**
     - **랜덤 숫자 생성 기능**
     - **결과에 따른 반복 및 종료 기능**
     
  * 기능 목록
     - **랜덤 수 생성 기능**
        - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
        - 각 자릿수를 비교하여 3자리 모두 다르게 설정
        - 각 자릿수 나누어 0이 존재하지 않도록 설정
        - 각 자릿수 나누어 넣어줄 자료형을 결정 ( List<> , int배열, String배열, 중복없는게 중요하니 HashMap도 고려 )
        
  
   
   
 
# 과제 진행 시 고민 해야 할 사항
 
  * 기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항 
  * 예외 가능성 고민
  * 기능 단위 메서드 분리 가능성에 대한 고민
  * 기능 단위 커밋 실천 
  * 테스트 코드 작성 후 기능 단위 테스트 실천
