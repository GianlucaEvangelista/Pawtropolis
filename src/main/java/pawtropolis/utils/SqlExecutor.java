package pawtropolis.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.nio.file.Files;

@Component
public class SqlExecutor {

    @Value("classpath:newMap.sql")
    private Resource script;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlExecutor(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void executeSqlScript(Integer playerId){
        try {
            String sqlScript = Files.readString(script.getFile().toPath());
            sqlScript = sqlScript.replace(":playerId", String.valueOf(playerId));
            jdbcTemplate.execute(sqlScript);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

