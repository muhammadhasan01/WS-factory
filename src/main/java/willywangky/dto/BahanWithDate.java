package willywangky.dto;

import willywangky.model.Bahan;

public class BahanWithDate extends Bahan {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString() +
                "date='" + date + '\'' +
                " || ";
    }
}
