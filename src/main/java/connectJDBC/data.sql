create database webbansach;
use webbansach;

## Thể loại:
create table category
(
    id          int primary key auto_increment,
    type        varchar(255),
    description varchar(255)
);
## Tác giả:
create table author
(
    id          int auto_increment primary key,
    name        varchar(255) not null,
    yearBorn    date         not null,
    national    varchar(255),
    description varchar(255)
);
## Sách
create table books(
    id          int primary key auto_increment,
    code        varchar(255) not null,
    name        varchar(255) not null,
    author_id   int          not null,
    foreign key (author_id) references author (id),
    price       double       not null,
    category_id int          not null,
    foreign key (category_id) references category (id),
    imgage      varchar(255),
    description varchar(255)
);
# Danh mục sách cùng thể loại:
create table book_category
(
    book_id     int not null,
    category_id int not null,
    foreign key (book_id) references books (id),
    foreign key (category_id) references books (id)
);
## Kho:
        create table stock
        (
        id int primary key auto_increment,
        book_id int not null,
        foreign key (book_id) references books (id),
        quantity int
        );
## Khách hàng:
create table customer
(
    id        int primary key auto_increment,
    name      varchar(255) not null,
    age       int          not null,
    gender    varchar(255) not null,
    address   varchar(255),
    phone     varchar(255) not null,
    email     varchar(255) not null,
    account   varchar(255) not null,
    password  varchar(255) not null,
    startdate date         not null,
    status varchar(255) default 'ACTIVATE'
);
## Đơn hàng:
create table orderS
(
    id          int primary key auto_increment,
    customer_id int,
    foreign key (customer_id) references customer (id),
    dateBuy     date
);
## Đơn hàng chi tiết:
create table ordersdetail
(
    id        int primary key auto_increment,
    orders_id int,
   #  foreign key (orders_id) references orderS (id),
    book_id   int,
    # foreign key (book_id) references books (id),
    quantity  int not null
);
use webbansach;
# # Chạy dòng lệnh này để đổi tên cột imgage
# alter table books rename column imgage to image;
# alter table books rename column author_id to author;

