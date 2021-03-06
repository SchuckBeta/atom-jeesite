/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.UserDAO;

import java.util.Map;
import java.util.List;
import com.github.obullxl.jeesite.dal.dto.UserDTO;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.UserDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Mon Jan 06 16:48:20 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisUserDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements UserDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>UserDTO</tt> object to DB table <tt>atom_user</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_user(id,uname,passwd,uemail,uflag,unick,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param user
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(UserDTO user) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.insert");
	try {
    	if (user == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            user.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-USER.insert", user);

        return user.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Query DB table <tt>atom_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from atom_user</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long count() throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.count");
	try {

	    Long retObj = (Long) this.getSqlSession().selectOne("ATOM-USER.count", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_user where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return UserDTO
	 *	@throws DataAccessException
	 */	 
    public UserDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("ATOM-USER.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_user</tt>
	 *
	 *	@return List<UserDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UserDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-USER.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select uname from atom_user</tt>
	 *
	 *	@return List<String>
	 *	@throws DataAccessException
	 */	 
    public List<String> findName() throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.findName");
	try {

        return this.getSqlSession().selectList("ATOM-USER.findName", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_user where (uname = ?)</tt>
	 *
	 *	@param uname
	 *	@return UserDTO
	 *	@throws DataAccessException
	 */	 
    public UserDTO findByName(String uname) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.findByName");
	try {

        return this.getSqlSession().selectOne("ATOM-USER.findByName", uname);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_user set passwd=?, uemail=?, uflag=?, unick=? where (uname = ?)</tt>
	 *
	 *	@param user
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(UserDTO user) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.update");
	try {
    	if (user == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-USER.update", user);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_user set passwd=? where (uname = ?)</tt>
	 *
	 *	@param passwd
	 *	@param uname
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updatePasswd(String passwd, String uname) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.updatePasswd");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("passwd", passwd);
        param.put("uname", uname);

        return this.getSqlSession().update("ATOM-USER.updatePasswd", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_user set uemail=? where (uname = ?)</tt>
	 *
	 *	@param uemail
	 *	@param uname
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateUEmail(String uemail, String uname) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.updateUEmail");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("uemail", uemail);
        param.put("uname", uname);

        return this.getSqlSession().update("ATOM-USER.updateUEmail", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_user where (uname = ?)</tt>
	 *
	 *	@param uname
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String uname) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER.delete");
	try {

        return this.getSqlSession().delete("ATOM-USER.delete", uname);
	} finally {
		Profiler.release();
	}
}
}
