--문제
--테이블 생성(student) : num 숫자(5), name 문자열(10), heigth 숫자(5,1),
--java 숫자(3) 기본값 10, spring 숫자(3) 기본값 10, ban 문자열 (20)
create table student (
    num number(5),
    name varchar2(10),
    height number(5,1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar(20));
    
  --시퀀스 생성 seq_stu 기본(1부터 1씩 증가), nocache 추가
  create SEQUENCE seq_stu nocache;
    
  --제약 조건들 추가
  --num에 primary key 추가(student_pk_nu)
  alter table student add CONSTRAINT stdent_pk_num primary key(num);
   
  --java, spring 은 1~100만 가능하도록 check 제약조건 추가
  alter table student add CONSTRAINT student_ck_java check(java>=1 and java<=100);
  alter table student add CONSTRAINT student_ck_spring check(spring>=1 and spring <=100);
    
  --ban은 '햇님반', '달님반' '별님반'만 추가할 수 있도록 check 추가
  alter table student add CONSTRAINT student_ck_ban check(ban in('햇님반', '달님반', '별님반'));
    
  --5개 정도만 데이타를 추가해보자
 insert into student (num, name, java, height, ban) values (seq_stu1.nextval, '김진아', 89, 167.5,'햇님반');
 insert into student values (seq_stu.nextval, '이효리', 162.5, 70, 55.12, '달님반');
 insert into student values (seq_stu.nextval, '김가영', 175.2, 50, 60.12, '햇님반');
 insert into student values (seq_stu.nextval, '주다주', 165.5, 70, 45.12, '별님반');
 insert into student values (seq_stu.nextval, '로버트', 175.5, 40, 80.12, '달님반');
  insert into student values (seq_stu.nextval, '김시원', 175.5, 40, 80.12, '햇님반');
 commit;
 
 --num>=4 이상 모두 삭제
 delete from student where num>=4;
 
 --num이 3인 사람의 java점수를 99로, ban을 '달님반'으로 수정
 update student set java = 99, ban = '달님반' where num = 3;
 
 -- num=2 인 사람의 키를 188.9로 수정
 update student set height = 188.9 where num = 2;
 
 -- num = 2인 데이타 삭제
 delete from student where num = 2;
 
 --데이타 3개정도 추가
 insert into student values (seq_stu.nextval, '영숙', 165.2, 60, 48.12, '달님반');
 insert into student values (seq_stu.nextval, '광수', 178.2, 30, 78.12, '햇님반');
 insert into student values (seq_stu.nextval, '영자', 155.2, 10, 40.12, '별님반');
 
 --조회 : 이름 반 자바 스프링 총점 평균 -총점이 높은 사람부터
 select name, ban, java, spring, java+spring total, (java+spring)/2 avg from student order by total desc;
 
 