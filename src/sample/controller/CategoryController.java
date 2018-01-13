package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.service.RestService;
import sample.model.Category;
import sample.model.Product;

import java.io.IOException;

public class CategoryController {

    @FXML
    private TextField name;

    @FXML
    private TextArea info;

    @FXML
    private ListView<Product> productListView;

    @FXML
    public void create() {
        Category category = new Category();
        category.setName(name.getText());
        category.setInfo(info.getText());
        category.setProducts(productListView.getItems());

        RestService.persistCategory(category);
    }

    public void addProduct() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/page/product.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent, 500, 500);

        stage.setScene(scene);
        stage.setTitle("product");
        stage.setResizable(false);


        Runnable runnable = () -> {
            ProductController controller = loader.getController();
            controller.setCategoryProduct(true);
            controller.setCategoryName(name.getText());

            stage.showAndWait();

            Product product;

            if ((product = controller.getProduct()) != null) {
                ObservableList<Product> products = productListView.getItems();
                products.add(product);
                productListView.setItems(products);
            }

            stage.close();
        };

        new Thread(runnable).run();

    }
}
