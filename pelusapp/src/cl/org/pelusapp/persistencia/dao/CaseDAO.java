package cl.org.pelusapp.persistencia.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cl.org.pelusapp.domain.Case;

public class CaseDAO {

	private SqlSessionFactory sqlSessionFactory;

	public CaseDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	   public void insert(Case cases) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Case.insert", cases);
            session.commit();
        } finally {
            session.close();
        }
    }
}
