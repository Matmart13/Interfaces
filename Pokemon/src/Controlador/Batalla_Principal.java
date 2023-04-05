package Controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import java.awt.Button;
import java.awt.Image;
import java.io.IOException;
import javafx.scene.control.ProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import save.SaveGame;
import javax.swing.JLabel;

public class Batalla_Principal {
//variables

    Sinvida sv;
    static public int turno = 0;
    static public int contmuert = 0;
    static public int contmuert1 = 0;
    static public int pok_act_1, pok_act_2;
    static int seleccion;
    ImageIcon vaporeon = new ImageIcon("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\Imagenes Pokemon\\vaporeon.gif");
    ImageIcon charmander = new ImageIcon("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\Imagenes Pokemon\\charmender.gif");
    ImageIcon piplup = new ImageIcon("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\Imagenes Pokemon\\piplup.gif");
    ImageIcon arcanine = new ImageIcon("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\Imagenes Pokemon\\arcanine.gif");
    ImageIcon lumineon = new ImageIcon("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\Imagenes Pokemon\\lumineon.gif");
    ImageIcon Typhlosion = new ImageIcon("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\Imagenes Pokemon\\Typhlosion.gif");
    Pokemon J1[] = {new P_Agua("Vaporeon", 207, 139, true, vaporeon),
        new P_Fuego("Charmander", 118, 116, true, charmander),
        new P_Fuego("Arcanine", 207, 150, true, arcanine)};
    Pokemon J2[] = {new P_Agua("Lumineon", 170, 142, true, lumineon),
        new P_Agua("Piplup", 142, 112, true, piplup),
        new P_Fuego("Typhlosion", 223, 186, true, Typhlosion)};
    static int pociones1 = 5;
    static int superpocion1 = 2;
    static int pociones2 = 5;
    static int superpocion2 = 2;
    static int mochila;

    /*
		Pokemon Charmander = new P_Fuego("Charmander", 118, 116, true);
		Pokemon Piplup = new P_Agua("Piplup", 142, 112, true);
		Pokemon Arcanine = new P_Fuego("Arcanine", 207, 227, true);
		Pokemon Bulbasur = new P_Hoja("Bulbasaur", 128, 118, true);
		Pokemon Onix = new P_Tierra("Seismitoad", 233, 188, true);
		
		Pokemon Lumineon = new P_Agua("Lumineon", 170, 142, true);
		Pokemon Charmoleon = new P_Fuego("Charmeleon", 151, 158, true);
		Pokemon Oshawott = new P_Agua("Oshawott", 146, 117, true);
		Pokemon Entei = new P_Fuego("Typhlosion", 223, 186, true);
		Pokemon Sceptile   = new P_Hoja("Serperior", 235, 251, true);
		Pokemon Barboach = new P_Tierra("Rydhon", 223, 222, true);

//Poner los pokemon en el array
	
		J1[1] = Charmander;
		J1[2] = Piplup;
		J1[3] = Arcanine;
		J1[4] = Bulbasur;
		J1[5] = Onix;
		
		J2[0] = Lumineon;
		J2[1] = Charmoleon;
		J2[2] = Oshawott;
		J2[3] = Entei;
		J2[4] = Sceptile;
		J2[5] = Barboach;
     */
//M�todo Main
    public static void main(String[] args) {
        Inicio1 ini = new Inicio1();
        ini.setVisible(true);

    }

//Metodo cambiar pokemon
    public void cambiarPokemon(JProgressBar j1, JLabel l1, JButton b1, JButton b2, JButton b3, JButton b5) {
        turno(b1, b2, b3, b5);
        muerteJ1();
        if (turno == 0) {
            if (pok_act_1 == 2) {
                pok_act_1 = -1;
            }

            pok_act_1 = pok_act_1 + 1;
            j1.setValue(J1[pok_act_1].getPh());
            l1.setIcon(J1[pok_act_1].getImagen());
            if (J2[pok_act_2].getPh() <= 0) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b5.setEnabled(true);

            }
            cambiar_turno();
        } else {
            cambiar_turno();
        }
    }

    public void cambiarPokemon1(JProgressBar j2, JLabel l2, JButton b1, JButton b2, JButton b3, JButton b5) {
        turno(b1, b2, b3, b5);
        muerteJ2();
        if (turno == 1) {
            if (pok_act_2 == 2) {
                 pok_act_2 = -1;
            }

            if (J1[pok_act_1].getPh() <= 0) {
                b1.setEnabled(false);
                b2.setEnabled(true);
                b3.setEnabled(false);
                b5.setEnabled(false);

            }

            pok_act_2 = pok_act_2 + 1;
            j2.setValue(J2[pok_act_2].getPh());
            l2.setIcon(J2[pok_act_2].getImagen());
            cambiar_turno();
        } else {
            cambiar_turno();
        }
    }

