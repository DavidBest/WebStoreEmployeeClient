package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.service.RestService;
import sample.model.Category;
import sample.model.Product;

import java.math.BigDecimal;

public class ProductController {

    @FXML
    private TextField name;

    @FXML
    private TextField cost;

    @FXML
    private TextField count;

    @FXML
    private TextArea description;

    @FXML
    private TextField category;

    private boolean isCategoryProduct=false;

    private Product product;

    @FXML
    public void submit(){

        Product product = new Product();
        product.setName(name.getText());
        product.setCost(new BigDecimal(Double.valueOf(cost.getText())));
        product.setCount(Integer.valueOf(count.getText()));
        product.setDescription(description.getText());


        if (isCategoryProduct){
            this.product = product;
        }else {
            product.setCategory(new Category(category.getText()));
            RestService.persistProduct(product);
        }
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }

    public void setCategoryName(String categoryName){
        category.setText(categoryName);
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getCost() {
        return cost;
    }

    public void setCost(TextField cost) {
        this.cost = cost;
    }

    public TextField getCount() {
        return count;
    }

    public void setCount(TextField count) {
        this.count = count;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(TextArea description) {
        this.description = description;
    }

    public TextField getCategory() {
        return category;
    }

    public void setCategory(TextField category) {
        this.category = category;
    }

    public boolean isCategoryProduct() {
        return isCategoryProduct;
    }

    public void setCategoryProduct(boolean categoryProduct) {
        isCategoryProduct = categoryProduct;

        if (categoryProduct)
            category.setDisable(true);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
