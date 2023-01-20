select * from buslayout;
delimiter //
create procedure insertbusmap(in stno int,in beerth varchar(20),in statuss varchar(20),in regno varchar(20))
begin 
insert into buslayout(seatno,berth,statuss,regno) values(stno,beerth,statuss,regno);
end //
delimiter ;
 select * from buslayout;
call insertbusmap(10,'L','Available','AB-999');


create table buslayout
(
	Seatno int,
	Berth varchar(10),
	Statuss varchar(20),
    regno varchar(20),
    uid varchar(20),
    reservdt timestamp,
    foreign key (regno) references bm(regno)
);


delimiter //
create procedure booking(in seatnoo int,regnoo varchar(20))
begin
update buslayout set statuss='booked',uid=concat('AB',floor(rand()*10000999-1)),reservdt=now() where seatno=seatnoo AND regno=regnoo;
end //
delimiter ;
call booking(9,'AB-999');


delimiter //
create trigger bookings
after update  on buslayout for each row
begin 
insert into busmap
select regno, seatno ,berth ,statuss ,uid ,reservdt  from buslayout where statuss  in(select statuss from buslayout where statuss='booked');
end //
delimiter ;

delimiter //
create procedure viewticket(in regno varchar(20),in uid varchar(20))
begin
select distinctrow lname,email,BERTH,seatno,src,destii,btime,arri,uid,reservdt ,statuss from user,trip,buslayout where buslayout.regno=regno and UID=uid ;
end //
delimiter ;

call viewticket('AB-999','AB940524');

delimiter //
create procedure final(in regno varchar(20),in seatn int)
begin
select distinctrow lname,email,BERTH,seatno,src,destii,btime,arri,uid,reservdt ,statuss from user,trip,buslayout where buslayout.regno=regno and seatno=seatn limit 1;
end //
delimiter ;
call final('AB-999',9);


/*--------------------------------------cancellation-------------------------------------------------------------*/
delimiter //
create  procedure insertcan(in rno varchar(20), in seatno int)
begin
insert into cancelled(regno,seatno,cid,canceltime) values(rno,seatno,concat('CD',floor(rand()*10000999-1)),now());
update buslayout set statuss='AVAILABLE' where regno=RNO AND SEATNO=seatno;
end //
delimiter ;
call insertcan('AB-999',10);









