-- Inserting random categories
INSERT INTO category (category_id, category_name) VALUES 
(1, 'Fruits'),
(2, 'Vegetables'),
(3, 'Beverages'),
(4, 'Dairy'),
(5, 'Snacks');
-- Inserting random products
INSERT INTO products (product_id, product_name, category_id, unit_price, stock_quantity) VALUES 
(1, 'Apple', 1, 1.20, 100),    -- Fruit
(2, 'Banana', 1, 0.50, 150),   -- Fruit
(3, 'Carrot', 2, 0.80, 200),   -- Vegetable
(4, 'Cucumber', 2, 1.00, 80),  -- Vegetable
(5, 'Orange Juice', 3, 3.50, 50), -- Beverage
(6, 'Milk', 4, 2.00, 120),     -- Dairy
(7, 'Cheese', 4, 5.00, 70),    -- Dairy
(8, 'Chips', 5, 1.50, 200),    -- Snack
(9, 'Cookies', 5, 2.50, 180);  -- Snack
-- Inserting random suppliers
INSERT INTO suppliers (supplier_id, supplier_name, contact_name, phone_number, email) VALUES 
(1, 'Fresh Produce Ltd.', 'John Doe', '555-1234', 'contact@freshproduce.com'),
(2, 'Green Veggies Co.', 'Alice Smith', '555-2345', 'support@greenveggies.com'),
(3, 'Juicy Beverages Inc.', 'Bob Brown', '555-3456', 'info@juicybeverages.com'),
(4, 'Dairy Fresh', 'Charlie White', '555-4567', 'sales@dairyfresh.com'),
(5, 'Snack Masters', 'David Green', '555-5678', 'hello@snackmasters.com');
-- Inserting random purchase data
INSERT INTO purchase (purchase_id, supplier_id, product_id, total_price, quantity, purchase_date) VALUES
(1, 1, 1, 120.00, 100, '2025-01-05'),  -- Fresh Produce Ltd. bought Apples
(2, 2, 3, 160.00, 200, '2025-01-06'),  -- Green Veggies Co. bought Carrots
(3, 3, 5, 175.00, 50, '2025-01-07'),   -- Juicy Beverages Inc. bought Orange Juice
(4, 4, 6, 240.00, 120, '2025-01-08'),  -- Dairy Fresh bought Milk
(5, 5, 8, 300.00, 200, '2025-01-09');  -- Snack Masters bought Chips
-- Inserting random sales data
INSERT INTO sales (sale_id, product_id, total_amount, quantity_sold, sale_date, customer_name) VALUES
(1, 1, 12.00, 10, '2025-01-10', 'Emma Johnson'),  -- Sold 10 Apples
(2, 2, 7.50, 15, '2025-01-11', 'Michael Lee'),    -- Sold 15 Bananas
(3, 3, 24.00, 30, '2025-01-12', 'Olivia Wang'),    -- Sold 30 Carrots
(4, 6, 40.00, 20, '2025-01-13', 'James Wilson'),   -- Sold 20 Milk
(5, 8, 50.00, 25, '2025-01-14', 'Sophia Martinez'); -- Sold 25 Chips
