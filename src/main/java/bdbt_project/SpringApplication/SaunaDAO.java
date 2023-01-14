package bdbt_project.SpringApplication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class SaunaDAO {
    private JdbcTemplate jdbcTemplate;

    public SaunaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Sauna> list(){
        String sql = "SELECT * FROM SAUNY";

        List<Sauna> listSauna = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sauna.class));

        return listSauna;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Sauna sauna) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("sauny").usingColumns("nr_sauny", "nazwa", "data_zalozenia", "numer_telefonu", "email", "nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sauna);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Sauna get(int nr_sauny) {
        Object[] args = {nr_sauny};
        String sql = "SELECT * FROM SAUNY WHERE nr_sauny = " + args[0];
        Sauna sauna = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Sauna.class));

        return sauna;
    }

    /* Update – aktualizacja danych */
    public void update(Sauna sauna) {
        String sql = "UPDATE SAUNY SET nazwa=:nazwa, data_zalozenia=:data_zalozenia, numer_telefonu=:numer_telefonu," +
                " email=:email, nr_adresu=:nr_adresu WHERE nr_sauny=:nr_sauny";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sauna);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_sauny) {
        String sql = "DELETE FROM SAUNY WHERE nr_sauny = ?";
        jdbcTemplate.update(sql, nr_sauny);
    }

}
