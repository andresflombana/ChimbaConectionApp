package Chimba_Conection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CrearNuevoPerfil {
    public static void crearNuevoPerfil(ArrayList<Perfil> perfiles) {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
        String cancionFavorita = JOptionPane.showInputDialog("Ingrese su canción favorita:");

        // Crear un nuevo perfil con los datos ingresados
        Perfil nuevoPerfil = new Perfil(nombre, usuario, contrasena, cancionFavorita);

        // Agregar el nuevo perfil a la lista de perfiles
        perfiles.add(nuevoPerfil);

        JOptionPane.showMessageDialog(null, "Perfil creado exitosamente.");
    }
}
