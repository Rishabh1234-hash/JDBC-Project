-- Table for Categories
CREATE TABLE category (
    category_id INT PRIMARY KEY, 
    category_name VARCHAR(255)
);

-- Table for Products
CREATE TABLE products (
    product_id INT PRIMARY KEY, 
    product_name VARCHAR(255),
    category_id INT,
    unit_price DECIMAL(10, 2), 
    stock_quantity INT,
    FOREIGN KEY (category_id) REFERENCES category(category_id) -- Corrected foreign key
);

-- Table for Suppliers
CREATE TABLE suppliers (
    supplier_id INT PRIMARY KEY, 
    supplier_name VARCHAR(255),
    contact_name VARCHAR(255),
    phone_number VARCHAR(15),
    email VARCHAR(255)
);

-- Table for Purchases
CREATE TABLE purchase (
    purchase_id INT PRIMARY KEY, 
    supplier_id INT, 
    product_id INT,
    total_price DECIMAL(10, 2), 
    quantity INT, 
    purchase_date DATE,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id), -- Corrected foreign key
    FOREIGN KEY (product_id) REFERENCES products(product_id)   -- Corrected foreign key
);

-- Table for Sales
CREATE TABLE sales (
    sale_id INT PRIMARY KEY, 
    product_id INT,
    total_amount DECIMAL(10, 2), 
    quantity_sold INT,
    sale_date DATE,
    customer_name VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES products(product_id)  -- Corrected foreign key
);

