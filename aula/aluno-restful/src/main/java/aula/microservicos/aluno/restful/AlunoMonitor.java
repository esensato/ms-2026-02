package aula.microservicos.aluno.restful;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("Aluno")
public class AlunoMonitor implements HealthIndicator {

    private DataSource ds;

    public AlunoMonitor(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Health health() {
        try (Connection conn = ds.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.execute("select COUNT(*) from TAB_ALUNO");
        } catch (SQLException ex) {
            return Health.outOfService().withException(ex).build();
        }
        return Health.up().build();
    }

}