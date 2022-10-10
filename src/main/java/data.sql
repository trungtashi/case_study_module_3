create database bookstore;
use bookstore;

## Thể loại:
create table category
(
    id          int primary key auto_increment,
    type        varchar(255),
    description varchar(255)
);
## Sách
create table books
(
    id          int primary key auto_increment,
    code        varchar(255) not null,
    name        varchar(255) not null,
    author   varchar(255) not null,
    price       double       not null,
    image      varchar(255),
    description nvarchar(255)
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
    address   varchar(255),
    phone     varchar(255) not null,
    email     varchar(255) not null,
    account   varchar(255) not null,
    password  varchar(255) not null,
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
    foreign key (orders_id) references orderS (id),
    book_id   int,
    foreign key (book_id) references books (id),
    quantity  int not null
);
select * from books;
## Thêm sách
insert into books (code, name, author, price, image, description) values
('TT01','Nhà Giả Kim', 'Paulo Coelho',100.000,'http://isach.info/images/story/cover/nha_gia_kim__paulo_coelho.jpg',
'Nhà Giả Kim là tác phẩm nổi tiếng nhất của nhà văn Paulo Coelho, được ra mắt vào năm 1988. Cuốn tiểu thuyết này kể về Santiago - một cậu bé chăn cừu nghèo người Tây Ban Nha, phiêu lưu đến châu Phi để tìm kiếm và thực hiện giấc mơ của mình'),
('TT02','Đắc Nhân Tâm', 'Dale Carnegie',100.000,'https://sachhaymienphi.com/wp-content/uploads/2021/12/sach-dac-nhan-tam-dale-carnegie-sach-hay-mien-phi.jpg',
'Đắc Nhân Tâm là một tác phẩm nổi tiếng của Dale Carnegie - nhà văn người Mỹ, được xuất bản vào năm 1936. Đắc nghĩa là được, Nhân nghĩa là người, Tâm nghĩa là tim, Đắc Nhân Tâm có thể hiểu đơn giản là nghệ thuật thu phục lòng người.'),
('TT03','Cách nghĩ để thành công', 'Napoleon Hill',150.000,'https://images.thuvienpdf.com/BLPutWBfyT.webp',
'Cách Nghĩ Để Thành Công mang tới cho bạn triết lý thành đạt, đồng thời cung cấp phương pháp để bạn lên kế hoạch chi tiết để đạt được thành công đó.'),
('TT04','Quẳng gánh lo đi và vui sống', 'Dale Carnegie',100.000,'https://salt.tikicdn.com/cache/w1200/ts/product/82/dc/7f/71418a942cd3034cb029ee888374a583.jpg',
'Sau Đắc Nhân Tâm, Quẳng Gánh Lo Đi Và Vui Sống là tác phẩm nổi tiếng tiếp theo của Dale Carnegie. Cuốn sách này phân tích và giải đáp những nỗi buồn, lo lắng diễn ra hàng ngày trong cuộc sống của mỗi người.'),
('TT05',' Đọc Vị Bất Kỳ Ai', 'David J.Lieberman',120.000,'https://reviewsach.net/wp-content/uploads/2018/09/Sa%CC%81ch-%C4%91o%CC%A3c-vi%CC%A3-ba%CC%82%CC%81t-ky%CC%80-ai.jpg',
'Đọc Vị Bất Kỳ Ai là một quyển cẩm nang dạy bạn cách thâm nhập vào tâm trí của người khác, để suy đoán được họ đang nghĩ gì. Cuốn sách có nội dung bao gồm 2 phần chính và được chia thành 15 chương.'),
('TT06','Tiểu thuyết Bố Già', 'Mario Puzo',200.000,'https://product.hstatic.net/1000328521/product/bo_gia_thumb_3d_aaed047bdac84a2d887b038d5d9c5b28.jpg',
'Bố Già - có tên tiếng Anh là The Godfather, là cuốn sách hay kinh điển của Mario Puzo được xuất bản vào năm 1969. Nội dung của quyển sách xoay quanh một gia đình mafia gốc Ý với nhân vật chính là ông trùm Vito Corleone'),
('TT07','Cuộc sống không giới hạn', 'Nick Vujicic',60.000,'https://salt.tikicdn.com/cache/w1200/media/catalog/product/u/n/untitled_1_3_6.jpg',
'Như tác giả đã từng nói: “Bạn đẹp đẽ và quý giá hơn tất cả những viên kim cương trên thế gian này. '),
('TT08','Đời Thay Đổi Khi Chúng Ta Thay Đổi', 'Andrew Matthews',500.000,'https://www.nxbtre.com.vn/Images/Book/nxbtre_full_31372020_023745.jpg',
'Đời Thay Đổi Khi Chúng Ta Thay Đổi là một tác phẩm của Andrew Matthews - một họa sĩ vẽ tranh biếm họa, một nhà diễn thuyết tài năng.'),
('TT09','7 Thói Quen Để Thành Đạt', 'Stephen R. Covey',500.000,'https://www.khaitam.com/Data/Sites/1/Product/3345/7-thoi-quen-de-thanh-dat.jpg',
'7 Thói Quen Để Thành Đạt cung cấp cho người đọc những thói quen tạo nên sự khác biệt của người thành công. Steven Covey tin rằng, một người thành công không chỉ cần kỹ năng và kiến thức, mà yếu tố quyết định chính là những thói quen và tính cách của họ.');

