INSERT INTO users (email, first_name, last_name, password, registred_at, role ) VALUES
    ('a@m.c', 'toni', 'stark', '$2y$10$RwvNmKFAnmWnbM1rX9X8T.QzNlGsAGiUCVOgXNQpJIPx4ZWrPMNF6','2021-12-01',1 );


INSERT INTO categories (title, type, user_id) values ('FOOD',0,1);
INSERT INTO categories (title, type, user_id) values ('SUBSCRIBES',0,1);
INSERT INTO categories (title, type, user_id) values ('MEDIA',0,1);
INSERT INTO categories (title, type, user_id) values ('HEALTH', 0,1);
INSERT INTO categories (title, type, user_id) values ('CAR',0,1);
INSERT INTO categories (title, type, user_id) values ('JOB',1,1);
INSERT INTO categories (title, type, user_id) values ('FREELANCE',1,1);
INSERT INTO categories (title, type, user_id) values ('FREE TIME JOB',1,1);
INSERT INTO categories (title, type, user_id) values ('OLX SELLS',1,1);
INSERT INTO categories (title, type, user_id) values ('PAY BACKS',1,1);
INSERT INTO categories (title, type, user_id) values ('TOYS',1,1);
INSERT INTO categories (title, type, user_id) values ('TAXI',1,1);



INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Freelance.ua', 400.0, 1, 7,'2022-01-13',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Job pay day', 2800.0, 1, 6,'2022-01-12',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Uber Eats pay day', 900.50, 1, 8,'2022-01-11',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Car sell', 4100, 1, 9,'2022-01-10',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('OLX sell TV', 140.25, 1, 9,'2022-01-09',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('OLX sell Sony', 1010.50, 1, 9,'2022-01-09',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Volodymyr pay back', 440, 1, 10,'2022-01-08',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Katia pay back', 880.3, 1, 10,'2022-01-08',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('YouTube', 160, 1, 8,'2022-01-07',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('TikTok', 500, 1, 8,'2022-01-07',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Job', 2000, 1, 6,'2021-12-12',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Job', 2000, 1, 6,'2021-11-12',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Job', 2000, 1, 6,'2021-10-12',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Job', 2000, 1, 6,'2021-09-11',1);


INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Cheese', 12, 0, 1,'2022-01-13',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Gun', 1600, 0, 1,'2022-01-13',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Slices', 40.50, 0, 1,'2022-01-12',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Suspension', 15.2, 0, 5,'2022-01-12',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('RC car', 200, 0, 11,'2022-01-11',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('House gas, water, electricity', 50.5, 0, 3,'2022-01-11',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Spotify', 50.5, 0, 2,'2022-01-10',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('XBOX Series X', 2700, 0, 2,'2022-01-10',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Uber X', 100, 0, 12,'2022-01-09',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('New tires', 600, 0, 5,'2022-01-09',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Water 50L', 50.5, 0, 1,'2022-01-09',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Arm repair', 50.5, 0, 4,'2022-01-08',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Uber X', 20, 0, 12,'2022-01-07',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Kielbaski',200, 0, 1,'2022-01-07',1);
INSERT INTO transactions (title, amount, type, category_id, date, user_id) values ('Youtube Music', 20.4, 0, 2,'2022-01-07',1);






