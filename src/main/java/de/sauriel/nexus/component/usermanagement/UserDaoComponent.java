package de.sauriel.nexus.component.usermanagement;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.sauriel.nexus.model.entity.DbUser;

@Component
public class UserDaoComponent {

	// See:
	// https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-annotations-example/

	/*
	 * CREATE TABLE `user` ( `id` int(11) NOT NULL AUTO_INCREMENT, `email`
	 * varchar(30) COLLATE utf32_unicode_520_ci NOT NULL, `hash` varchar(60)
	 * COLLATE utf32_unicode_520_ci NOT NULL, `register_date` timestamp NOT NULL
	 * DEFAULT CURRENT_TIMESTAMP, `active` tinyint(1) NOT NULL, PRIMARY KEY
	 * (`id`), UNIQUE KEY `email` (`email`) ) ENGINE=InnoDB AUTO_INCREMENT=4
	 * DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_520_ci;
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoComponent.class);

	public boolean create(String email, String encodedPassword) {
		DbUser user = new DbUser(email, encodedPassword);
		return createUser(user);
	}

	public Optional<String> getUserHash(String email) {
		Optional<DbUser> user = getUser(email);
		if (user.isPresent()) {
			return user != null ? Optional.ofNullable(user.get().getHash()) : Optional.empty();
		}
		return Optional.empty();
	}

	public boolean updateHash(String id, String newHash) {
		DbUser user = getUserById(id);
		if (user != null) {
			user.setHash(newHash);
			return updateUser(user);
		}
		return false;
	}

	public boolean updateEmail(String id, String email) {
		DbUser user = getUserById(id);
		if (user != null) {
			user.setEmail(email);
			return updateUser(user);
		}
		return false;
	}

	private void addAnnotatedClasses(Configuration configuration) {
		configuration.addAnnotatedClass(DbUser.class);
	}

	private SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		addAnnotatedClasses(configuration);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	private boolean createUser(DbUser user) {
		try {
			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException exception) {
			LOGGER.error("User {} probably already exists.", user.getEmail());
			exception.printStackTrace();
			return false;
		}
	}

	private boolean updateUser(DbUser newUser) {
		try {
			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			DbUser dbUser = session.load(DbUser.class, newUser.getId());
			dbUser.setEmail(newUser.getEmail());
			dbUser.setHash(newUser.getHash());
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException exception) {
			LOGGER.error("Can not update user {}.", newUser.getEmail());
			exception.printStackTrace();
			return false;
		}
	}

	private DbUser getUserById(String id) {
		Session session = getSessionFactory().openSession();
		DbUser dbUser = session.get(DbUser.class, id);
		session.close();
		return dbUser;
	}

	private Optional<DbUser> getUser(String email) {
		Optional<DbUser> user = Optional.empty();
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DbUser.class);
		criteria.add(Restrictions.eq("email", email));
		List result = criteria.list();
		if (!result.isEmpty()) {
			user = Optional.ofNullable((DbUser) result.get(0));
		}
		session.close();
		return user;
	}

}
