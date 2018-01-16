package sample.service;

import org.springframework.web.client.RestTemplate;
import sample.model.Category;
import sample.model.Product;

public class RestService {


    public static void persistProduct(Product product){
        RestTemplate template = new RestTemplate();
        template.postForEntity("http://localhost:8080/management/product/create",product,Product.class);
    }

    public static void persistCategory(Category category){
        RestTemplate template = new RestTemplate();
        template.postForEntity("http://localhost:8080/management/category/create",category,Category.class);
    }
}
