package Chimba_Conection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Perfiles {

    // Método para buscar perfiles y mostrar su información
    public static void buscarPerfiles(ArrayList<Perfil> perfiles) {
        // Mostrar todos los perfiles registrados para seleccionar uno
        StringBuilder listaPerfiles = new StringBuilder("Perfiles registrados:\n");
        for (Perfil perfil : perfiles) {
            listaPerfiles.append("- ").append(perfil.getUsuario()).append("\n");
        }

        String usuarioSeleccionado = JOptionPane.showInputDialog("Seleccione un perfil:\n" + listaPerfiles);

        // Buscar el perfil seleccionado en la lista
        for (Perfil perfil : perfiles) {
            if (perfil.getUsuario().equals(usuarioSeleccionado)) {
                // Mostrar información del perfil seleccionado
                perfil.mostrarInformacion();
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "El perfil seleccionado no existe.");
    }
}