# Book:
select * from books;
insert into books(code, name, author, price, image, description) VALUE (1,'AA1', 'Khong gia dinh(tai ban nam 2022)','ID010', 127.500, 'https://bookbuy.vn/Res/Images/Product/khong-gia-dinh-tai-ban-2022-_118548_1.jpg', 'Sach kha hay va doc dao');
insert into books(id, code, name, author, price, image, description) VALUE (2, 'AA2', 'Dao giau vang(tai ban nam 2022)', 'R.L.Stevenson', 38.500, 'https://bookbuy.vn/Res/Images/Product/dao-giau-vang-tac-pham-chon-loc-van-hoc-scotland-tai-ban-2022-_118540_1.jpg', 'Sach cho nguoi lon');
insert into books(id, code, name, author, price, image, description) VALUE (3, 'AA3', 'Ty quay - nhung truyen sieu buon cuoi(tai ban 2022)', 'Dao Hai', 102.000, 'https://bookbuy.vn/Res/Images/Product/ty-quay-nhung-truyen-sieu-buon-cuoi-tai-ban-2022-_118525_1.jpg', 'Sach tre em duoi 18 tuoi');
insert into books(id, code, name, author, price, image, description) VALUE (4, 'AA4', 'Tranh truyen lich su Viet Nam', 'Nguyen Huy Thang & Le Minh Hai', 12.500, 'https://bookbuy.vn/Res/Images/Product/tranh-truyen-lich-su-viet-nam-thanh-thai_117869_1.jpg', 'Sach cho moi nguoi Viet Nam nen doc');
insert into books(id, code, name, author, price, image, description) VALUE (5, 'AA5', 'Chu tiem banh chien binh va co phuc vu nguoi may', 'Sow', 109.500, 'https://bookbuy.vn/Res/Images/Product/chu-tiem-banh-chien-binh-va-co-phuc-vu-nguoi-may-tap-5-_117009_1.jpg', 'Sach kha hay va doc dao');
insert into books(id, code, name, author, price, image, description) VALUE (6, 'AA6', 'Khong sao dau con, chap nhan loi tu choi', 'Tran Hong Tuan', 28.500, 'https://bookbuy.vn/Res/Images/Product/khong-sao-dau-con-chap-nhan-loi-tu-choi_116732_1.PNG', 'Sach cho moi lua tuoi');
insert into books(id, code, name, author, price, image, description) VALUE (7, 'AA7', 'Chuyen ve chu tho cool nhat Ha Lan', 'Guido Van Genechten', 44.500, 'https://bookbuy.vn/Res/Images/Product/chuyen-ve-chu-tho-cool-nhat-ha-lan-riki-gan-da_115849_1.jpg', 'Sach kha hay va doc dao');
insert into books(id, code, name, author, price, image, description) VALUE (8, 'AA8', 'Chuyen nay chuyen kia', 'Dom Dom', 89.500, 'https://bookbuy.vn/Res/Images/Product/115376_chuyen-nay-chuyen-kia-2-ban-dac-biet_115375_2.png', 'Sach cho tre em');
insert into books(id, code, name, author, price, image, description) VALUE (9, 'AA9', 'Leonardo Da Vinci', 'Steve Augarde, Leo Brown', 71.500, 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_66473.jpg', 'Sach cho moi lua tuoi');
insert into books(id, code, name, author, price, image, description) VALUE (10, 'AA10', 'Tu dien bang hinh cho tre mam non - nhung tu dau tien', 'NXB Dorling Kindersley', 100.500, 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_195509_1_22621.jpg', 'Sach cho tre em');
insert into books(id, code, name, author, price, image, description) VALUE (11, 'AA11', 'Sieu nhan bo - 100 hoat dong thuc tinh tinh cha con', 'Flavie Augereau', 70.500, 'https://cdn0.fahasa.com/media/catalog/product/b/i/bia_sieu_nhan_bo_2d_master.jpg', 'Sach cho bo don than');
insert into books(id, code, name, author, price, image, description) VALUE (12, 'AA12', '100 bai tap yoga sau sinh giup me dep con khoe', 'SOPHIE DUMOUTET', 60.500, 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_182627.jpg', 'Sach cho me tre con');
insert into books(id, code, name, author, price, image, description) VALUE (13, 'AA13', 'Neu khong la tinh yeu (tai ban 2019)', 'Diep lac vo tam', 79.500, 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_195509_1_12560.jpg', 'Sach cho nguoi da tinh');
insert into books(id, code, name, author, price, image, description) VALUE (14, 'AA14', 'Chan troi goc be (tai ban 2020', 'Diep lac vo tam', 80.500, 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_195509_1_30127.jpg', 'Sach cho moi nguoi');
insert into books(id, code, name, author, price, image, description) VALUE (15, 'AA15', 'Vi sao? Nhu the nao? Ai cap co dai', 'Fleurus', 909.500, 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_191518.jpg', 'Sach cho moi lua tuoi');
insert into books(id, code, name, author, price, image, description) VALUE (16, 'AA16', '30 chu de tu vung tieng anh', 'Trang Anh', 189.500, 'https://cdn0.fahasa.com/media/catalog/product/h/h/hh-30-chu-de-tu-vung-tieng-anh_1.jpg', 'Sach cho nguoi yeu tieng anh');

alter table books drop constraint books_ibfk_1;
alter table books drop constraint books_ibfk_2;
alter table books drop column category_id;
alter table books modify column author varchar(255);

# # Author: (Đã bỏ bảng tác giả)
# drop table author;
# select * from author;
# insert into author values (1,'yolo','2000-08-12','Viet Nam','');
# insert into author values (2,'yolo2','2000-08-12','Viet Nam','')
# Category:
select * from category;
insert into category values (1,'Khoa học viễn tưởng','Thể loại hành động không có thực');
delete from category where id = 1;
insert into category(id, type, description) VALUE (1, 'Chinh tri - phap luat', 'danh cho nhung chinh tri gia');
insert into category(id, type, description) VALUE (2, 'Khoa hoc cong nghe - Kinh te', 'danh cho hoc sinh, sinh vien, ...');
insert into category(id, type, description) VALUE (3, 'Van hoc nghe thuat', 'danh cho nhung nguoi dam me nghe thuat');
insert into category(id, type, description) VALUE (4, 'Van hoa hoi - lich su', 'danh cho nhung nguoi yeu lich su');
insert into category(id, type, description) VALUE (5, 'Giao trinh', 'danh cho hoc sinh, sinh vien');
insert into category(id, type, description) VALUE (6, 'Truyen, tieu thuyet', 'danh cho nhung nguoi dam me truyen');
insert into category(id, type, description) VALUE (7, 'Tam ly, tam linh, ton giao', 'danh cho nhung nguoi yeu tim');
insert into category(id, type, description) VALUE (8, 'Thieu nhi', 'danh cho tre con');
# Customer:
select * from customer;
select * from customer where account = 'admin' and password = 'admin';
alter table customer add column status varchar(255) default 'ACTIVATE';

select * from customer where name like '%d%';
insert into customer values (1,'adm',18,'Nam','HN','012345678','abcxyz@gmail.com','bay','123456','2000-08-12','ACTIVATE');
# Orders:
insert into orders values (1,1,'2022-08-30');
insert into orders values (2,2,'2022-09-30');
select * from ordersdetail;
insert into ordersdetail (orders_id, book_id, quantity) values (1,1,3);
insert into ordersdetail (orders_id, book_id, quantity) values (2,1,3);
insert into ordersdetail (orders_id, book_id, quantity) values (2,2,1);
insert into ordersdetail (orders_id, book_id, quantity) values (2,3,2);
# Cart
select name,author,price,image,o.quantity,sum(price*quantity) as 'tong'
from books
join ordersdetail o on books.id = o.book_id
join orders o2 on o2.id = o.orders_id
where customer_id = 80
group by name;
# Xử lý lại database;
drop table orders;
drop table ordersdetail;
# Book:
select * from books;
alter table books add column status varchar(255) default 'ACTIVATE';

select *from ordersdetail;