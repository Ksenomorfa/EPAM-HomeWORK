package module2.t1;

/*
TASK: Разработайте спецификацию и создайте класс Ручка (Pen).
Определите в этом классе методы equals(), hashCode() и toString().
 */
public class Pen {
    private String manufactor;
    private String model;
    private double price;

    @Override
    public String toString() {
        return "Pen manufactor: " + manufactor + ", model: " + model + ", price: " + price;
    }
    @Override
    public int hashCode(){
        return (int)(price*21)+ ((null == manufactor) ? 0 : manufactor.hashCode())
                              + ((null == model)? 0 :model.hashCode());
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(null==obj) return false;
        if(getClass()!=obj.getClass()) return false;
        Pen pen = (Pen)obj;
        if ((manufactor==pen.manufactor)
                &&((model==pen.model))
                &&(price==pen.price)) return true;
        return false;
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

    public double getPrice() {
        return price;
    }

    public String getManufactor() {
        return manufactor;
    }

    public String getModel() {
        return model;
    }
}
