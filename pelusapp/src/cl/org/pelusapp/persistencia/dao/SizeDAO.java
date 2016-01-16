package cl.org.pelusapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cl.org.pelusapp.domain.Size;

public class SizeDAO {

	private SqlSessionFactory sqlSessionFactory;

	public SizeDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Size> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<Size> list = new ArrayList<Size>();
			list = session.selectList("Size.getAll");
			return list;
		} finally {
			session.close();
		}
	}
}
