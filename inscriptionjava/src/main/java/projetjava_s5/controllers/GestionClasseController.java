/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projetjava_s5.entities.Classe;
import projetjava_s5.service.FunctionController;
import projetjava_s5.service.GestionClasse;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class GestionClasseController implements Initializable {
    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private TableColumn<Classe, Integer> tv_id;
    @FXML
    private TableColumn<Classe, String> tv_libelle;
    @FXML
    private TextField txt_libelle;
    GestionClasse gc = new GestionClasse();
    @FXML
    private Button btn_home;
    private String nameController = null;

    FunctionController function = new FunctionController();
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_GestionProf;
    @FXML
    private Button btn_List_prof;
    @FXML
    private Button btn_G_Etudiant;
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_GC;

    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Classe> donnee = FXCollections.observableArrayList();
        // TODO
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        donnee.addAll(gc.listerCLasse());
        tv_classe.setItems(donnee);
        tv_classe.refresh();

    }

    @FXML
    private void handleAjouterClasse(ActionEvent event) {
        ObservableList<Classe> donnee = FXCollections.observableArrayList();
        String libelle = txt_libelle.getText();
        Classe classe = new Classe(libelle);
        gc.addClasse(classe);
        donnee.addAll(gc.listerCLasse());
        tv_classe.setItems(donnee);
        tv_classe.refresh();
    }

    @FXML
    private void handlechangeViewHome(ActionEvent event) throws IOException {
        nameController = "Main";
        function.changeViews(btn_home, nameController);
    }

    @FXML
    private void handlechangeViewClasse(ActionEvent event) throws IOException {
        nameController = "GestionClasse";
        function.changeViews(btn_GC, nameController);
    }

    @FXML
    private void handleChangeViewProfesseur(ActionEvent event) throws IOException {
        nameController = "GestionProfesseur";
        function.changeViews(btn_GestionProf, nameController);
    }

    @FXML
    private void handleChangeViewListe(ActionEvent event) throws IOException {
        nameController = "ListerProfesseur";
        function.changeViews(btn_List_prof, nameController);
    }

    @FXML
    private void handleChangeViewEtudiant(ActionEvent event) throws IOException {
        nameController = "GestionEtudiant";
        function.changeViews(btn_G_Etudiant, nameController);
    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        function.closeWindow(btn_exit);
    }

}