//Metodo turno dice el turno de quien es 
    public void turno(JButton b1, JButton b2, JButton b3, JButton b5) {
        if (turno == 0) {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(true);
            b5.setEnabled(true);

        } else {
            turno = 1;

            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(false);
            b5.setEnabled(false);

        }
    }
//Metodo cambiar turno cambia el turno

    public void cambiar_turno() {
        if (turno == 0) {
            turno = turno + 1;

        } else if (turno == 1) {
            turno = turno - 1;

        }
    }

    public void añadirPok() {

    }
//Creacion de la funcion batalla_ataque 
//Pide dos parametros tipo Pokemon

    public void batalla_ataque1(JProgressBar j1, JButton b1, JButton b2, JButton b3, JButton b4) {
        //Si es el turno del jugador 1 ataca al jugador dos e imprime el nombre del pokemon con el que ha atacado
        //p1.atacar(p2, p1.getfuerza());
        turno(b1, b2, b3, b4);
        if (turno == 0) {
            muerteJ1();
            J1[pok_act_1].atacar(J2[pok_act_2], J1[pok_act_1].getfuerza());
            j1.setValue(J2[pok_act_2].getPh());
            if (J2[pok_act_2].getPh() <= 0) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(true);

            }
            cambiar_turno();
        } else {

            cambiar_turno();
        }

    }

    public void batalla_ataque2(JProgressBar j2, JButton b1, JButton b2, JButton b3, JButton b4) {
        //Si es el turno del jugador 2 ataca al jugador uno  e imprime el nombre del pokemon con el que ha atacado
        turno(b1, b2, b3, b4);
        if (turno == 1) {
            muerteJ2();
            J2[pok_act_2].atacar(J1[pok_act_1], J2[pok_act_2].getfuerza());
            j2.setValue(J1[pok_act_1].getPh());
            if (J1[pok_act_1].getPh() <= 0) {
                b1.setEnabled(false);
                b2.setEnabled(true);
                b3.setEnabled(false);
                b4.setEnabled(false);

            }
            cambiar_turno();
        } else {
            cambiar_turno();
        }

    }

//Metodo para ver el estado de los pokemons actuales 
//Pide dos objetos pokemon
/*
static void ver_statcolus_batalla(Pokemon p1, Pokemon p2) {
	System.out.println("--------------------------------------------------------");
	if (turno ==0) {
		System.out.println(p2.getNombre()+" "+ p2.getPh()+" "+p2.isEstado());
	}else {
	System.out.println(p1.getNombre() +" " + p1.getPh()+" "+p1.isEstado());
	}
	System.out.println("--------------------------------------------------------");
}
     */
// Metodo que imprime turno del jugador 
    void imprimir_turno_jugador() {
        System.out.println("Turno del jugador " + turno);
    }
//Este metodo sirve para que haya un segundo de delay

    void esperar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
//Metodo que imprime el menu

    void menu() {
        System.out.println("Que quiere hacer ? ");
        System.out.println("1)Ataque \t 2)Cambiar ");
        System.out.println("3)Bolsa \t 4) Huir");
    }
//Metodo que imprime el menu principal

    void menuPrincipal() {
        System.out.println("\t \t Bienviendo a POKEMON_01_JAVA");
        System.out.println("------------------------------------------------------");
        System.out.println("Empieza la batalla con  " + J1[pok_act_1].getNombre() + " vs " + J2[pok_act_1].getNombre());
        System.out.println("Empieza el jugador 1");
        esperar();
    }
