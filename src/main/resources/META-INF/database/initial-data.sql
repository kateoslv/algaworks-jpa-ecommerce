INSERT INTO product (id, name, description, price) VALUES (1, 'Kindle', 'The best kindle ever.', 199.00);
INSERT INTO product (id, name, description, price) VALUES (2, 'Smartphone', 'The best one.', 99.00);

INSERT INTO client (id, name) VALUES (1, 'Amelia');
INSERT INTO client (id, name) VALUES (2, 'Alyssa');

INSERT INTO ordering (id, fk_client, order_date, total, status) VALUES (1, 1, sysdate(), 100.0, 'WAITING');

INSERT INTO order_item (id, fk_order, fk_product, product_price, amount) VALUES (1, 1, 1, 5.0, 2);

INSERT INTO category (id, name) VALUES (1, 'Eletronics');