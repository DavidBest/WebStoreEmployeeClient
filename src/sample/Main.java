package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import sample.controller.ProductController;
import sample.model.Category;
import sample.model.Product;

import java.math.BigDecimal;
import java.util.Collections;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("page/product.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("page/categoryCreate.fxml"));
        Parent root = loader.load();

//        ProductController controller = loader.getController();
//        controller.setCategoryProduct(true);
//        controller.setCategoryName("cars");

        primaryStage.setTitle("Category");
        primaryStage.setScene(new Scene(root, 600, 353));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

//        Product product = new Product();
//
//        product.setName("opel");
//        product.setCost(new BigDecimal(100000));
//        product.setCount(5);
//        product.setDescription("is car");
//
//        Category c = new Category();
//
//        c.setName("cars");
//        c.setInfo("cars is cars");
//        c.setProducts(Collections.singletonList(product));
////        product.setCategory(c);
//
//        RestTemplate template = new RestTemplate();
//
////        template.delete("http://localhost:8080/management/category/delete?name="+c.getName());
//
//        HttpStatus status = template.postForObject("http://localhost:8080/management/category/create",c, HttpStatus.class);
//        System.out.println(status);
//
//        System.exit(0);


    }
}
