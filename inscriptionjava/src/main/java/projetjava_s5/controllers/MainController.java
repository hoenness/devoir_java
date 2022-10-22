/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import projetjava_s5.service.FunctionController;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class MainController implements Initializable {
  @FXML
    private Button btn_gc;
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_gp;
    @FXML
    private Button btn_LR;
    @FXML
    private Button btn_GE;
    FunctionController function= new FunctionController();
    private String nameController=null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleGC(ActionEvent event) throws IOException {
        nameController="GestionClasse";
        function.changeViews(btn_gc, nameController);
    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        function.closeWindow(btn_exit);
    }

    @FXML
    private void HandleGP(ActionEvent event) throws IOException {
               nameController="GestionProfesseur";
        function.changeViews(btn_gp, nameController);
    }

    @FXML
    private void handleLR(ActionEvent event) throws IOException {
                nameController="ListerProfesseur";
        function.changeViews(btn_LR, nameController);
    }

    @FXML
    private void handleGE(ActionEvent event) throws IOException {
                nameController="GestionEtudiant";
        function.changeViews(btn_GE, nameController);

    }
    
    
}
