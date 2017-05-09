package module2.t2;

public abstract class Chancery {
    private String manufactor;
    private String model;
    private double price;

    public Chancery(String manufactor, String model, double price) {
        this.manufactor = manufactor;
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getManufactor() {
        return manufactor;
    }

    public String getModel() {
        return model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Type: " + super.toString() + ", manufactor: " + manufactor + ", model: " + model + ", price: " + price;
    }

    @Override
    public int hashCode() {
        return (int) (price * 21) + ((null == manufactor) ? 0 : manufactor.hashCode())
                + ((null == model) ? 0 : model.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;
        Chancery chancery = (Chancery) obj;
        if ((manufactor == chancery.manufactor)
                && ((model == chancery.model))
                && (price == chancery.price)) return true;
        return false;
    }
}