//Metodo donde se desarrolla la mochila 

    void mochila() {
        if (turno == 0) {
            System.out.println("1) " + pociones1 + " pocion normal (Incrementa la salud del pokemon actual en 10 ph) \t 2) " + superpocion1 + " superpocion (Incrementa la salud del pokemon en 20 ph \n"
                    + "3)Salir ");

            int pokemon = J1[pok_act_1].getPh();
            switch (mochila) {
                case 1:
                    if (pociones1 != 0) {
                        J1[pok_act_1].setph(J1[pok_act_1].getPh() + 10);
                        System.out.println("La vida de " + J1[pok_act_1].getNombre() + " pasa de " + pokemon + " ph a " + J1[pok_act_1].getPh() + " ph.");
                        pociones1--;
                        esperar();
                        break;
                    } else {
                        System.out.println("Listillo que no tienes pociones");
                        break;
                    }

                case 2:
                    if (superpocion1 != 0) {
                        J1[pok_act_1].setph(J1[pok_act_1].getPh() + 20);
                        System.out.println("La vida de " + J1[pok_act_1].getNombre() + " pasa de " + pokemon + " ph a " + J1[pok_act_1].getPh() + " ph.");
                        superpocion1--;
                        break;
                    } else {
                        System.out.println("JAJAJAJA que no te quedan");

                    }
                case 3:
                    break;
            }
            esperar();
        } else {
            System.out.println("1) " + pociones2 + " pocion normal (Incrementa la salud del pokemon actual en 10 ph) \t 2) " + superpocion2 + " superpocion (Incrementa la salud del pokemon en 20 ph \n "
                    + "3)Salir ");

            int pokemon1 = J2[pok_act_2].getPh();
            switch (mochila) {
                case 1:
                    if (pociones2 != 0) {
                        J2[pok_act_2].setph(J2[pok_act_2].getPh() + 10);
                        System.out.println("La vida de " + J2[pok_act_2].getNombre() + " pasa de " + pokemon1 + " ph a " + J2[pok_act_2].getPh() + " ph");
                        pociones2--;
                        break;
                    } else {
                        System.out.println("Listillo que no tienes pociones");
                        break;
                    }
                case 2:
                    if (superpocion2 != 0) {
                        J2[pok_act_2].setph(J2[pok_act_2].getPh() + 20);
                        System.out.println("La vida de " + J2[pok_act_2].getNombre() + " pasa de " + pokemon1 + " ph a  " + J2[pok_act_2].getPh() + "ph ");
                        superpocion2--;
                        break;
                    } else {
                        System.out.println("JAJAJAJA que no te quedan");
                    }
                case 3:
                    break;
            }
            esperar();

        }
    }
//En este metodo se desarrolla el juego 

    /*
 void juego() {
	do {
		menu();
		seleccion=sc.nextInt();
		switch (seleccion) {
		case 1:
			
			if(turno ==0) {
			if(J1[pok_act_1].isEstado()==true) {
				batalla_ataque((Pokemon)J1[pok_act_1], (Pokemon)J2[pok_act_2]);
				esperar();
				ver_status_batalla((Pokemon)J1[pok_act_1], (Pokemon)J2[pok_act_2]);
				cambiar_turno();
				esperar();
			}else {
				System.out.println("Tienes que cambiar de pokemon");
			}
			}else if(J2[pok_act_2].isEstado()==true){
			 
				batalla_ataque((Pokemon)J1[pok_act_1],(Pokemon)J2[pok_act_2]);
				esperar();
				ver_status_batalla((Pokemon)J1[pok_act_1], (Pokemon)J2[pok_act_2]);
				cambiar_turno();
				esperar();
			}else {
				System.out.println("Tienes que cambiar de pokemon");
			}
			break;
		case 2:
			int seleccion2 = 0;
			Pokemon clon[] = J1.clone();
			Pokemon clon2[] = J2.clone();
			esperar();
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Nombre " + " Vida " + " Da�o " + " Estado");
			if (turno == 0) {
				for (int i = 0; i < J1.length; i++) {
					System.out.println(J1[i].getNombre() + " |" + J1[i].getPh() + " |" + J1[i].getfuerza() + " |" + J1[i].isEstado());	
				}
				System.out.println("Cual eliges?");
				seleccion2 = sc.nextInt();
				J1[0] = J1[seleccion2];
				J1[seleccion2] = clon[0];
				System.out.println("------------------------------------------------------------------------------");
				esperar();
				break;
			}else {
				for (int i = 0; i < J2.length; i++) {
					System.out.println(J2[i].getNombre() + " " + J2[i].getPh() + " " + J2[i].getfuerza() + " " + J2[i].isEstado());	
				}
				System.out.println("Cual eliges?");
				seleccion2 = sc.nextInt();
				J2[0] = J2[seleccion2];
				J2[seleccion2] = clon2[0];
				System.out.println("------------------------------------------------------------------------------");
				esperar();
				break;
			}
		case 3:
			esperar();
			mochila();
			break;
		}
	} while (seleccion != 4);
}
     */
