--����
--���̺� ����(student) : num ����(5), name ���ڿ�(10), heigth ����(5,1),
--java ����(3) �⺻�� 10, spring ����(3) �⺻�� 10, ban ���ڿ� (20)
create table student (
    num number(5),
    name varchar2(10),
    height number(5,1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar(20));
    
  --������ ���� seq_stu �⺻(1���� 1�� ����), nocache �߰�
  create SEQUENCE seq_stu nocache;
    
  --���� ���ǵ� �߰�
  --num�� primary key �߰�(student_pk_nu)
  alter table student add CONSTRAINT stdent_pk_num primary key(num);
   
  --java, spring �� 1~100�� �����ϵ��� check �������� �߰�
  alter table student add CONSTRAINT student_ck_java check(java>=1 and java<=100);
  alter table student add CONSTRAINT student_ck_spring check(spring>=1 and spring <=100);
    
  --ban�� '�޴Թ�', '�޴Թ�' '���Թ�'�� �߰��� �� �ֵ��� check �߰�
  alter table student add CONSTRAINT student_ck_ban check(ban in('�޴Թ�', '�޴Թ�', '���Թ�'));
    
  --5�� ������ ����Ÿ�� �߰��غ���
 insert into student (num, name, java, height, ban) values (seq_stu1.nextval, '������', 89, 167.5,'�޴Թ�');
 insert into student values (seq_stu.nextval, '��ȿ��', 162.5, 70, 55.12, '�޴Թ�');
 insert into student values (seq_stu.nextval, '�谡��', 175.2, 50, 60.12, '�޴Թ�');
 insert into student values (seq_stu.nextval, '�ִ���', 165.5, 70, 45.12, '���Թ�');
 insert into student values (seq_stu.nextval, '�ι�Ʈ', 175.5, 40, 80.12, '�޴Թ�');
  insert into student values (seq_stu.nextval, '��ÿ�', 175.5, 40, 80.12, '�޴Թ�');
 commit;
 
 --num>=4 �̻� ��� ����
 delete from student where num>=4;
 
 --num�� 3�� ����� java������ 99��, ban�� '�޴Թ�'���� ����
 update student set java = 99, ban = '�޴Թ�' where num = 3;
 
 -- num=2 �� ����� Ű�� 188.9�� ����
 update student set height = 188.9 where num = 2;
 
 -- num = 2�� ����Ÿ ����
 delete from student where num = 2;
 
 --����Ÿ 3������ �߰�
 insert into student values (seq_stu.nextval, '����', 165.2, 60, 48.12, '�޴Թ�');
 insert into student values (seq_stu.nextval, '����', 178.2, 30, 78.12, '�޴Թ�');
 insert into student values (seq_stu.nextval, '����', 155.2, 10, 40.12, '���Թ�');
 
 --��ȸ : �̸� �� �ڹ� ������ ���� ��� -������ ���� �������
 select name, ban, java, spring, java+spring total, (java+spring)/2 avg from student order by total desc;
 
 