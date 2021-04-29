package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    private final DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT breed FROM dinosaur WHERE expected < actual ORDER BY breed ASC")
        ) {
            return processingSqlQuery(rs);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select dinosaur", se);
        }
    }

    private List<String> processingSqlQuery(ResultSet rs) throws SQLException {
        List<String> names = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("breed");
            names.add(name);
        }
        return names;
    }


}

