## oracle database 설치방법
- OracleXEUniv 설치 프로그램
1. 첨부한 exe 설치 프로그램 실행
2. 데이터베이스 암호 지정에서 암호 입력하기

- oracle web site 접속
3. 홈페이지 열기 클릭하면 로그인할 수 있는 웹사이트가 열린다.
4. 로그인. admin 계정은 아이디는 "system", 비밀번호는 아까 설정한 비밀번호.
5. 위의 계정은 admin. 관리자다. 실질적으로 사용할 때는 계정 권환을 주거나 해야한다.

- 계정 설정
(DBA는 조심해야됨. 다음에 할때는 찾아보기)
6. 관리-데이터베이스사용자-사용자관리-HR 클릭
7. 아이디 hr, 비밀번호 hr, 잠금을 잠금 해제로 변환, DBA 클릭->사용자 변경 하면 잠금 해제 됨
8. 생성->아이디/비밀번호 설정, DBA 클릭 -> 계정 생성 완료

- 압축파일 (sqldeveloper-18.2.0.183.1748-x64) 설정
9. 첨부된 압축 파일 해제는 한글이나, 공백이 없는 경로에 해라.
10. 파일 최하단에 sqldeveloper.exe 실행해보기 
11. (이 전 데이터 불러오겠습니까?는 아니오! 클릭)

- Oracle sql Developer 만져보기
12. 접속란의 초록색 + 버튼 클릭. 만든 계정에 따라서 로그인. 테스트해서 좌측 하단에 성공이라고 뜨면 접속 완료.
13. 실습 내용은 하단 참고

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
    + DB 먼저 만들고, Table 만들고, query 이용해서 데이터 넣고, 확인
  * DDL : Definition (table 만들고)
  * DML : Manipulation (데이터 넣고)
  * DCL : control
  
2. 오라클 : 관계형 DB
  * 접속한 데이터 베이스의 테이블을 통해 데이터 구조를 볼 수 있다.
  * SQL 워크시트를 이용해서 sql 명령어를 입력하고, CRUD를 수행할 수 있다.
    + Creat, Read, Update, Delete
    + 워크시트에서 저장하면, .sql 파일로 저장할 수 있게 된다.
    + 실행할 때 는 "Ctrl + Enter"
 
3. 명령어
  * SELECT Table이름 FROM DB이름;
    + DB의 모든 데이터를 출력하는데, Table이름에 해당하는 Table만 출력해라.
    + (ex. SELECT 이름, 학번, 성적 FROM 전교생성적표; 의 경우, 전교생 성적표에서 모든 학생의 이름, 학번, 성적을 출력한다)
   
  * SELECT * From DB이름;
    + DB 내의 모든 행의 모든 테이블을 출력한다.
   
  * SELECT Table이름 FROM DB이름 WHERE 조건;
    + 조건에 맞춰서 데이터 출력
    + "WHERE 조건"에서 WHERE TABLE이름 IN (조건1, 조건2) 인 경우, IN은 OR 연산이다.
    + SELECT Table이름 FROM DB이름 WHERE 조건1 AND 조건2; 이용하면, AND연산 가능하다.
    + 조건으로 문자열과 같은지 비교하는 경우, 문자열은 홑따옴표로 묶어준다. ''
   
  * SELECT Table이름 FROM DB이름 ORDER BY Table이름;
    + 뒷 쪽의 Table이름을 기준으로 오름차순 정렬한다.
    + SELECT Table이름 FROM DB이름 ORDER BY Table이름 DESC; 의 경우 내림차순 정렬이다.

  * SELECT Count(Table), MAX(Table1), MIN(Table2), AVG(Table3) FROM EMP;
    + Oracle에서 제공하는 함수
    + Round(AVG(Table3),2)의 경우, 소숫점 아래 2재짜리까지 표시된다.
    + 별칭을 이용하면 보기 편하다. (SELECT Count(Table) 갯수, MAX(Table1) 최곳값, MIN(Table2) 최솟값, AVG(Table3) 평균값 FROM EMP;)
    

