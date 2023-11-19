package Chimba_Conection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class IniciarSesion {
    public static Perfil iniciarSesion(ArrayList<Perfil> perfiles) {
        String usuarioIngresado = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasenaIngresada = JOptionPane.showInputDialog("Ingrese su contraseña:");

        // Buscar el perfil correspondiente al usuario y contraseña ingresados
        for (Perfil perfil : perfiles) {
            if (perfil.getUsuario().equals(usuarioIngresado) && perfil.getContrasena().equals(contrasenaIngresada)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                return perfil; // Devuelve el perfil encontrado
            }
        }

        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
        return null; // Si no se encuentra el perfil, devuelve null
    }
}

