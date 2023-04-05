/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class ControllerVistaPrincipal implements Initializable {

    @FXML
    private Button Boton_Borrar;
    @FXML
    private TableView<Persona> tabla_persona;   
    @FXML
    private Label etiqueta;
    @FXML
    private TableColumn<Persona, String> col_nombre;
    @FXML
    private TableColumn<Persona, String> col_apellido;
    
    
      ObservableList<Persona> lista ;
    /**
     * Initializes the controller class.
     */
      //crear objeto de Personas
    Persona p1 = new Persona("antonio", "fernandez");
    Persona p2 = new Persona("antonio", "fernandez");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Configuramos las columnas de las tablas
        this.col_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.col_apellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        //Iniciazar la  lista con un elemento aunque no hace falta
        lista = FXCollections.observableArrayList(new Persona("pepe", "romero"));
        lista.add(p1);
        lista.add(p2);
        //añadir a la tabla la lista configurada
        this.tabla_persona.setItems(lista);
    }    

    @FXML
    private void borrar_seleccionado(ActionEvent event) {
        lista.remove(tabla_persona.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void mostrar_texto(MouseEvent event) {
        
        Persona p = tabla_persona.getSelectionModel().getSelectedItem();
        etiqueta.setText(p.getNombre() + " " + p.getApellido());
    }

}
