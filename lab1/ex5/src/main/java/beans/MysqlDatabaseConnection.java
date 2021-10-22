package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysql")
public class MysqlDatabaseConnection implements DatabaseConnection{
    public String getConnection() {
        return "MYSQL CONNECTION!";
    }
}
