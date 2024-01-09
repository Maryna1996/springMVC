CREATE TABLE products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          cost DOUBLE NOT NULL
);


CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        date VARCHAR(255) NOT NULL,
                        cost DOUBLE NOT NULL
);


INSERT INTO products (id, name, cost) VALUES
                                          (1, 'Product 1', 01.01),
                                          (2, 'Product 2', 02.02),
                                          (3, 'Product 3', 03.03),
                                          (4, 'Product 4', 04.04),
                                          (5, 'Product 5', 05.05),
                                          (6, 'Product 6', 06.06),
                                          (7, 'Product 7', 07.07),
                                          (8, 'Product 8', 08.08),
                                          (9, 'Product 9', 09.09),
                                          (10, 'Product 10', 10.10);


INSERT INTO orders (id, date, cost) VALUES
                                        (1, '2022-01-01', (SELECT SUM(cost) FROM products WHERE id IN (1, 2, 3, 4, 5))),
                                        (2, '2022-01-02', (SELECT SUM(cost) FROM products WHERE id IN (6, 7, 8, 9, 10)));