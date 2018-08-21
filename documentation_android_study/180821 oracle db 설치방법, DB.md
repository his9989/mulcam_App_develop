## oracle database 설치방법
1. 첨부한 exe 설치 프로그램 실행
2. 데이터베이스 암호 지정에서 암호 입력하기
3. 

## 단축키, 용어 등
1. handler : main Thread의 것
2. Thread의 메소드
  * onPreExecute : main Thread 작업 전에 실행할 것
  * onPostExecute : main Thread 작업 후에 실행할 것
  * onCancelled : main Thread 작업이 취소대면 실행할 것
  * onProgressUpdate : main Thread가 수행하는 본문.
  * doInBackground : user Thread 작업하는 곳. user Thread에서는 화면 편집이 불가능하다. <br>
    그러므로, publishProgress() 명령어를 통해, onProgressUpdate를 호출해서 화면 편집해야한다. <br>
    이 때, 상단 class의 인자 타입에 따라, publishProgress(value) 처럼 main Thread에게 인자를 보낼 수 있다. <br>  
3. shared preferences : 간단한 data를 지속성 있게 모바일에 저장하기 위한 기능. (ex. 자동 로그인)

## DB
1. 용어
  * DB : 박스를 모아둔 창고
  * Table : 데이터를 저장하는 박스
  * query : DB안에서 사용하는 언어.
  * DB 먼저 만들고, Table 만들고, query 이용해서 데이터 넣고, 확인
  
2. 오라클 : 관계형 DB
  
