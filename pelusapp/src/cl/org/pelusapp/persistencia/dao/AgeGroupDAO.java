package cl.org.pelusapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cl.org.pelusapp.domain.AgeGroup;

public class AgeGroupDAO {

	private SqlSessionFactory sqlSessionFactory;

	public AgeGroupDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<AgeGroup> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<AgeGroup> list = new ArrayList<AgeGroup>();
			list = session.selectList("AgeGroup.getAll");
			return list;
		} finally {
			session.close();
		}
	}
}
