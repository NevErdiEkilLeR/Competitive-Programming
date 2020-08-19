create table game_users (
	id varchar(255),
	primary key(id)
);

create table characters (
	name varchar(255),
	price int,
	primary key(name)
);

create table purchases (
	id int,
	user_id varchar(255),
	purchase_data datetime,
	item varchar(255),
	primary key(id),
	foreign key (item) references characters (name),
	foreign key (user_id) references game_users (id)
);

insert into game_users values('user1');
insert into game_users values('user2');
insert into game_users values('user3');
insert into characters values('Albatross', 1000);
insert into characters values('Bee', 3000);
insert into purchases values(1, 'user1', '2020-02-03 07:00:11', 'Albatross');
insert into purchases values(2, 'user2', '2020-02-03 07:00:11', 'Albatross');
insert into purchases values(3, 'user1', '2020-03-03 07:00:11', 'Bee');

select u.id, ifnull(count(p.user_id), 0) as purchase_count, ifnull(sum(c.price),0) as total_price
from game_users u
left join purchases p
on u.id = p.user_id
left join characters c
on p.item = c.name
group by u.id;

