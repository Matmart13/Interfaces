package Controlador;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class P_Agua extends Pokemon {

    P_Agua(String nombre, int ph, int fuerza, boolean estado, ImageIcon imagen) {
        super(nombre, ph, fuerza, estado, imagen);
        super.settipo_Pokemon(tipo.Agua);
    }

}
