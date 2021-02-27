package com.nendrasys.com.dao;

import com.nendrasys.com.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExistingAddresImpl implements ExistingAddress{


    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveData(Address address, Principal principal) {
        String sql="insert into usertoaddress(email,address_id) values ('" + principal.getName() + "','" + address.getAddress_id() + "')";
        return jdbcTemplate.update(sql);
    }

    /* @Override
        public Address getAddress(Principal principal) {
            String QUERY1 = "SELECT address.first_name, address.address_line1 FROM address INNER JOIN usertoaddress ON  address.address_id=usertoaddress.address_id  AND usertoaddress.email='" + principal.getName() + "'";
            Address address = (Address) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(Address.class));
            return address;
        }*/
    @Override
    public List<Address> getAddress(Principal principal){

        List<Address> addresses = jdbcTemplate.query("SELECT address.first_name, address.address_line1 FROM address INNER JOIN usertoaddress ON  address.address_id=usertoaddress.address_id  AND usertoaddress.email='" + principal.getName() + "'", new RowMapper<Address>() {
            @Override
            public Address mapRow(ResultSet rs, int i) throws SQLException {
                Address b = new Address();
                b.setFirstName(rs.getString("first_name"));
                b.setAddressLine1(rs.getString("address_Line1"));
                /*b.setLastName(rs.getString("lastName"));
                b.setAddressLine1(rs.getString("addressLine1"));
                b.setAddressLine2(rs.getString("addressLine2"));
                b.setPostcode(rs.getString("postcode"));
                b.setEmail(rs.getString("email"));
                b.setContactNumber(rs.getString("contactNumber"));*/
                return b;
            }
        });
        return  addresses;
    }

    @Override
    public int saveAddress(Address addressModel) throws DataAccessException {
        int COUNT;
        try {
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO address(address_id,first_name,last_name,address_line1,address_line2,postcode,email,contact_number)");
            query.append("values ( '"+addressModel.getAddress_id()+"','"+addressModel.getFirstName()+"','"+addressModel.getLastName()+"','");
            query.append(addressModel.getAddressLine1()+"','"+addressModel.getAddressLine2()+"','"+addressModel.getPostcode()+"','");
            query.append(addressModel.getEmail()+"','"+addressModel.getContactNumber()+"');");
            COUNT = jdbcTemplate.update(query.toString());
        }
        catch (DataAccessException e){
            COUNT = 0;
        }

        return COUNT;

    }

}
