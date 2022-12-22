import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(1, "Чипсы Лейс краб", 100, 5);
        vendingMachine.addProduct(2, "Шоколад Риттер Спорт с миндалем", 200, 5);
        vendingMachine.addProduct(3, "Жвачка Орбит", 50, 10);
        HotDrinksApparate hotDrinksApparate = new HotDrinksApparate();
        hotDrinksApparate.addProduct("Черный чай", 300, 65, 50);
        hotDrinksApparate.addProduct("Черный чай", 500, 65, 70);
        hotDrinksApparate.addProduct("Черный чай", 300, 80, 60);
        hotDrinksApparate.addProduct("Черный чай", 500, 80, 80);
        hotDrinksApparate.addProduct("Каппучино", 300, 65, 120);
        hotDrinksApparate.addProduct("Каппучино", 500, 65, 150);
        hotDrinksApparate.addProduct("Каппучино", 300, 80, 170);
        hotDrinksApparate.addProduct("Каппучино", 500, 80, 220);
        hotDrinksApparate.addProduct("Раф", 300, 65, 250);
        hotDrinksApparate.addProduct("Раф", 500, 65, 300);
        hotDrinksApparate.addProduct("Раф", 300, 80, 400);
        hotDrinksApparate.addProduct("Раф", 500, 80, 500);
        work(vendingMachine, hotDrinksApparate);
    }

    public static void work(VendingMachine vendingMachine, HotDrinksApparate hotDrinksApparate) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для просмотра перечня товаров аппарата с закусками введите 1");
            System.out.println("Для покупки закуски введите 2");
            System.out.println("Для просмотра перечня товаров аппарата с горячими напитками введите 3");
            System.out.println("Для покупки горячего напитка введите 4");
            System.out.print("Для выхода из аппарата введите 5: ");
            String mode = scanner.nextLine();
            if (mode.equals("1")) {
                vendingMachine.getInfo();
            }
            if (mode.equals("2")) {
                buy(vendingMachine);
            }
            if (mode.equals("3")) {
                hotDrinksApparate.getInfo();
            }
            if (mode.equals("4")) {
                buyHotDrink(hotDrinksApparate);
            }
            if (mode.equals("5")) {
                break;
            }

        }

    }

    public static void buy(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while (true) {
            System.out.println("Введите код товара:");
            String IDString = scanner.nextLine();
            try {
                id = Integer.parseInt(IDString);
                if (id > 0 && id < vendingMachine.size() + 1) {
                    break;
                } else {
                    System.out.println("Нет такого кода!");
                }
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
        int amount = getBuyAmount();
        while (amount > vendingMachine.getQuanty(id)) {
            System.out.println("В аппарате нет такого количества товара!");
            amount = getBuyAmount();
        }
        vendingMachine.buyProduct(id, amount);

    }

    public static void buyHotDrink(HotDrinksApparate hotDrinksApparate) {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        boolean check = false;
        while (check == false) {
            System.out.println("Выберите напиток: 1- Черный чай, 2- Каппучино, 3- Раф");
            String nameString = scanner.nextLine();
            try {
                int temp = Integer.parseInt(nameString);
                switch (temp) {
                    case 1:
                        name = "Черный чай";
                        check = true;
                        break;
                    case 2:
                        name = "Каппучино";
                        check = true;
                        break;
                    case 3:
                        name = "Раф";
                        check = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
        int volume = 0;
        boolean check2 = false;
        while (check2 == false) {
            System.out.println("Выберите объем: 1- 300 мл, 2- 500 мл");
            String volumeString = scanner.nextLine();
            try {
                int temp = Integer.parseInt(volumeString);
                switch (temp) {
                    case 1:
                        volume = 300;
                        check2 = true;
                        break;
                    case 2:
                        volume = 500;
                        check2 = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
        int temperature = 0;
        boolean check3 = false;
        while (check3 == false) {
            System.out.println("Выберите температуру: 1- 65 градусов, 2- 80 градусов");
            String temperatureString = scanner.nextLine();
            try {
                int temp = Integer.parseInt(temperatureString);
                switch (temp) {
                    case 1:
                        temperature = 65;
                        check3 = true;
                        break;
                    case 2:
                        temperature = 80;
                        check3 = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
        hotDrinksApparate.buyProduct(name, volume, temperature);

    }

    public static int getBuyAmount() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество товара:");
            String amountString = scanner.nextLine();
            try {
                int amount = Integer.parseInt(amountString);
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("Извините, аппарат закуски не принимает!");
                }
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
    }
}
