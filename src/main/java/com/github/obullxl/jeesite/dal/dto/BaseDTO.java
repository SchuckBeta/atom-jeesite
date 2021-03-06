/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.dto;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.obullxl.lang.ToString;

/**
 * Base class for all data objects.
 */
public abstract class BaseDTO extends ToString {
	private static final long serialVersionUID = 2534171338675523870L;

    /** 创建时间 */
    protected Date                gmtCreate;

    /** 修改时间 */
    protected Date                gmtModify;

    /** 扩展数据 */
    protected Map<String, Object> extData          = new ConcurrentHashMap<String, Object>();

    // ~~~~~~~~~~~ 扩展数据 ~~~~~~~~~~~ //

    @SuppressWarnings("unchecked")
    public <T> T findExtData(String key) {
        Object value = this.extData.get(key);
        if (value == null) {
            return null;
        }

        return (T) value;
    }

    @SuppressWarnings("unchecked")
    public <T> T findExtData(String key, Class<T> clz) {
        Object value = this.extData.get(key);

        if (value != null && clz.isAssignableFrom(value.getClass())) {
            return (T) value;
        }

        return null;
    }

    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Map<String, Object> getExtData() {
        if (this.extData == null) {
            this.extData = new ConcurrentHashMap<String, Object>();
        }

        return extData;
    }

    public void setExtData(Map<String, Object> extData) {
        this.extData = extData;
    }
	
}
