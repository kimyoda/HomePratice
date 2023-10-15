-- shop 테이블 생성
create SEQUENCE seq_shop start with 10 increment by 10 nocache;

--shop table 생성
create table shop (
    sang_no number(5) CONSTRAINT shop_pk_no primary key,
    snag_name varchar2(100),
    sang_price number(7),
    snag_color varchar2(20)
    );
ALTER TABLE shop RENAME COLUMN snag_name TO sang_name;
ALTER TABLE shop RENAME COLUMN snag_color TO sang_color;

-- 외부키로 연결된 cart 테이블을 생성 - shop의 상품을 자동으로 지워지도록 cascade를 설정해서 생성
create table cart (
    cart_no number(5) CONSTRAINT cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date
    );
    
alter table cart add CONSTRAINT cart_fk_shopno FOREIGN key(sang_no) REFERENCES shop(sang_no)   
on delete cascade;

insert into shop values(seq_shop.nextval, '블라우스', 23000, 'yellow');
insert into shop values(seq_shop.nextval, '청바지', 45000, 'blue');
insert into shop values(seq_shop.nextval, '브이넥티', 11000, 'white');
insert into shop values(seq_shop.nextval, '브이넥티', 21000, 'red');
insert into shop values(seq_shop.nextval, '체크자켓', 230000, 'gray');

insert into cart values(seq_shop.nextval, 10, 2, sysdate);
insert into cart values(seq_shop.nextval, 20, 4, sysdate);
insert into cart values(seq_shop.nextval, 30, 2, sysdate);
commit;

select * from cart;
select sang_name, sang_price, sang_color, cnt, to_char(cartday, 'yyyy-mm-dd hh24:mi') cartday
from shop s, cart c where s.sang_no=c.sang_no;

delete from shop where sang_no = 10;

drop table cart;
drop table shop;
drop SEQUENCE seq_shop;

--
insert into shop values(seq_shop.nextval, '레이스블라우스', 23000, 'white');
alter table shop modify sang_color varchar2(30);
insert into shop values(seq_shop.nextval, '레이스블라우스', 23000, 'white');
insert into shop values(seq_shop.nextval, '체크조끼', 34000, 'rainbow');
insert into shop values(seq_shop.nextval, '칠부청바지', 56000, 'blue');
commit;

create or replace PROCEDURE sangpum(sang varchar2)
is 
Cursor s1
is
select * from shop where sang_name like '%'||sang||'%';

v_cnt number(2);

begin
    select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
    if v_cnt = 0 then 
    dbms_output.put_line(sang||' 상품은 목록에 없습니다');
    else
    dbms_output.put_line(sang||'상품 조회하기');
    dbms_output.put_line('   ');
    dbms_output.put_line('상품번호   상품명     가격     색상');
    dbms_output.put_line('--------------------------------');
    for s in s1 loop
    dbms_output.put_line(s.sang_no||'     '||s.sang_name||'     '||s.sang_price||'       '||s.sang_color||'     ||');
    exit when s1%notfound;
    end loop;
    end if;
end;
/
-- 실행
exec sangpum('조끼');
exec sangpum('칠부청바지');
    