package willywangky.model;

import java.util.List;

public class Resep {
    private String chocolateName;
    private List<Bahan> bahan;

    public String getChocolateName() {
        return chocolateName;
    }

    public void setChocolateName(String chocolateName) {
        this.chocolateName = chocolateName;
    }

    public List<Bahan> getBahan() {
        return bahan;
    }

    public void setBahan(List<Bahan> bahan) {
        this.bahan = bahan;
    }

    @Override
    public String toString() {
        return "Resep{" +
                "chocolateName='" + chocolateName + '\'' +
                ", bahan=" + bahan +
                '}';
    }
}
