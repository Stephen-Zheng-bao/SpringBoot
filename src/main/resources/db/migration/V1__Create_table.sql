CREATE TABLE user
(
    UserID   int(11) NOT NULL AUTO_INCREMENT,
    Name     text    NOT NULL,
    Email    text    NOT NULL,
    Password text    NOT NULL,
    Roles    varchar(255) DEFAULT NULL,
    PRIMARY KEY (UserID)
);
CREATE TABLE product (
                         ProductID int(11) NOT NULL AUTO_INCREMENT,
                         ProductName text NOT NULL,
                         ProductType text NOT NULL,
                         Image text NOT NULL,
                         Description longtext NOT NULL,
                         Stock int(11) NOT NULL,
                         Price double NOT NULL,
                         Gender text NOT NULL,
                         PRIMARY KEY (ProductID)
);

CREATE TABLE basket (
                          BasketID int(11) NOT NULL AUTO_INCREMENT,
                          UserID int(11) NOT NULL,
                          ProductID int(11) NOT NULL,
                          Quantity int(11) NOT NULL,
                          Price int(11) NOT NULL,
                          PRIMARY KEY (BasketID)
);



CREATE TABLE past_order(
                              OrderID int(11) NOT NULL AUTO_INCREMENT,
                              UserID int(11) NOT NULL,
                              ProductID int(11) NOT NULL,
                              Quantity int(11) NOT NULL,
                              Price int(11) NOT NULL,
                              Status int(11) NOT NULL,
                              PRIMARY KEY(OrderID)
);






ALTER TABLE basket
    ADD FOREIGN KEY (UserID) REFERENCES user(UserID);
ALTER TABLE basket
    ADD FOREIGN KEY (ProductID) REFERENCES product(ProductID);


ALTER TABLE past_order
    ADD FOREIGN KEY (UserID) REFERENCES user(UserID);
ALTER TABLE past_order
    ADD FOREIGN KEY (ProductID) REFERENCES product(ProductID);

