package willywangky.model;

public class Bahan {
    private String name;
    private Long amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bahan{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
