package Catalog;

import java.util.Date;

public class Data {
    private Date data;

    public Data(String data) {
        this.data = new Date(data);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
