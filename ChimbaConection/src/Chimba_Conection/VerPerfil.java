package Chimba_Conection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class VerPerfil {
	public static void mostrarPerfil(ArrayList<Perfil> perfiles) {
	    String usuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");

	    for (Perfil perfil : perfiles) {
	        if (perfil.getUsuario().equals(usuario)) {
	            perfil.mostrarInformacion();
	            return;
	        }
	    }

	    JOptionPane.showMessageDialog(null, "El perfil no fue encontrado.");
	}
    private String nombre;
    private String usuario;
    private String cancionFavorita;
    private ArrayList<String> publicaciones;

    public VerPerfil(String nombre, String usuario, String cancionFavorita) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.cancionFavorita = cancionFavorita;
        this.publicaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCancionFavorita() {
        return cancionFavorita;
    }

    public void mostrarInformacion() {
        // Método para mostrar la información del perfil
        JOptionPane.showMessageDialog(null, 
                "Nombre: " + nombre + "\n" +
                "Usuario: " + usuario + "\n" +
                "Canción Favorita: " + cancionFavorita);
        
    }
    
    public void agregarPublicacion(String contenido) {
        publicaciones.add(contenido);
    }

    public ArrayList<String> getPublicaciones() {
        return publicaciones;
    }

    public void mostrarPerfil() {
        // Mostrar información general del perfil
        mostrarInformacion();

        // Mostrar publicaciones
        if (!publicaciones.isEmpty()) {
            StringBuilder publicacionesStr = new StringBuilder("Publicaciones:\n\n");
            for (String publicacion : publicaciones) {
                publicacionesStr.append("- ").append(publicacion).append("\n");
            }
            JOptionPane.showMessageDialog(null, publicacionesStr);
        } else {
            JOptionPane.showMessageDialog(null, "No hay publicaciones aún.");
        }
    }
}
