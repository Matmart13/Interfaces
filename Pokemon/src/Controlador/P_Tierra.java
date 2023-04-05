package Controlador;

import Controlador.Pokemon;
import java.awt.Image;
import javax.swing.ImageIcon;

public class P_Tierra extends Pokemon {

    P_Tierra(String nombre, int ph, int fuerza, boolean estado, ImageIcon imagen) {
        super(nombre, ph, fuerza, estado, imagen);
        super.settipo_Pokemon(tipo.Tierra);
    }
}
