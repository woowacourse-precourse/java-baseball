## 🚀 구현할 기능목록
***

### # 게임준비
* 상대방의 숫자생성
   * 1~9 사이의 랜덤 수
   * 서로다른 임의의 수
   * 3개의 수 선택
            

* 플레이어의 숫자입력
   * 콘솔에 숫자입력
   ````  
   * 예외사항 *

   - 숫자가 아닌 수 입력 ⇒ "숫자만 입력이 가능합니다"
   - 3글자 이상 입력 ⇒ "숫자 3개만 입력할 수 있습니다"

### # 본 게임

* 게임 시작 문구 출력
* 숫자야구 알고리즘

### # 게임 마무리
* 게임 재시작/종료 구분
  * 재시작: 1
  * 종료: 2

---
* ComputerPlater : 상대방 플레이어
  * 초기화 → 랜덤한 자신의 숫자리스트 생성 
  * getNumberList() → 자신의 숫자리스트 출력


* UserPlayer : 사용자 플레이어
  * 사용자는 한명임으로 싱글톤으로 구현
  * 입력값은 유효할때만 setNumberList()을 통해 설정
        

* BaseballGameController
  * 게임의 전체적인 진행 담당
    * 게임 초기화 → gameInit()
    * 게임 시작 → startGame()
    * 본 게임 → playGame()
    * 게임 지속 여부 결정 → choiceGameProgress()
          

* MatchJudgmentController
  * 경기 결과 판정 담당
    * 게임 종료 여부 → isGameOver()
    * 볼 수 세기 → countBall()
    * 스트라이크 수 세기 → countStrike()
    * 볼,스트라이크 갯수 초기화 → initGameModel()
    * 경기 결과 반환 → getMatchResult()
      
    
* UserInputValidator
  * 유효값 검사 담당
