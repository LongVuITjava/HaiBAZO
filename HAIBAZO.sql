INSERT INTO categories (category_name) 
VALUES('Clothing'),
('Accessories'),
('Outdoor');

INSERT INTO styles (style_name) 
VALUES('Modern'),
('Streetwear'),
('Bohemian'),
('Vintage');

INSERT INTO products (name, description, price, discount, quantity, rating, category_id, style_id) 
VALUES('Áo Trễ Vai', 'AMYYSTORE Áo Kiểu Nữ Phong Cách Tiểu Thư Thanh Lịch', 100.00, 10.00, 50, 4.5, 1, 1),
('Áo babydoll linen', 'kiểu xinh tay phồng tiểu thư công chúa bo thân nơ coquette ngực xinh xắn Kimee', 120.00, 15.00, 30, 4.7, 1, 2),
('Lovito Áo thun', 'Jacquard trơn dễ thương cho nữ', 80.00, 5.00, 20, 4.0, 2, 1),
('Áo Thun Xoắn Eo', 'Cổ Tròn MiSoul BigSize , Áo Cộc Tay BigSize Vạt Chéo', 200.00, 0.00, 10, 4.8, 3, 3);

INSERT INTO sizes (size_name, product_id) 
VALUES('S', 1),
('M', 1),
('L', 1),
('S', 2),
('M', 2),
('L', 2),
('XL', 2),
('S', 3),
('M', 3),
('XL', 4);

INSERT INTO colors (color_name, product_id) 
VALUES('Red',1),
('Green',1),
('Yellow',1),
('Black',2),
('White',2),
('Black',3),
('White',3),
('Green',4);

INSERT INTO users (name, email, password, phone_number) 
VALUES('Long Vũ', 'longvu@gmail.com', '123', '098526642'),
('Văn Đức', 'vanduc@gmail.com', '123', '0951154533');

INSERT INTO orders (total_price, order_status, user_id) 
VALUES(150.00, 'Chưa hoàn thành', 1),
(250.00, 'Hoàn thành', 2);

INSERT INTO order_details (price, quantity, total, order_id, product_id) 
VALUES(100.00, 1, 100.00, 1, 1),
(50.00, 1, 50.00, 1, 2),
(200.00, 1, 200.00, 2, 3);

INSERT INTO reviews (review_content, rating, user_id, product_id) 
VALUES('Sản phẩm rất tốt', 5.0, 1, 1),
('Sản phẩm rất tốt', 4.0, 2, 2);

INSERT INTO product_images (image_url, product_id) 
VALUES('https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvpto3qby2fu3a.webp', 1),
('https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvpto3q1j0c9c8.webp', 1),
('https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvpto3qcj4hl42.webp', 1),
('https://down-vn.img.susercontent.com/file/vn-11134207-7ras8-m0p9hi0p1a0d9b.webp', 2),
('https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lxijgl4di7dl29.webp', 2),
('https://down-vn.img.susercontent.com/file/sg-11134201-7rdyg-lylomn3ezlga54.webp',3),
('https://down-vn.img.susercontent.com/file/sg-11134201-7rdx5-m0nw1d2dlqw5a6.webp',3),
('https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lt7qp9aizrno4c.webp',4);
