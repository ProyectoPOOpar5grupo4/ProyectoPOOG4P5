package proyecto;

/**
 *
 * @author Pc
 */
public class Proyecto {

    public static void main(String[] args) {
    System.out.println("\nBIENVENIDO AL SISTEMA\n");
        String[] infousuario = Mago.Login();
        String username = infousuario[0];
        String userapelllido = infousuario[1];
        String userrol = infousuario[2];
        
        Scanner sc = new Scanner(System.in);
        if (userrol.equalsIgnoreCase("planificador")) {
            int opcion1 = 1;
            while (opcion1 == 1) {
                System.out.println("MENU PLANIFICADOR");
                System.out.println("\n1. Crear Curso" + "\n2. Crear Profesor" + "\n3. Crear Estudiante" + "\n4. Ver Horarios Planificados"
                        + "\n5. Listado de Estudiantes" + "\n6. Salir");
                System.out.println("Seleccione una opción");
                int subopcion = sc.nextInt();
                Planificador planner = new Planificador();
                if (subopcion == 1) {
                    planner.CrearCurso();

                } else if (subopcion == 2) {
                    planner.CrearProfesor();

                } else if (subopcion == 3) {
                    planner.CrearEstudiante();

                } else if (subopcion == 4) {
                    planner.VerHorariosPlanificados(userrol);

                } else if (subopcion == 5) {
                    //planner.VerListado();

                } else if (subopcion == 6) {
                    Mago.logOut();
                    opcion1 = 0;

                } else {
                    System.out.println("Opción No Válida");
                }

            }
        } else if (userrol.equalsIgnoreCase("estudiante")) {
            int opcion2 = 1;
            Estudiante est = new Estudiante(username, userapelllido);
            while (opcion2 == 1) {
                System.out.println("MENU ESTUDIANTE");
                System.out.println("\n1. Ver Cursos Planificados" + "\n2. Registro" + "\n3. Descripción de Vuelo" + "\n4. Salir");
                System.out.println("Seleccione una opción: ");
                int subopcion2 = sc.nextInt();
                if (subopcion2 == 1) {
                    Estudiante.VerHorarios();

                } else if (subopcion2 == 2) {                 
                    est.Registro(est.getNombres(), est.getApellidos());

                } else if (subopcion2 == 3) {
                    est.Volar(est.getNombres(), est.getApellidos());

                } else if (subopcion2 == 4) {
                    Mago.logOut();
                    opcion2 = 0;
                } else {
                    System.out.println("Opción No Válida");
                }

            }
        }
    }
}
