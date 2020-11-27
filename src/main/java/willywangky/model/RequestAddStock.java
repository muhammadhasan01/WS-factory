package willywangky.model;

public class RequestAddStock {
    private Long id;
    private String chocolateName;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChocolateName() {
        return chocolateName;
    }

    public void setChocolateName(String chocolateName) {
        this.chocolateName = chocolateName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RequestAddStock{" +
                "id=" + id +
                ", chocolateName='" + chocolateName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
