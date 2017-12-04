package proyecto;


import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * 
 */
public class Mago {

    
    public String Usuario;
    public String Contraseña;
    public String Nombres;
    public String Apellidos;
    public int Edad;
    public String Casa;
    public String Varita;
    public Tipo_Mago Tipo;
    
    public Mago(String Nombres, String Apellidos, int Edad, String Casa, String Varita, Tipo_Mago Tipo) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
        this.Casa = Casa;
        this.Varita = Varita;
        this.Tipo = Tipo;
    }
    
    public Mago(String Nombres, String Apellidos) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
    }
     
    public static String[] Login() {
        Scanner sc = new Scanner(System.in);
        String usernom = "", userapell = "", userrol = "";
        String[] userdata = new String[3];
        int checknum = -1;

        while (checknum == -1) {
            System.out.println("Usuario: ");
            String usuario = sc.nextLine();
            System.out.println("Contraseña: ");
            String password = sc.nextLine();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            String linea;
            try {
                fr = new FileReader("Usuarios.txt");
                br = new BufferedReader(fr);
                while ((linea = br.readLine()) != null) {
                    String texto[] = linea.split(",");
                    if (texto[0].equals(usuario) && texto[1].equals(password)) {
                        checknum = 1;
                        usernom = texto[2];
                        userapell = texto[3];
                        userrol = texto[4];
                    }
                }
                br.close();
            } catch (Exception ex) {
                System.out.println("Error");
            }
            if (checknum == -1) {
                System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez.");
            } else {
                System.out.println("\nIngreso exitoso\n");

            }
        }

        userdata[0] = usernom;
        userdata[1] = userapell;
        userdata[2] = userrol;

        return userdata;
    }
    
    public static void logOut() {
        System.out.print("\nHa salido del sistema.\n");
    }
      public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getVarita() {
        return Varita;
    }

    public void setVarita(String Varita) {
        this.Varita = Varita;
    }
}
