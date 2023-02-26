CREATE TABLE user
(
    userID   int(11) NOT NULL AUTO_INCREMENT,
    name     text    NOT NULL,
    email    text    NOT NULL,
    password text    NOT NULL,
    roles    varchar(255) DEFAULT NULL,
    PRIMARY KEY (userID)
);
CREATE TABLE product (
                         productID int(11) NOT NULL AUTO_INCREMENT,
                         product_name text NOT NULL,
                         product_type text NOT NULL,
                         image text NOT NULL,
                         description longtext NOT NULL,
                         stock int(11) NOT NULL,
                         price double NOT NULL,
                         gender text NOT NULL,
                         PRIMARY KEY (productID)
);

CREATE TABLE basket (
                          basketID int(11) NOT NULL AUTO_INCREMENT,
                          userID int(11) NOT NULL,
                          productID int(11) NOT NULL,
                          quantity int(11) NOT NULL,
                          price int(11) NOT NULL,
                          PRIMARY KEY (basketID)
);



CREATE TABLE past_order(
                              orderID int(11) NOT NULL AUTO_INCREMENT,
                              order_number int(11) NOT NULL,
                              userID int(11) NOT NULL,
                              productID int(11) NOT NULL,
                              quantity int(11) NOT NULL,
                              price int(11) NOT NULL,
                              status text NOT NULL,
                              PRIMARY KEY(orderID)
);
CREATE TABLE `prod_seq` (
    `next_val` bigint(20) DEFAULT NULL
);
CREATE TABLE `bask_seq` (
    `next_val` bigint(20) DEFAULT NULL
);
CREATE TABLE `orde_seq` (
    `next_val` bigint(20) DEFAULT NULL
);
CREATE TABLE `user_seq` (
    `next_val` bigint(20) DEFAULT NULL
);





ALTER TABLE basket
    ADD FOREIGN KEY (userID) REFERENCES user(userID);
ALTER TABLE basket
    ADD FOREIGN KEY (productID) REFERENCES product(productID);


ALTER TABLE past_order
    ADD FOREIGN KEY (userID) REFERENCES user(userID);
ALTER TABLE past_order
    ADD FOREIGN KEY (productID) REFERENCES product(productID);