## Thêm thể loại sách
select * from category;
insert into category(type, description) values
                                            ('Tình cảm – Romance','Tiểu thuyết lãng mạn có lẽ là một trong số các thể loại sách phổ biến nhất khi so về doanh số bán sách.'),
                                            (' Bí ẩn – Mystery','Nhiều tác phẩm thuộc thể loại sách “bí ẩn” đã và đang tiếp tục thu hút một lượng lớn độc giả trên toàn thế giới, đặc biệt là các ấn phẩm phụ của một bộ truyện lớn hơn.'),
                                            ('Giả tưởng và khoa học viễn tưởng – Fantasy & Science fiction','Sách giả tưởng thường diễn ra trong một khoảng thời gian khác với thời gian hiện tại của chúng ta.'),
                                            ('Kinh dị, giật gân – Thrillers & Horror','Các thể loại sách này bao gồm các ấn phẩm thường có mối liên hệ mật thiết đến những thể loại sách Mystery và đôi khi là giả tưởng – Fantasy'),
                                            ('Sách truyền cảm hứng – Self-help','Các thể loại sách được sáng tác dựa trên các trải nghiệm thực tế này ngày càng tiếp cận được đông đảo khán giả trên toàn thế giới.'),
                                            ('Tiểu sử, tự truyện và hồi ký','Đây là các thể loại sách phi hư cấu dùng để kể những câu chuyện về cuộc đời của một người. Trong trường hợp tự truyện và hồi ký, chủ thể sẽ là tác giả của cuốn sách'),
                                            ('Truyện ngắn – Short Stories','Mặc dù chúng bao gồm các thể loại sách mà chúng tôi mô tả ở đây, truyện ngắn là văn xuôi ngắn gọn, tốt, ngắn hơn đáng kể so với tiểu thuyết.'),
                                            ('Sách dạy nấu ăn – Cookbooks','Các thể loại sách này, theo truyền thống được viết bởi các đầu bếp chuyên nghiệp hoặc thậm chí những người nổi tiếng yêu thích của bạn, sách dạy nấu ăn cung cấp một bộ sưu tập các công thức nấu ăn hấp dẫn.'),
                                            ('Sách lịch sử – History','Người ta thường nói rằng lịch sử là thứ mà chúng ta tạo ra từ nó, tuy nhiên, bây giờ nó có vẻ là một điều rất tao nhã để nói hơn là một điều thực tế.'),
                                            ('Bài luận – Essays','Các thể loại sách này thông thường được viết ở ngôi thứ nhất, người viết sử dụng kinh nghiệm cá nhân của chính họ để phản ánh về một chủ đề hoặc chủ đề cho người đọc.');

## Thêm khách hàng
select * from customer;
insert into customer(name, age, gender, address, phone, email, account, password, startdate) values
                                                                                                 ('Thor',18,'nam','BG','099999999','thor@gmail.com','thethor','123456','2022-10-04'),
                                                                                                 ('Hulk',25,'nam','HN','088888888','hulk@gmail.com','thehulk','123456','2022-10-01');

## Hóa đơn
select * from orders;
insert into orders(customer_id, dateBuy) values
                                             (2,'2022-10-01'),
                                             (1,'2022-10-04');
