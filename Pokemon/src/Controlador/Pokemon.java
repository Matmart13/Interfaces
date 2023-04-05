package Controlador;

import Controlador.I_Acciones;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Pokemon extends Tipo implements I_Acciones, Serializable{
//Variables

    public int ph;
    public int fuerza;
    public boolean estado;
    public tipo tipo_Pokemon;
    public String nombre;
    public ImageIcon imagen;
    //ConstructSor

    Pokemon(String nombre, int ph, int fuerza, boolean estado, ImageIcon imagen) {
        this.nombre = nombre;
        this.ph = ph;
        this.fuerza = fuerza;
        this.estado = estado;
        this.imagen = imagen;
    }
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public tipo gettipo_Pokemon() {
        return tipo_Pokemon;
    }

    public void settipo_Pokemon(tipo tipo_Pokemon) {
        this.tipo_Pokemon = tipo_Pokemon;
    }

    public int getPh() {
        return ph;
    }

    public void setph(int ph) {
        this.ph = ph;
    }

    public int getfuerza() {
        return fuerza;
    }

    public void setfuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    @Override
    public void atacar(Pokemon Px, int fuerza) {
        Px.ph -= fuerza;
        if (Px.getPh() <= 0) {
            Px.setEstado(false);
        }
    }

    @Override
    public void cambiar() {

    }

}
