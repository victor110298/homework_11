package store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    private FruitType typeOfFruit;
    private int shelfLife;
    private LocalDate date;
    private int price;
}
