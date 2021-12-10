package com.example.ex1.repository;

import com.example.ex1.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class AnimalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Animal> findAll(){
        String sql = "SELECT * FROM animal";

        List<Animal> animals = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Animal(rs.getInt("id"), rs.getString("nume"), rs.getString("culoare")));

//        List<Animal> animals = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Animal.class));

        return animals;
    }

    public Animal save(Animal animal) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO animal(nume,culoare) VALUES(?,?)";
//        jdbcTemplate.update(sql, animal.getNume(), animal.getCuloare());
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, animal.getNume());
            preparedStatement.setString(2, animal.getCuloare());
            return preparedStatement;
        }, keyHolder);
        System.out.println("Noul id generat este: " + keyHolder.getKey().intValue());
        animal.setId(keyHolder.getKey().intValue());
        return animal;
    }

    public int deleteById(int id){
        String sql = "DELETE FROM animal WHERE id = ?";
        int rows = jdbcTemplate.update(sql, id);
        return rows;
    }
}
