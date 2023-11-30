/*
 * 
 * learnt toString ---> we can override it
 * String Builder
 * 
 */


package ObjectOrientedProgramming;
import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }

    @Override
    public String toString() {
        return "Stock Name: " + stockName +
                "\nNumber of Shares: " + numberOfShares +
                "\nShare Price: Rs" + sharePrice +
                "\nStock Value: Rs" + calculateStockValue() + "\n";
    }
}

class StockPortfolio {
    private ArrayList<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Stock stock : stocks) {
            result.append(stock.toString()).append("\n");
        }
        result.append("Total Portfolio Value: $").append(calculateTotalPortfolioValue());
        return result.toString();
    }
}

public class StockProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();

        StockPortfolio stockPortfolio = new StockPortfolio();

        for (int i = 0; i < numberOfStocks; i++) {
            System.out.println("\nEnter details for Stock " + (i + 1));
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Stock Name: ");
            String stockName = scanner.nextLine();
            System.out.print("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Enter Share Price: Rs");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
        }

        System.out.println("\nStock Report:\n");
        System.out.println(stockPortfolio);

        scanner.close();
    }
}
