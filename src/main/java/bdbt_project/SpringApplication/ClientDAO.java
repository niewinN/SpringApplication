package bdbt_project.SpringApplication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Repository
public class ClientDAO {
    private JdbcTemplate jdbcTemplate;

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Client> list(){
        String sql = "SELECT * FROM KLIENCI";

        List<Client> listClient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));

        return listClient;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Client client) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klienci").usingColumns("nr_klienta", "numer_telefonu", "email", "nr_sauny", "nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Client get(int nr_klienta) {
        Object[] args = {nr_klienta};
        String sql = "SELECT * FROM KLIENCI WHERE nr_klienta = " + args[0];
        Client client = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Client.class));

        return client;
    }

    /* Update – aktualizacja danych */
    public void update(Client client) {
        String sql = "UPDATE KLIENCI SET numer_telefonu=:numer_telefonu, email=:email, nr_sauny=:nr_sauny," +
                " nr_adresu=:nr_adresu WHERE nr_klienta=:nr_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_klienta) {
        String sql = "DELETE FROM KLIENCI WHERE nr_klienta = ?";
        jdbcTemplate.update(sql, nr_klienta);
    }

}

