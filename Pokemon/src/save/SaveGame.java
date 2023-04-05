/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save;

import java.io.Serializable;
import Controlador.Pokemon;

/**
 *
 * @author segundo
 */
public class SaveGame implements Serializable{
    private static final long serialVersionUID = 2L;
    
    private Pokemon[] p1;
    private Pokemon[] p2;
    private int turno;
    private int p1_act;
    private int p2_act;

    public SaveGame(Pokemon[] p1, Pokemon[] p2, int turno, int p1_act, int p2_act) {
        this.p1 = p1;
        this.p2 = p2;
        this.turno = turno;
        this.p1_act = p1_act;
        this.p2_act = p2_act;
    }

    public int getP1_act() {
        return p1_act;
    }

    public void setP1_act(int p1_act) {
        this.p1_act = p1_act;
    }

    public int getP2_act() {
        return p2_act;
    }

    public void setP2_act(int p2_act) {
        this.p2_act = p2_act;
    }
    
    public SaveGame(){
        
    }

    public Pokemon[] getP1() {
        return p1;
    }

    public void setP1(Pokemon[] p1) {
        this.p1 = p1;
    }

    public Pokemon[] getP2() {
        return p2;
    }

    public void setP2(Pokemon[] p2) {
        this.p2 = p2;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
}
