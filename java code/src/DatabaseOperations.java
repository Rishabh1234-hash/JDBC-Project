
import java.sql.*;
import java.util.Scanner;

public class DatabaseOperations {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project";  // Replace with your database name
    private static final String USERNAME = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "sysassysdba";  // Replace with your MySQL password

    private Connection connection;
    private Scanner scanner;

    public DatabaseOperations() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
            scanner = new Scanner(System.in);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Category methods
    public void insertCategory(int categoryId, String categoryName) {
        String query = "INSERT INTO category (category_id, category_name) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, categoryId);
            ps.setString(2, categoryName);
            ps.executeUpdate();
            System.out.println("Category added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(int categoryId, String categoryName) {
        String query = "UPDATE category SET category_name = ? WHERE category_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, categoryName);
            ps.setInt(2, categoryId);
            ps.executeUpdate();
            System.out.println("Category updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCategory(int categoryId) {
        String query = "DELETE FROM category WHERE category_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, categoryId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Category removed successfully.");
            } else {
                System.out.println("Category not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayCategories() {
        String query = "SELECT * FROM category";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Category ID: " + rs.getInt("category_id") + ", Name: " + rs.getString("category_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Product methods
    public void insertProduct(int productId, String productName, int categoryId, double unitPrice, int stockQuantity) {
        String query = "INSERT INTO products (product_id, product_name, category_id, unit_price, stock_quantity) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setInt(3, categoryId);
            ps.setDouble(4, unitPrice);
            ps.setInt(5, stockQuantity);
            ps.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int productId, String productName, int categoryId, double unitPrice, int stockQuantity) {
        String query = "UPDATE products SET product_name = ?, category_id = ?, unit_price = ?, stock_quantity = ? WHERE product_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, productName);
            ps.setInt(2, categoryId);
            ps.setDouble(3, unitPrice);
            ps.setInt(4, stockQuantity);
            ps.setInt(5, productId);
            ps.executeUpdate();
            System.out.println("Product updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(int productId) {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, productId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product removed successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts() {
        String query = "SELECT * FROM products";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id") +
                        ", Name: " + rs.getString("product_name") +
                        ", Category ID: " + rs.getInt("category_id") +
                        ", Unit Price: " + rs.getDouble("unit_price") +
                        ", Stock Quantity: " + rs.getInt("stock_quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supplier methods
    public void insertSupplier(int supplierId, String supplierName, String contactName, String phoneNumber, String email) {
        String query = "INSERT INTO suppliers (supplier_id, supplier_name, contact_name, phone_number, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, supplierId);
            ps.setString(2, supplierName);
            ps.setString(3, contactName);
            ps.setString(4, phoneNumber);
            ps.setString(5, email);
            ps.executeUpdate();
            System.out.println("Supplier added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSupplier(int supplierId, String supplierName, String contactName, String phoneNumber, String email) {
        String query = "UPDATE suppliers SET supplier_name = ?, contact_name = ?, phone_number = ?, email = ? WHERE supplier_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, supplierName);
            ps.setString(2, contactName);
            ps.setString(3, phoneNumber);
            ps.setString(4, email);
            ps.setInt(5, supplierId);
            ps.executeUpdate();
            System.out.println("Supplier updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeSupplier(int supplierId) {
        String query = "DELETE FROM suppliers WHERE supplier_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, supplierId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Supplier removed successfully.");
            } else {
                System.out.println("Supplier not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displaySuppliers() {
        String query = "SELECT * FROM suppliers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Supplier ID: " + rs.getInt("supplier_id") +
                        ", Name: " + rs.getString("supplier_name") +
                        ", Contact Name: " + rs.getString("contact_name") +
                        ", Phone: " + rs.getString("phone_number") +
                        ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        DatabaseOperations dbOps = new DatabaseOperations();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Display menu
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert Category");
            System.out.println("2. Insert Product");
            System.out.println("3. Insert Supplier");
            System.out.println("4. Update Category");
            System.out.println("5. Update Product");
            System.out.println("6. Update Supplier");
            System.out.println("7. Remove Category");
            System.out.println("8. Remove Product");
            System.out.println("9. Remove Supplier");
            System.out.println("10. Display Categories");
            System.out.println("11. Display Products");
            System.out.println("12. Display Suppliers");
            System.out.println("13. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Insert Category
                    System.out.print("Enter Category ID: ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Category Name: ");
                    String categoryName = scanner.nextLine();
                    dbOps.insertCategory(categoryId, categoryName);
                    break;

                case 2: // Insert Product
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Category ID: ");
                    int productCategoryId = scanner.nextInt();
                    System.out.print("Enter Unit Price: ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stockQuantity = scanner.nextInt();
                    dbOps.insertProduct(productId, productName, productCategoryId, unitPrice, stockQuantity);
                    break;

                case 3: // Insert Supplier
                    System.out.print("Enter Supplier ID: ");
                    int supplierId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Supplier Name: ");
                    String supplierName = scanner.nextLine();
                    System.out.print("Enter Contact Name: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    dbOps.insertSupplier(supplierId, supplierName, contactName, phoneNumber, email);
                    break;

                case 4: // Update Category
                    System.out.print("Enter Category ID to update: ");
                    int updateCategoryId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Category Name: ");
                    String newCategoryName = scanner.nextLine();
                    dbOps.updateCategory(updateCategoryId, newCategoryName);
                    break;

                case 5: // Update Product
                    System.out.print("Enter Product ID to update: ");
                    int updateProductId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Product Name: ");
                    String newProductName = scanner.nextLine();
                    System.out.print("Enter New Category ID: ");
                    int newCategoryId = scanner.nextInt();
                    System.out.print("Enter New Unit Price: ");
                    double newUnitPrice = scanner.nextDouble();
                    System.out.print("Enter New Stock Quantity: ");
                    int newStockQuantity = scanner.nextInt();
                    dbOps.updateProduct(updateProductId, newProductName, newCategoryId, newUnitPrice, newStockQuantity);
                    break;

                case 6: // Update Supplier
                    System.out.print("Enter Supplier ID to update: ");
                    int updateSupplierId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Supplier Name: ");
                    String newSupplierName = scanner.nextLine();
                    System.out.print("Enter New Contact Name: ");
                    String newContactName = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    dbOps.updateSupplier(updateSupplierId, newSupplierName, newContactName, newPhoneNumber, newEmail);
                    break;

                case 7: // Remove Category
                    System.out.print("Enter Category ID to remove: ");
                    int removeCategoryId = scanner.nextInt();
                    dbOps.removeCategory(removeCategoryId);
                    break;

                case 8: // Remove Product
                    System.out.print("Enter Product ID to remove: ");
                    int removeProductId = scanner.nextInt();
                    dbOps.removeProduct(removeProductId);
                    break;

                case 9: // Remove Supplier
                    System.out.print("Enter Supplier ID to remove: ");
                    int removeSupplierId = scanner.nextInt();
                    dbOps.removeSupplier(removeSupplierId);
                    break;

                case 10: // Display Categories
                    dbOps.displayCategories();
                    break;

                case 11: // Display Products
                    dbOps.displayProducts();
                    break;

                case 12: // Display Suppliers
                    dbOps.displaySuppliers();
                    break;

                case 13: // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
