CREATE TABLE `basket` (
                          `BasketID` int(11) NOT NULL AUTO_INCREMENT,
                          `UserID` int(11) NOT NULL,
                          `ProductID` int(11) NOT NULL,
                          `Quantity` int(11) NOT NULL,
                          `Price` int(11) NOT NULL,
                          PRIMARY KEY (BasketID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `past_order` (
                              `OrderID` int(11) NOT NULL AUTO_INCREMENT,
                              `UserID` int(11) NOT NULL,
                              `ProductID` int(11) NOT NULL,
                              `Quantity` int(11) NOT NULL,
                              `Price` int(11) NOT NULL,
                              `Status` int(11) NOT NULL,
                              PRIMARY KEY(OrderID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `product` (
                           `ProductID` int(11) NOT NULL AUTO_INCREMENT,
                           `ProductName` text NOT NULL,
                           `ProductType` text NOT NULL,
                           `Image` text NOT NULL,
                           `Description` longtext NOT NULL,
                           `Stock` int(11) NOT NULL,
                           `Price` double NOT NULL,
                           `Gender` text NOT NULL,
                           `ManufactureDate` date NOT NULL,
                           PRIMARY KEY (ProductID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `user` (
                        `UserID` int(11) NOT NULL AUTO_INCREMENT,
                        `Name` text NOT NULL,
                        `Email` text NOT NULL,
                        `Password` text NOT NULL,
                        `Roles` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




ALTER TABLE `basket`
    ADD FOREIGN KEY (`UserID`) REFERENCES user(UserID);
ALTER TABLE `basket`
    ADD FOREIGN KEY (`ProductID`) REFERENCES product(ProductID);

ALTER TABLE `past_order`
    ADD PRIMARY KEY (`OrderID`);