create database bookstore;
use bookstore;

## Thể loại:
create table category
(
    id          int primary key auto_increment,
    type        varchar(255),
    description varchar(255)
);
## Sách
create table books
(
    id          int primary key auto_increment,
    code        varchar(255) not null,
    name        varchar(255) not null,
    author   varchar(255) not null,
    price       double       not null,
    image      varchar(255),
    description nvarchar(255)
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
    address   varchar(255),
    phone     varchar(255) not null,
    email     varchar(255) not null,
    account   varchar(255) not null,
    password  varchar(255) not null,
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
    foreign key (orders_id) references orderS (id),
    book_id   int,
    foreign key (book_id) references books (id),
    quantity  int not null
);
select * from books;
## Thêm sách
insert into books (code, name, author, price, image, description) values
('TT01','Nhà Giả Kim', 'Paulo Coelho',100.000,'http://isach.info/images/story/cover/nha_gia_kim__paulo_coelho.jpg',
'Nhà Giả Kim là tác phẩm nổi tiếng nhất của nhà văn Paulo Coelho, được ra mắt vào năm 1988. Cuốn tiểu thuyết này kể về Santiago - một cậu bé chăn cừu nghèo người Tây Ban Nha, phiêu lưu đến châu Phi để tìm kiếm và thực hiện giấc mơ của mình'),
('TT02','Đắc Nhân Tâm', 'Dale Carnegie',100.000,'https://sachhaymienphi.com/wp-content/uploads/2021/12/sach-dac-nhan-tam-dale-carnegie-sach-hay-mien-phi.jpg',
'Đắc Nhân Tâm là một tác phẩm nổi tiếng của Dale Carnegie - nhà văn người Mỹ, được xuất bản vào năm 1936. Đắc nghĩa là được, Nhân nghĩa là người, Tâm nghĩa là tim, Đắc Nhân Tâm có thể hiểu đơn giản là nghệ thuật thu phục lòng người.'),
('TT03','Cách nghĩ để thành công', 'Napoleon Hill',150.000,'https://images.thuvienpdf.com/BLPutWBfyT.webp',
'Cách Nghĩ Để Thành Công mang tới cho bạn triết lý thành đạt, đồng thời cung cấp phương pháp để bạn lên kế hoạch chi tiết để đạt được thành công đó.'),
('TT04','Quẳng gánh lo đi và vui sống', 'Dale Carnegie',100.000,'https://salt.tikicdn.com/cache/w1200/ts/product/82/dc/7f/71418a942cd3034cb029ee888374a583.jpg',
'Sau Đắc Nhân Tâm, Quẳng Gánh Lo Đi Và Vui Sống là tác phẩm nổi tiếng tiếp theo của Dale Carnegie. Cuốn sách này phân tích và giải đáp những nỗi buồn, lo lắng diễn ra hàng ngày trong cuộc sống của mỗi người.'),
('TT05',' Đọc Vị Bất Kỳ Ai', 'David J.Lieberman',120.000,'https://reviewsach.net/wp-content/uploads/2018/09/Sa%CC%81ch-%C4%91o%CC%A3c-vi%CC%A3-ba%CC%82%CC%81t-ky%CC%80-ai.jpg',
'Đọc Vị Bất Kỳ Ai là một quyển cẩm nang dạy bạn cách thâm nhập vào tâm trí của người khác, để suy đoán được họ đang nghĩ gì. Cuốn sách có nội dung bao gồm 2 phần chính và được chia thành 15 chương.'),
('TT06','Tiểu thuyết Bố Già', 'Mario Puzo',200.000,'https://product.hstatic.net/1000328521/product/bo_gia_thumb_3d_aaed047bdac84a2d887b038d5d9c5b28.jpg',
'Bố Già - có tên tiếng Anh là The Godfather, là cuốn sách hay kinh điển của Mario Puzo được xuất bản vào năm 1969. Nội dung của quyển sách xoay quanh một gia đình mafia gốc Ý với nhân vật chính là ông trùm Vito Corleone'),
('TT07','Cuộc sống không giới hạn', 'Nick Vujicic',60.000,'https://salt.tikicdn.com/cache/w1200/media/catalog/product/u/n/untitled_1_3_6.jpg',
'Như tác giả đã từng nói: “Bạn đẹp đẽ và quý giá hơn tất cả những viên kim cương trên thế gian này. '),
('TT08','Đời Thay Đổi Khi Chúng Ta Thay Đổi', 'Andrew Matthews',500.000,'https://www.nxbtre.com.vn/Images/Book/nxbtre_full_31372020_023745.jpg',
'Đời Thay Đổi Khi Chúng Ta Thay Đổi là một tác phẩm của Andrew Matthews - một họa sĩ vẽ tranh biếm họa, một nhà diễn thuyết tài năng.'),
('TT09','7 Thói Quen Để Thành Đạt', 'Stephen R. Covey',500.000,'https://www.khaitam.com/Data/Sites/1/Product/3345/7-thoi-quen-de-thanh-dat.jpg',
'7 Thói Quen Để Thành Đạt cung cấp cho người đọc những thói quen tạo nên sự khác biệt của người thành công. Steven Covey tin rằng, một người thành công không chỉ cần kỹ năng và kiến thức, mà yếu tố quyết định chính là những thói quen và tính cách của họ.');

