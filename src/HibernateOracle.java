
import hibernateoracle.Dept;
import hibernateoracle.Emp;
import hibernateoracle.repositories.Queries;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patricia
 */
public class HibernateOracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        short numemp = 7950;
        short numdep = 7;
        byte n = 1;
        Dept depertamento = new Dept(n, "ACCOUNTING", "NEW YORK");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stringFecha = "2014-09-15";
        Date fecha = sdf.parse(stringFecha);
        BigDecimal salario = BigDecimal.valueOf(1900);
        BigDecimal comision = BigDecimal.valueOf(400);
        Emp newEmpleado = new Emp(numemp, depertamento, "Elena", "Ortiz", numdep, fecha, salario, comision);

        Queries queries = new Queries();
        queries.Altaempleado(newEmpleado);

        queries.Bajaempleado(newEmpleado);
        queries.ConsultaSQL("FROM Emp as empleado INNER JOIN empleado.dept as departamente");

    }

}
