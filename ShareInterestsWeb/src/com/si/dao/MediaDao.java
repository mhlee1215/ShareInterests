package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Media;

@Repository
public class MediaDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Media> readMediaList(Media media) {
		List<Media> array = getSqlMapClientTemplate().queryForList("MediaSql.readMediaList", media);
		return array;
	}

	public Media readMedia(Media media) {
		return (Media)getSqlMapClientTemplate().queryForObject("MediaSql.readMedia", media);
	}

	public void createMedia(Media media) {
		getSqlMapClientTemplate().insert("UserSql.createMedia", media);
	}

	public void deleteMedia(Media media) {
		getSqlMapClientTemplate().delete("MediaSql.deleteMedia", media);
	}

	public void updateMedia(Media media) {
		getSqlMapClientTemplate().update("MediaSql.updateMedia", media);
	}
}
