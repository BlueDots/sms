package jxau.sms.globaldao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation=Propagation.REQUIRED)
@Component("dao")
public class EntityDao implements Dao {

	private SqlSession session;
	@Resource(name="sqlSession")
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public <T> void add(String mapperId,T t) {
		    session.insert(mapperId, t);
	  
	}

	@Override
	public <T>  T selectOne(String mapperId, Map<String, Object> params) {
		 return session.selectOne(mapperId, params);
	}

	@Override
	public <T> List<T> select(String mapperId, Map<String, Object> params) {
		 return session.selectList(mapperId,params);
	}

	@Override
	public <T> void batchAdd(String mapperId, List<T> t) {
		 session.insert(mapperId, t);
	}

	@Override
	public <T> void delete(String mapperId, T t) {
		   session.delete(mapperId, t);
	}

	@Override
	public <T> void update(String mapperId, T t) {
		  session.update(mapperId, t);
	}

	@Override
	public <T> void batchDelete(String mapperId, List<T> t) {
		  session.delete(mapperId, t);
	}

	@Override
	public <T> void batchUpdate(String mapperId, List<T> t) {
		  for(T a :t){
		  session.update(mapperId, a);
		  }
		 }

	@Override
	public <T> void batchAdd(String mapperId, Map<String, Object> params) {
		// TODO Auto-generated method stub
		session.insert(mapperId, params);
	}

	@Override
	public <T> void batchDelete(String mapperId, Map<String, Object> params) {
		// TODO Auto-generated method stub
		session.delete(mapperId, params);
	}

}
 