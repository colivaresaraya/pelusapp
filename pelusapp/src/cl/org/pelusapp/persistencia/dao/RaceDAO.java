package cl.org.pelusapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cl.org.pelusapp.domain.Race;

public class RaceDAO {

	private SqlSessionFactory sqlSessionFactory;

	public RaceDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Race> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<Race> list = new ArrayList<Race>();
			list = session.selectList("Species.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	public List<Race> selectById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<Race> list = new ArrayList<Race>();
			list = session.selectList("Race.getById", id);
			System.out.println("RAZAS ---------> " + list);
			return list;
		} finally {
			session.close();
		}
	}

}
