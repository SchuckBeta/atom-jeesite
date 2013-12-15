package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.TopicDAO;

import java.util.Map;
import com.github.obullxl.jeesite.dal.dto.TopicDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.TopicDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Sat Dec 14 16:07:28 CST 2013.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisTopicDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements TopicDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }

	/**
	 *  Insert one <tt>TopicDTO</tt> object to DB table <tt>atom_topic</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_topic(id,state,catg,tflag,rflag,rfrom,mflag,mpath,mcount,treply,visit,reply,title,summary,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param topic
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(TopicDTO topic) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.insert");
	try {
    	if (topic == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            topic.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set TicketID exception.", e);
        }

        this.getSqlSession().insert("ATOM-TOPIC.insert", topic);

        return topic.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Query DB table <tt>atom_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_topic where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return TopicDTO
	 *	@throws DataAccessException
	 */	 
    public TopicDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("ATOM-TOPIC.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_topic</tt>
	 *
	 *	@return List<TopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<TopicDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-TOPIC.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_topic where (catg = 'CATG')</tt>
	 *
	 *	@param catg
	 *	@param offset
	 *	@param limit
	 *	@return List<TopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<TopicDTO> findCatgPage(String catg, int offset, int limit) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.findCatgPage");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("offset", new Integer(offset));
        param.put("limit", new Integer(limit));

        return this.getSqlSession().selectList("ATOM-TOPIC.findCatgPage", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from atom_topic where (catg = 'CATG')</tt>
	 *
	 *	@param value
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findCatgPageCount(String value) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.findCatgPageCount");
	try {

	    Long retObj = (Long) this.getSqlSession().selectOne("ATOM-TOPIC.findCatgPageCount", value);

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
	 *  Query DB table <tt>atom_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_topic where (catg = 'CATG')</tt>
	 *
	 *	@param catg
	 *	@param size
	 *	@return List<TopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<TopicDTO> findTopVisit(String catg, int size) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.findTopVisit");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("size", new Integer(size));

        return this.getSqlSession().selectList("ATOM-TOPIC.findTopVisit", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_topic where (catg = 'CATG')</tt>
	 *
	 *	@param catg
	 *	@param size
	 *	@return List<TopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<TopicDTO> findTopReply(String catg, int size) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.findTopReply");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("size", new Integer(size));

        return this.getSqlSession().selectList("ATOM-TOPIC.findTopReply", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_topic set catg=?, tflag=?, rflag=?, rfrom=?, mflag=?, mpath=?, treply=?, title=?, summary=?, content=? where (id = ?)</tt>
	 *
	 *	@param topic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(TopicDTO topic) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.update");
	try {
    	if (topic == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-TOPIC.update", topic);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_topic set visit='visit+1', gmt_modify='NOW' where (id = '1')</tt>
	 *
	 *	@param id
	 *	@param count
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateVisit(long id, int count) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.updateVisit");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", new Long(id));
        param.put("count", new Integer(count));

        return this.getSqlSession().update("ATOM-TOPIC.updateVisit", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_topic set reply='reply+1', gmt_modify='NOW' where (id = '1')</tt>
	 *
	 *	@param id
	 *	@param count
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateReply(long id, int count) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.updateReply");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", new Long(id));
        param.put("count", new Integer(count));

        return this.getSqlSession().update("ATOM-TOPIC.updateReply", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_topic where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-TOPIC.delete");
	try {
        Long param = new Long(id);

        return this.getSqlSession().delete("ATOM-TOPIC.delete", param);
	} finally {
		Profiler.release();
	}
}
}