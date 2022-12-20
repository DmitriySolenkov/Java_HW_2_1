import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        VendingMachine vendingMachine= new VendingMachine();
        vendingMachine.addProduct(1, "Чипсы Лейс краб", 100, 5);
        vendingMachine.addProduct(2, "Шоколад Риттер Спорт с миндалем", 200, 5);
        vendingMachine.addProduct(3, "Жвачка Орбит", 50, 10);
        work(vendingMachine);
        // vendingMachine.getInfo();
        // vendingMachine.buyProduct(2, 3);
    }

    public static void work(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для просмотра перечня товаров введите 1");
            System.out.println("Для покупки товара введите 2");
            System.out.print("Для выхода из аппарата введите 3: ");
            String mode=scanner.nextLine();
            if (mode.equals("1")){
                vendingMachine.getInfo();
            }
            if (mode.equals("2")){
                buy(vendingMachine); 
            }
            if (mode.equals("3")){
                break; 
            }
                        
        }
        
    }

    public static void buy(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        int id= 0;
        while (true){
            System.out.println("Введите код товара:");
            String IDString=scanner.nextLine();
            try {
                id = Integer.parseInt(IDString);
                break;
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
        int amount= getBuyAmount();
        while (amount>vendingMachine.getQuanty(id)){
            System.out.println("В аппарате нет такого количества товара!");
            amount= getBuyAmount();
        } 
            vendingMachine.buyProduct(id,amount);
        
    }

    public static int getBuyAmount() {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество товара:");
            String amountString=scanner.nextLine();
            try {
                int amount = Integer.parseInt(amountString);
                return amount;
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода!");
            }
        }
    }
}
