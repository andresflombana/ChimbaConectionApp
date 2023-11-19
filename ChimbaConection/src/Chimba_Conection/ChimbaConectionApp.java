package Chimba_Conection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

// Clase base para los perfiles
class Perfil {
    private String nombre;
    private String usuario;
    private String contrasena;
    private String cancionFavorita;
    private ArrayList<String> publicaciones;

    public Perfil(String nombre, String usuario, String contrasena, String cancionFavorita) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cancionFavorita = cancionFavorita;
        this.publicaciones = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void agregarPublicacion(String contenido) {
        publicaciones.add(contenido);
    }

    public ArrayList<String> getPublicaciones() {
        return publicaciones;
    }

    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null,
                "Nombre: " + nombre + "\n" +
                "Usuario: " + usuario + "\n" +
                "Canción Favorita: " + cancionFavorita);
    }
}

// Clase para la funcionalidad de crear un perfil
class CrearNuevoPerfil {
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

// Clase para la funcionalidad de iniciar sesión
class IniciarSesion {
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

// Clase para ver las noticias o el inicio
class Inicio {
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

public class ChimbaConectionApp {
    private static int paginaActual = 0;
    private static int ultimaPagina = 0;

    private static ArrayList<Perfil> perfiles = new ArrayList<>(); // ArrayList para almacenar los perfiles

    public static void main(String[] args) {
        iniciarAplicacion();
    }

    public static void iniciarAplicacion() {
        boolean seguirEjecutando = true;

        while (seguirEjecutando) {
            mostrarMenuPrincipal();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    // Crear Nuevo Perfil
                    CrearNuevoPerfil.crearNuevoPerfil(perfiles);
                    break;
                case 2:
                    // Iniciar Sesión
                    Perfil perfilActivo = IniciarSesion.iniciarSesion(perfiles);
                    if (perfilActivo != null) {
                        // Operaciones con el perfil activo
                        perfilActivo.mostrarInformacion(); // Por ejemplo: perfilActivo.mostrarInformacion()
                    }
                    break;
                case 3:
                    VerPerfil.mostrarPerfil(perfiles);
                    break;
                case 4:
                    Perfiles.buscarPerfiles(perfiles);
                    break;
                case 5:
                    PublicarContenido.publicar(perfiles);
                    break;
                case 6:
                    // Ver Noticias o Inicio
                    Inicio.mostrarNoticias(perfiles);
                    break;
                case 7:
                    // Opción 10: Salir de la aplicación
                    seguirEjecutando = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor seleccione una opción correcta.");
                    break;
            }
        }
    }

    public static void mostrarMenuPrincipal() {
        String menu = "ChimbaConection\n" +
                      "1. Crear Nuevo Perfil\n" +
                      "2. Iniciar Sesión\n" +
                      "3. Ver Perfil\n" +
                      "4. Buscar Perfiles\n" +
                      "5. Publicar Contenido\n" +
                      "6. Ver Noticias\n" +
                      "7. Salir de la aplicación\n\n" +
                      "Seleccione una opción (1-7):";

        JOptionPane.showMessageDialog(null, menu);
    }

    public static int obtenerOpcion() {
        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            try {
                String input = JOptionPane.showInputDialog(null, "Ingrese el número de opción:");
                opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= 7) {
                    opcionValida = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida (1-7).");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        }

        return opcion;
    }
}