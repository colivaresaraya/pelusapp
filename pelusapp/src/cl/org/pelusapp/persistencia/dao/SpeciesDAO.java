package cl.org.pelusapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cl.org.pelusapp.domain.Species;

public class SpeciesDAO {

	private SqlSessionFactory sqlSessionFactory;

	public SpeciesDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Species> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<Species> list = new ArrayList<Species>();
			list = session.selectList("Species.getAll");
			return list;
		} finally {
			session.close();
		}
	}
}
