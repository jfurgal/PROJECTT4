public class MerchandiseItem {
    public String taxibleType;
    public String ItemName;
    public String price;

    public  MerchandiseItem(String itemName, String cost, String type){
        ItemName = itemName;
        price = cost;
        taxibleType = type;
    }

    public String getName(){
        return ItemName;
    }

    public String getPrice(){
        return price;
    }

    public String getTaxibleType(){
        return taxibleType;
    }
}
