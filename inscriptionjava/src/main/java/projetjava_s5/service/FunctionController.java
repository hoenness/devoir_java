/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projetjava_s5.entities.Classe;
import projetjava_s5.service.GestionClasse;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class FunctionController implements Initializable {
    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private TableColumn<Classe, Integer> tv_id;
    @FXML
    private TableColumn<Classe, String> tv_libelle;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField txt_libelle;
    GestionClasse gc = new GestionClasse();
    @FXML
    private Button btn_home;

        @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void changeViews(Button btn, String nameController) throws IOException {
        btn.getScene().getWindow().hide() ;
        Parent root = FXMLLoader.load(getClass().getResource("/views/"+nameController+".fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        public void closeWindow(Button btn) throws IOException {
        Stage stage=(Stage)btn.getScene().getWindow();
        stage.close();
    }


}