## Thêm thể loại sách
select * from category;
insert into category(type, description) values
                                            ('Tình cảm – Romance','Tiểu thuyết lãng mạn có lẽ là một trong số các thể loại sách phổ biến nhất khi so về doanh số bán sách.'),
                                            (' Bí ẩn – Mystery','Nhiều tác phẩm thuộc thể loại sách “bí ẩn” đã và đang tiếp tục thu hút một lượng lớn độc giả trên toàn thế giới, đặc biệt là các ấn phẩm phụ của một bộ truyện lớn hơn.'),
                                            ('Giả tưởng và khoa học viễn tưởng – Fantasy & Science fiction','Sách giả tưởng thường diễn ra trong một khoảng thời gian khác với thời gian hiện tại của chúng ta.'),
                                            ('Kinh dị, giật gân – Thrillers & Horror','Các thể loại sách này bao gồm các ấn phẩm thường có mối liên hệ mật thiết đến những thể loại sách Mystery và đôi khi là giả tưởng – Fantasy'),
                                            ('Sách truyền cảm hứng – Self-help','Các thể loại sách được sáng tác dựa trên các trải nghiệm thực tế này ngày càng tiếp cận được đông đảo khán giả trên toàn thế giới.'),
                                            ('Tiểu sử, tự truyện và hồi ký','Đây là các thể loại sách phi hư cấu dùng để kể những câu chuyện về cuộc đời của một người. Trong trường hợp tự truyện và hồi ký, chủ thể sẽ là tác giả của cuốn sách'),
                                            ('Truyện ngắn – Short Stories','Mặc dù chúng bao gồm các thể loại sách mà chúng tôi mô tả ở đây, truyện ngắn là văn xuôi ngắn gọn, tốt, ngắn hơn đáng kể so với tiểu thuyết.'),
                                            ('Sách dạy nấu ăn – Cookbooks','Các thể loại sách này, theo truyền thống được viết bởi các đầu bếp chuyên nghiệp hoặc thậm chí những người nổi tiếng yêu thích của bạn, sách dạy nấu ăn cung cấp một bộ sưu tập các công thức nấu ăn hấp dẫn.'),
                                            ('Sách lịch sử – History','Người ta thường nói rằng lịch sử là thứ mà chúng ta tạo ra từ nó, tuy nhiên, bây giờ nó có vẻ là một điều rất tao nhã để nói hơn là một điều thực tế.'),
                                            ('Bài luận – Essays','Các thể loại sách này thông thường được viết ở ngôi thứ nhất, người viết sử dụng kinh nghiệm cá nhân của chính họ để phản ánh về một chủ đề hoặc chủ đề cho người đọc.');

## Thêm khách hàng
select * from customer;
insert into customer(name, age, gender, address, phone, email, account, password, startdate) values
                                                                                                 ('Thor',18,'nam','BG','099999999','thor@gmail.com','thethor','123456','2022-10-04'),
                                                                                                 ('Hulk',25,'nam','HN','088888888','hulk@gmail.com','thehulk','123456','2022-10-01');

## Hóa đơn
select * from orders;
insert into orders(customer_id, dateBuy) values
                                             (2,'2022-10-01'),
                                             (1,'2022-10-04');
