INSERT INTO product (id, creation_date, name, description, price) VALUES (1, date_sub(sysdate(), interval  1 day), 'Kindle', 'The best kindle ever.', 199.00);
INSERT INTO product (id, creation_date,  name, description, price) VALUES (2, date_sub(sysdate(), interval  1 day), 'Smartphone', 'The best one.', 99.00);

INSERT INTO client (id, name) VALUES (1, 'Amelia');
INSERT INTO client (id, name) VALUES (2, 'Alyssa');

INSERT INTO ordering (id, fk_client, creation_date, total, status) VALUES (1, 1, sysdate(), 100.0, 'WAITING');

INSERT INTO order_item (fk_order, fk_product, product_price, amount) VALUES (1, 1, 5.0, 2);

INSERT INTO category (id, name) VALUES (1, 'Eletronics');