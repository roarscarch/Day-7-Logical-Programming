import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class CompanyShares {
    private String symbol;
    private int numberOfShares;
    private Date transactionDateTime;

    public CompanyShares(String symbol, int numberOfShares, Date transactionDateTime) {
        this.symbol = symbol;
        this.numberOfShares = numberOfShares;
        this.transactionDateTime = transactionDateTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }
}

public class StockAccount {
    private String fileName;
    private ArrayList<CompanyShares> companySharesList;

    public StockAccount(String fileName) {
        this.fileName = fileName;
        this.companySharesList = new ArrayList<>();
        // Load existing data from file (if any)
        loadFromFile();
    }

    public double valueOf() {
        double totalValue = 0.0;
        // Implement logic to calculate the total value of the StockAccount
        for (CompanyShares companyShares : companySharesList) {
            // Placeholder logic, replace with actual calculation based on stock prices
            totalValue += companyShares.getNumberOfShares() * getRandomStockPrice();
        }
        return totalValue;
    }

    public void buy(int amount, String symbol) {
        // Implement logic to buy shares
        // Update or create CompanyShares object
        // Update transactionDateTime
        CompanyShares existingShares = findCompanySharesBySymbol(symbol);
        if (existingShares != null) {
            existingShares.numberOfShares += amount;
        } else {
            CompanyShares newShares = new CompanyShares(symbol, amount, new Date());
            companySharesList.add(newShares);
        }
    }

    public void save(String fileName) {
        // Implement logic to save the StockAccount data to a file
        // Use serialization or any preferred format
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(companySharesList);
            System.out.println("StockAccount data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printReport() {
        // Implement logic to print a report of the StockAccount
        // Include details like stock symbols, number of shares, transactionDateTime, etc.
        System.out.println("Stock Report:");
        for (CompanyShares companyShares : companySharesList) {
            System.out.println("Symbol: " + companyShares.getSymbol() +
                    ", Number of Shares: " + companyShares.getNumberOfShares() +
                    ", Transaction DateTime: " + companyShares.getTransactionDateTime());
        }
        System.out.println("Total Portfolio Value: $" + valueOf());
    }

    private void loadFromFile() {
        // Implement logic to load data from file (if any)
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = inputStream.readObject();
            if (object instanceof ArrayList<?>) {
                companySharesList = (ArrayList<CompanyShares>) object;
                System.out.println("StockAccount data loaded successfully.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // Ignore if no data is available or file not found
        }
    }

    private double getRandomStockPrice() {
        // Placeholder method to simulate getting stock prices
        return Math.random() * 100;
    }

    private CompanyShares findCompanySharesBySymbol(String symbol) {
        // Helper method to find CompanyShares by symbol
        for (CompanyShares companyShares : companySharesList) {
            if (companyShares.getSymbol().equals(symbol)) {
                return companyShares;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StockAccount stockAccount = new StockAccount("stock_data.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Buy Shares\n2. Print Report\n3. Save and Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to buy: ");
                    int amount = scanner.nextInt();
                    System.out.print("Enter stock symbol: ");
                    String symbol = scanner.next();
                    stockAccount.buy(amount, symbol);
                    break;
                case 2:
                    stockAccount.printReport();
                    break;
                case 3:
                    stockAccount.save("stock_data.dat");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
