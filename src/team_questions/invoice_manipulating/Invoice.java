package team_questions.invoice_manipulating;

/**
 * Created by FreakingM on 11/22/2016.
 */
public class Invoice {
    private int partNumber;
    private String partDescription;
    private int quantity;
    private double price;
    Invoice(int partNumber,String partDescription,int quantity,double price ){
        this.partNumber=partNumber;
        this.partDescription=partDescription;
        this.quantity = quantity;
        this.price = price;
    }
    public void setPartNumber(int partNumber){
        this.partNumber = partNumber;
    }
    public int getPartNumber(){
        return partNumber;
    }
    public void setPartDescription(String partDescription){
        this.partDescription = partDescription;
    }
    public String getPartDescription(){
        return partDescription;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return String.format("%-15d%-20s%-10d%5.2f",partNumber,partDescription,quantity,price);
    }
}
