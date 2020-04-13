package tk.zytekaron.jvar.randomizer;

public class Item<T> {
    private double weight;
    private T result;

    public Item(double weight, T result) {
        this.weight = weight;
        this.result = result;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public T getResult() {
        return result;
    }
}