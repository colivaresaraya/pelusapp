package cl.org.pelusapp.persistencia.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cl.org.pelusapp.domain.Pet;

public class PetDAO {

	private SqlSessionFactory sqlSessionFactory;

	public PetDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	   public void insert(Pet pet) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Pet.insert", pet);
            session.commit();
        } finally {
            session.close();
        }
    }
}
