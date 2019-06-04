package com.karinasoft.practimep.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${cassandra.contactpoints}")
	private String contactPoints;

	@Value("${cassandra.port}")
	private int port;

	@Value("${cassandra.keyspace}")
	private String keySpace;

	@Value("${cassandra.basePackages}")
	private String basePackages;
	
	@Value("${cassandra.username}")
	private String username;
	
	@Value("${cassandra.password}")
	private String password;

	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { basePackages };
	}

	@Override
	protected boolean getMetricsEnabled() {
		return false;
	}
	
	@Override
	protected AuthProvider getAuthProvider() {
		PlainTextAuthProvider sap = new PlainTextAuthProvider(username, password);
		return sap;
	}
	
}
