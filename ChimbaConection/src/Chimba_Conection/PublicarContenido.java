package Chimba_Conection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PublicarContenido {
	public static void publicar(ArrayList<Perfil> perfiles) {
	    String contenido = JOptionPane.showInputDialog("Escribe tu publicación:");

	    for (Perfil perfil : perfiles) {
	        perfil.agregarPublicacion(contenido);
	    }
	    JOptionPane.showMessageDialog(null, "Has publicado:\n" + contenido);
	}
}
