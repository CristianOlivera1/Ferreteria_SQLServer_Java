package BASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conectaBD {
    public Connection cnn; // OBJETO CONEXION PARA LA BD
    public Statement stm; // CLASE PARA CONECTAR LOS OBJETOS BD
    public ResultSet rs; // CLASE QUE MANIPULA LOS DATOS

    String servidor = "localhost";
    String usuario = "sa";
    String clave = "cristianonelover";
    String puerto = "1433";
        String base = "BDPROYFERRETERIA";

    public void conectar() {
        try {
            // Cargar el controlador JDBC de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Crear la cadena de conexión
            String cadena = "jdbc:sqlserver://" + servidor + ":" + puerto + ";"
                    + "databaseName=" + base + ";user=" + usuario + ";password=" + clave + ";"
                    + "encrypt=true;trustServerCertificate=true;";

            // Establecer la conexión
            cnn = DriverManager.getConnection(cadena);
            stm = cnn.createStatement();

            System.out.println("Conexion exitosa!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
