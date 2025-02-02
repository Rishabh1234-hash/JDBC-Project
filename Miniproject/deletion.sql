-- 1. Delete data from 'sales' (dependent on 'products')
DELETE FROM sales;

-- 2. Delete data from 'purchase' (dependent on 'products' and 'suppliers')
DELETE FROM purchase;

-- 3. Delete data from 'products' (dependent on 'category')
DELETE FROM products;

-- 4. Delete data from 'suppliers'
DELETE FROM suppliers;

-- 5. Delete data from 'category'
DELETE FROM category;

