package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    String servidor = "localhost";
    String puerto = "1433";
    String base = "BDPROYFERRETERIA";
    String usuario = "sa";
    String clave = "cristianonelover";

    Connection conectar = null;

    public Connection conexion() {
        try {
            // Cargar el controlador JDBC de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Crear la cadena de conexión
            String connectionUrl = "jdbc:sqlserver://" + servidor + ":" + puerto + ";"
                    + "databaseName=" + base + ";user=" + usuario + ";password=" + clave + ";"
                    + "encrypt=true;trustServerCertificate=true;";

            // Establecer la conexión
            conectar = DriverManager.getConnection(connectionUrl);

            System.out.println("Conexión exitosa!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conectar;
    }
}
