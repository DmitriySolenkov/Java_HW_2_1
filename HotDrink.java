public class HotDrink extends Product {
    private int temperature;
    private int volume;

    public HotDrink(String name, int volume, int temperature, int price) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format(" Название: %s| Объем:%d| Температура: %d |Цена: %d ", name, volume, temperature, price);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
