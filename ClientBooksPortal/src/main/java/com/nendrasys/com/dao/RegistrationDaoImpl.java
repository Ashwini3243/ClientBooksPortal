package com.nendrasys.com.dao;
import com.nendrasys.com.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.security.Principal;

public class RegistrationDaoImpl implements RegistrationDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveRegisteredData(RegistrationModel reg) {
        reg.setRole("ROLE_U");
        String query = "insert into usersData(firstName,lastName,email,userName,password,confirmPassword,address,country,contact,role) values('" + reg.getFirstName() + "','" + reg.getLastName() + "','" + reg.getEmail() + "','" + reg.getUserName() + "','" + reg.getPassword() + "','" + reg.getConfirmPassword() + "','" + reg.getAddress() + "','" + reg.getCountry() + "','" + reg.getContact() + "','" + reg.getRole() + "')";
        return jdbcTemplate.update(query);
    }

    @Override
    public RegistrationModel getUserDetailsById(Principal principal) {
        String QUERY1 = "select * from usersData where username='" + principal.getName() + "'";
        RegistrationModel registrationModel = (RegistrationModel) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(RegistrationModel.class));
        return registrationModel;
    }


}
