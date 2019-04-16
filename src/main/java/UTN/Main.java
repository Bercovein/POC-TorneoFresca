package UTN;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.sql.*;

public class Main {

    private static List<Humano> Vikings;
    private static List<Humano> Spartans;
    private static List<Pinta> Pintas;

    public static void main(String[] args) {

        try {
            //1- Conexion a la DB
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3308/torneo", "root", "");
            //2- Crear la sentencia
            Statement myStatement = myConnection.createStatement();


            System.out.println("\n         TORNEO DE FRESCAS! \nHAGAN SENTIR ORGULLOSOS A SUS DIOSES!" + "\n");
            Humano tabernero = new Tabernero(
                    "Barbarin Hallconen",
                    50,
                    120,
                    1.8f,
                    new OrinarEspartanoImp(),
                    new BeberVikingoImp()
            );

            Vikings = Arrays.asList(
                    new Vikingo("Ragnar", 40, 90, 1.7f, new OrinarVikingoImp(), new BeberVikingoImp()),
                    new Vikingo("Bjorn", 27, 75, 1.85f, new OrinarVikingoImp(), new BeberVikingoImp()),
                    new Vikingo("Rollo", 43, 100, 2f, new OrinarVikingoImp(), new BeberVikingoImp()),
                    new Vikingo("Floki", 35, 60, 1.57f, new OrinarVikingoImp(), new BeberVikingoImp()),
                    new Vikingo("Torstein ", 30, 80, 1.9f, new OrinarVikingoImp(), new BeberVikingoImp())
            );

            Spartans = Arrays.asList(
                    new Espartano("Leonidas", 45, 80, 1.8f, new OrinarEspartanoImp(), new BeberEspartanoImp()),
                    new Espartano("Dilios", 30, 100, 1.75f, new OrinarEspartanoImp(), new BeberEspartanoImp()),
                    new Espartano("Artemis", 60, 60, 1.57f, new OrinarEspartanoImp(), new BeberEspartanoImp()),
                    new Espartano("Jerjes", 40, 95, 1.9f, new OrinarEspartanoImp(), new BeberEspartanoImp()),
                    new Espartano("Daxos", 22, 85, 1.77f, new OrinarEspartanoImp(), new BeberEspartanoImp())
            );

            Pintas = Arrays.asList(
                    new Pinta("Cuerno de Hidromiel", 12f),
                    new Pinta("Ipa", 5f),
                    new Pinta("Blond Ale", 3f),
                    new Pinta("Stout", 8f)
            );

            Vikings = ordenarPorEdad(Vikings);
            Spartans = ordenarPorEdad(Spartans);

            String clase = "";

            do {
                Humano v = Vikings.remove(new Random().nextInt(Vikings.size()));
                Humano s = Spartans.remove((new Random()).nextInt(Spartans.size()));


                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("VIKINGO: " + v.toString() + "\n" + " VS " + "\n" + "ESPARTANO: " + s.toString());
                System.out.println("---------------------------------------------------------------------------------------");

                Humano ganador = enfrentar(v, s);

                Humano p;
                if (!ganador.getNombre().equals(v.getNombre())) {
                    p = v;
                } else {
                    p = s;
                }

                String sql = "insert into ganadores(nombre_ganador,nombre_perdedor,ingerido)" +
                        "values(" + ganador.getNombre() + "," + p.getNombre() + "," + ganador.getIngerido() + ")";

                myStatement.executeUpdate(sql);

                if (ganador.equals(v)) {
                    clase = "Vikingo";
                } else if (ganador.equals(s)) {
                    clase = "Espartano";
                }

                System.out.println("GANADOR: El " + clase + " " + ganador.getNombre() + "!\n");

                ganador.setIngerido(0);
                tabernero.setIngerido(0);

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                Humano granFinale = enfrentar(tabernero, ganador);

                Humano gp = null;
                if (!granFinale.equals(ganador)) {
                    gp = ganador;
                } else {
                    gp = tabernero;
                }

                String sql2 = "insert into ganadores(nombre_ganador,nombre_perdedor, ingerido)" +
                        "values(" + granFinale.getNombre() + "," + gp.getNombre() + "," + granFinale.getIngerido() + ")";

                myStatement.executeUpdate(sql2);

                System.out.println("GANADOR FINAL: " + granFinale.getNombre() + "!\n");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

            } while ((Vikings.size() > 0) && (Spartans.size() > 0));

            resultados(myStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Humano> ordenarPorEdad(List<Humano> lista) {

        try {
            lista = lista.stream()
                    .sorted(Comparator.comparing(Humano::getEdad))
                    .collect(Collectors.toList());

            return lista;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public static Humano enfrentar(Humano comp1, Humano comp2) {

        try {

            boolean res1;
            boolean res2;
            Humano ganador = null;

            String comentario = "";

            String cervezas = "\n********HORA DE BEBER! SKÖL!********:\n\n" + "--- Pintas: ";

            int countPintas = 0;

            do {
                Pinta pinta = Pintas.get((new Random()).nextInt(Pintas.size()));

                ++countPintas;

                cervezas = cervezas + pinta.getNombre() + ", ";

                comp1.setIngerido(comp1.getBeber().Beber(comp1, pinta));
                comp2.setIngerido(comp2.getBeber().Beber(comp2, pinta));

                res1 = comp1.getOrinar().Orinar(comp1);
                res2 = comp2.getOrinar().Orinar(comp2);

                if (res1 && res2) {
                    if (comp1.getIngerido() > comp2.getIngerido()) {
                        ganador = comp2;
                        comentario = "Vaya vaya, a eso llamas ganar?!";
                    } else {
                        ganador = comp1;
                        comentario = "Parece que hay un ganador! ... (Por poco!)";
                    }
                } else {
                    if (res1) {
                        ganador = comp2;
                        comentario = "Parece que tenemos un ganad... HEY! NO ORINES EN LA BARRA!";
                    } else if (res2) {
                        ganador = comp1;
                        comentario = "TENEMOS UN GANADOR! LOS DIOSES ESTÁN ORGULLOSOS MUCHACHO!";
                    }
                }

            } while (!res1 && !res2);

            System.out.println(cervezas + " --- Total: " + countPintas + "\n");
            System.out.println("Tabernero: " + comentario + "\n");

            return ganador;

        } catch (NullPointerException e) {
            throw e;
        }
    }

    public static void resultados(Statement myStatement) {

        try{
            ResultSet myResult = myStatement.executeQuery("select * from ganadores");

            System.out.println("--- TABLA DE RESULTADOS ---");

            while(myResult.next()){

                System.out.println("Ronda " + myResult.getString("id_ganador")
                  + ": \n   Ganador = " + myResult.getString("nombre_ganador")
                  + ", \n   Perdedor = " + myResult.getString("nombre_perdedor")
                  + ", \n   Ingerido= " + myResult.getString("ingerido") + " mililitros.");

                System.out.println("------------------------------------");
            }
            myStatement.close();
        }catch (SQLException e){
            e.getStackTrace();
        }
    }
}