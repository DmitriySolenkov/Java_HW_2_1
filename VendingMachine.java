import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Integer> quantities = new ArrayList<Integer>();

    public VendingMachine() {
        super();
    }

    public void getInfo() {
        for (int index = 0; index < products.size(); index++) {
            System.out.println(products.get(index).toString() + "| количество: " + quantities.get(index));

        }
    }

    public int size() {
        return products.size();
    }

    public static void setQuanty(int id, int quanty) {
        quantities.set(id - 1, quanty);
    }

    public void addProduct(int id, String name, int price, Integer quanty) {
        products.add(new Product(id, name, price));
        quantities.add(quanty);

    }

    public int getQuanty(int id) {
        return (quantities.get(id - 1));

    }

    public void buyProduct(int id, int amount) {
        int price = products.get(id - 1).getPrice() * amount;
        System.out.format("C вас %d рублей! ", price);
        int cash = 0;
        Scanner scanner = new Scanner(System.in);
        while (cash < price) {
            System.out.format("Пожалуйста, внесите деньги в приемник! Осталось внести: %d рублей!", price - cash);
            System.out.println();
            String paidString = scanner.nextLine();
            try {
                int paid = Integer.parseInt(paidString);
                if (paid > 0) {
                    cash += paid;
                } else {
                    System.out.println("Нельзя грабить автомат!");
                }
            } catch (Exception e) {
                System.out.println("Сумма указана неверно!");
            }

        }
        setQuanty(id, getQuanty(id) - amount);
        System.out.format("Возьмите %d %s", amount, products.get(id - 1).getName());
        System.out.println();
        if (cash > price) {
            System.out.format("Возьмите сдачу: %d рублей", cash - price);
            System.out.println();
        }
    }

}
