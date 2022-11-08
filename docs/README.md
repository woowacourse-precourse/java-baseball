## 기능 구현 목록

- Controller
  - Controller
    - 게임의 실행준비 및 실행을 담당
    - 게임 종료 후 재개 여부 담당
    
- Service
  - GameService
    - 컴퓨터와 사용자의 숫자 비교
    - 비교 후 볼, 스트라이크 점수 증가
  
- Domain
  - GameDomain
    - 컴퓨터의 숫자 설정 및 불러오기
    - 볼, 스트라이크 개수 관리
  - UserDomain
    - 사용자 숫자 설정

- Util
  - RandomNumberMaker
    - 무작위 숫자 생성
    - 중복 여부 확인
  - UserNumberParser
    - 문자열로 된 입력을 지정된 크기의 배열에 int로 저장

- View
  - Requester
    - 사용자의 입력 유도
  - Respondent
    - 게임 결과 출력
    - 게임이 종료됨을 출력