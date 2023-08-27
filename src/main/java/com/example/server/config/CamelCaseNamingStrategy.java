package com.example.server.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
 

public class CamelCaseNamingStrategy extends CamelCaseToUnderscoresNamingStrategy  {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name; // Do not modify the column name
    }
}
