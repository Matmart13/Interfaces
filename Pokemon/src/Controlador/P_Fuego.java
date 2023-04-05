package Controlador;

import Controlador.Pokemon;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class P_Fuego extends Pokemon {

    P_Fuego(String nombre, int ph, int fuerza, boolean estado, ImageIcon imagen) {
        super(nombre, ph, fuerza, estado, imagen);
        super.settipo_Pokemon(tipo.Fuego);
    }

}
