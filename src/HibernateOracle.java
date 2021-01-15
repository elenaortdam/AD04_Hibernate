
import hibernateoracle.Dept;
import hibernateoracle.Emp;
import hibernateoracle.repositories.Queries;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        Queries queries = new Queries();
        List<Dept> deps = queries.consulta("FROM Dept");
        Dept departament = deps.get(0);

        short numemp = 7950;
        short numdep = 7;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stringFecha = "2021-01-15";
        Date fecha = sdf.parse(stringFecha);
        BigDecimal salario = BigDecimal.valueOf(1900);
        BigDecimal comision = BigDecimal.valueOf(400);
        Emp newEmpleado = new Emp(numemp, departament, "Elena", "Ortiz",
                numdep, fecha, salario, comision);

        queries.altaEmpleado(newEmpleado);
        queries.bajaEmpleado(newEmpleado);
        
         List<Object[]> lista = queries.consulta("FROM Emp as empleado INNER JOIN empleado.dept as departamento");
        for (Object[] objecto : lista) {
            Emp empleado = (Emp) objecto[0];
            Dept departamento = (Dept) objecto[1];
            System.out.println("Nombre: " + empleado.getEname() + ", número: " + empleado.getEmpno()
                    + ", salario: " + empleado.getSal() + " , departamento: " + departamento.getDname()
                    + ", localización departamento: " + departamento.getLoc());
        }
    }

}
