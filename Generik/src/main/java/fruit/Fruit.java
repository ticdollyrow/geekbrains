package fruit;
import lombok.Getter;

abstract public class Fruit {
    @Getter private Float weight;

    public Fruit(float weight){
        this.weight = weight;
    }
}
