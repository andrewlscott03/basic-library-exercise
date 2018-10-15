package org.basiclibrary.db.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

/**
 * The borrower IDs may be scanned from barcodes or RFID.
 */
public class BorrowerIdCustomGen implements IdentifierGenerator, Configurable {

	/**
	 * A borrower ID is prefixed with 'B' followed by a minimum of 5 digits.
	 */
	private final DecimalFormat idFormat = new DecimalFormat("B####00000");

	private String getSequenceSql = null;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

		JdbcEnvironment jdbcEnvironment = serviceRegistry.getService(JdbcEnvironment.class);
		Dialect dialect = jdbcEnvironment.getDialect();
		getSequenceSql = dialect.getSequenceNextValString("BorrowerIdGen");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		try {
			Connection connection = session.connection();
			try (PreparedStatement preparedStmt = connection.prepareStatement(getSequenceSql)) {
				ResultSet resultSet = preparedStmt.executeQuery();
				resultSet.next();
				Long value = resultSet.getLong(1);
				String id = idFormat.format(value);
				return id;
			}
		} catch (SQLException e) {
			throw new HibernateException("Unable to get BorrowerIdGen sequence value", e);
		}
	}
}