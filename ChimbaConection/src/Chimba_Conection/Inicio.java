package Chimba_Conection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Inicio {
    public static void mostrarNoticias(ArrayList<Perfil> perfiles) {
        ArrayList<String> publicacionesTotales = new ArrayList<>();

        // Obtener todas las publicaciones de todos los perfiles
        for (Perfil perfil : perfiles) {
            publicacionesTotales.addAll(perfil.getPublicaciones());
        }

        // Mostrar las publicaciones obtenidas
        if (!publicacionesTotales.isEmpty()) {
            StringBuilder noticias = new StringBuilder();
            for (String publicacion : publicacionesTotales) {
                noticias.append(publicacion).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, "Noticias:\n\n" + noticias);
        } else {
            JOptionPane.showMessageDialog(null, "No hay publicaciones aún.");
        }
    }
}
