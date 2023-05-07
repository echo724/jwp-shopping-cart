package cart.catalog.dto;

public class ProductRequestDTO {
    
    private final String name;
    private final String image;
    private final int price;
    
    public ProductRequestDTO(final String name, final String image, final int price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getImage() {
        return this.image;
    }
    
    public int getPrice() {
        return this.price;
    }
}
