INSERT INTO `product` (`productID`, `product_name`, `product_type`, `image`, `description`, `stock`, `price`, `gender`)
VALUES
(1, 'Black Lion Bracelet', 'Bracelet', 'Bracelet1.jpg', 'Several spherical black beads surrounding a single black lion bead.', 50, 19.99, 'Unisex'),
(2, 'Diamond Bracelet', 'Bracelet', 'Bracelet2.jpg', 'Silver bracelet with microscopic diamonds placed carefully on one side of the two silver ends.', 50, 499.99, 'Unisex');

INSERT INTO `user` (`userID`, `name`, `email`, `password`, `roles`)
VALUES (1, 'test', 'test', '$2a$10$wszwmsVUhEJYvpm07jcX8uzrdbUrm5ipJZy5TBJW5yGLuBuxc4A76', 'USER');


INSERT INTO `past_order` (`orderID`, `order_number`, `userID`, `productID`, `quantity`, `price`, `status`)
VALUES (1, '0', '1', '1', '0', '0', 'processing');
INSERT INTO `prod_seq` (`next_val`)
VALUES (3);
INSERT INTO `user_seq` (`next_val`)
VALUES (2);
INSERT INTO `orde_seq` (`next_val`)
VALUES (2);
INSERT INTO `bask_seq` (`next_val`)
VALUES (2);
