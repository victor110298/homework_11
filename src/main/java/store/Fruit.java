package store;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Fruit {
    @SerializedName("type")
    private TypeOfFruit typeOfFruit;
    private int shelfLife;
    private LocalDate date;
    private int price;

    public Fruit(TypeOfFruit typeOfFruit,int shelfLife, LocalDate date, int price) {
       this.typeOfFruit=typeOfFruit;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public TypeOfFruit getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }
}