//Imprime el fin del juego 
    void findeljuego() {
        System.out.println("Ha finalizado el combate");
        System.out.println("\r\n"
                + "               _,........__\r\n"
                + "            ,-'            \"`-.\r\n"
                + "          ,'                   `-.\r\n"
                + "        ,'                        \\\r\n"
                + "      ,'                           .\r\n"
                + "      .'\\               ,\"\".       `\r\n"
                + "     ._.'|             / |  `       \\\r\n"
                + "     |   |            `-.'  ||       `.\r\n"
                + "     |   |            '-._,'||       | \\\r\n"
                + "     .`.,'             `..,'.'       , |`-.\r\n"
                + "     l                       .'`.  _/  |   `.\r\n"
                + "     `-.._'-   ,          _ _'   -\" \\  .     `\r\n"
                + "`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\r\n"
                + ".'        `\"-..___      __,'\\          \\  \\     \\\r\n"
                + "\\_ .          |   `\"\"\"\"'    `.           . \\     \\\r\n"
                + "  `.          |              `.          |  .     L\r\n"
                + "    `.        |`--...________.'.        j   |     |\r\n"
                + "      `._    .'      |          `.     .|   ,     |\r\n"
                + "         `--,\\       .            `7\"\"' |  ,      |\r\n"
                + "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\r\n"
                + "             \\ `.     .          /      |  '      |  ,'          `.\r\n"
                + "              \\  v.__  .        '       .   \\    /| /              \\\r\n"
                + "               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\r\n"
                + "                `        .        `._ ___,j.  `/ .-       ,---.     |\r\n"
                + "                ,`-.      \\         .\"     `.  |/        j     `    |\r\n"
                + "               /    `.     \\       /         \\ /         |     /    j\r\n"
                + "              |       `-.   7-.._ .          |\"          '         /\r\n"
                + "              |          `./_    `|          |            .     _,'\r\n"
                + "              `.           / `----|          |-............`---'\r\n"
                + "                \\          \\      |          |\r\n"
                + "               ,'           )     `.         |\r\n"
                + "                7____,,..--'      /          |\r\n"
                + "                                  `---.__,--.'");
        System.out.println("Enrique poh favo,  Vamoh a calmarno");
    }

    private static void ver_status_batalla(Pokemon pokemon, Pokemon pokemon0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void guardarPartidaCompleta() {
        SaveGame save;
        save = new SaveGame(J1, J2, turno, pok_act_1, pok_act_2);
        try {

            FileOutputStream fos = new FileOutputStream("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\save\\pokemon.bin");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(save);
            }
        } catch (IOException e) {
            
        }
    }

    public void cargarPartidaCompleta() {
        try {
            SaveGame save = new SaveGame();
            FileInputStream fis = new FileInputStream("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\JavaFX\\Pokemon\\src\\save\\pokemon.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            save = (SaveGame) ois.readObject();
            pok_act_1 = save.getP1_act();
            pok_act_2 = save.getP2_act();
            J1 = save.getP1();
            J2 = save.getP2();
            turno = save.getTurno();
            ois.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     public  Pokemon[] cargarPokemon(){
        try {
                        
            FileInputStream fis = new FileInputStream("src\\save\\pokemon.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);        
            Pokemon[] p1 = new Pokemon[2];
            p1 = (Pokemon[]) ois.readObject();
            ois.close();
            for (Pokemon pokemon : p1) {
               pokemon.getImagen();
               pokemon.getNombre();
               pokemon.getPh();
               pokemon.getfuerza();
               pokemon.gettipo_Pokemon();
            }
            
        } catch (Exception e) {
            System.out.println("no carga");
        }
        return J1;
    }
     */
    public void barra(JProgressBar p1, JProgressBar p2) {
        p1.setValue(J1[pok_act_1].getPh());
        p2.setValue(J2[pok_act_2].getPh());
    }
        public void botones(JButton p1, JButton p2, JButton p3, JButton p4) {
            turno(p1, p2, p3, p4);
    }

    public void muerteJ1() {

        if (J1[pok_act_1].getPh() <= 0) {
            contmuert++;
            J1[pok_act_1].setEstado(false);
        }

        if (contmuert == J1.length) {
            Fin f = new Fin();
            f.setVisible(true);
        }

    }

    public void muerteJ2() {

        int i;

        if (J2[pok_act_2].getPh() <= 0) {
            contmuert1++;
        }

        if (contmuert1 == J2.length) {
            Fin f = new Fin();
            f.setVisible(true);

        }
    }

}
