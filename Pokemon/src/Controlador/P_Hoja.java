package Controlador;

import Controlador.Pokemon;
import java.awt.Image;
import javax.swing.ImageIcon;

public class P_Hoja extends Pokemon {

    P_Hoja(String nombre, int ph, int fuerza, boolean estado, ImageIcon imagen) {
        super(nombre, ph, fuerza, estado, imagen);
        super.settipo_Pokemon(tipo.Hoja);
    }

}
