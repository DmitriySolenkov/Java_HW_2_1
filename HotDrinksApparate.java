import java.util.ArrayList;
import java.util.Scanner;

public class HotDrinksApparate extends VendingMachine {
    private static ArrayList<HotDrink> hotDrinks = new ArrayList<HotDrink>();

    public void addProduct(String name, int volume, int temperature, int price) {
        hotDrinks.add(new HotDrink(name, volume, temperature, price));

    }

    public void getInfo() {
        for (int index = 0; index < hotDrinks.size(); index++) {
            System.out.println(hotDrinks.get(index).toString());

        }
    }

    public void buyProduct(String name, int volume, int temperature) {
        int price = 0;
        for (HotDrink hotDrink : hotDrinks) {
            if (hotDrink.getName().equals(name) && hotDrink.getVolume() == volume
                    && hotDrink.getTemperature() == temperature) {
                price = hotDrink.getPrice();

            }

        }

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
        System.out.format("Возьмите %s объемом %d мл и температурой %d градусов", name, volume, temperature);
        System.out.println();
        if (cash > price) {
            System.out.format("Возьмите сдачу: %d рублей", cash - price);
            System.out.println();
        }

    }
}
