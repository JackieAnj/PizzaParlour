package a2;

public class Drink {
    private String name;
    private int quantity;
    private int drinkNum;
    private static int drinkCount = 1;

    public Drink(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.drinkNum = drinkCount;
        drinkCount += 1;
        if (drinkCount > 1000) {
            drinkCount = 1;
        }
    }

    @Override
    public String toString() {
        return "Drink #" + drinkNum + " ---> " +
                "name=" + name + "\n" +
                "quantity=" + quantity + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDrinkNum() {
        return drinkNum;
    }
}
