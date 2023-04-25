package cart.product.service;

import cart.product.dao.ProductDao;
import cart.product.domain.Product;
import cart.product.dto.ProductDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductListService {
    
    private final ProductDao productDao;
    
    public ProductListService(final ProductDao productDao) {
        this.productDao = productDao;
    }
    
    public List<ProductDto> display() {
        final List<Product> products = this.productDao.findAll();
        return products.stream()
                .map(ProductDto::create)
                .collect(Collectors.toList());
    }
}