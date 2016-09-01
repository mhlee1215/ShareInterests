package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Bookmark;

@Repository
public class BookmarkDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Bookmark> readBookmarkList(Bookmark bookmark) {
		List<Bookmark> array = getSqlMapClientTemplate().queryForList("BookmarkSql.readBookmarkList", bookmark);
		return array;
	}

	public Bookmark readBookmark(Bookmark bookmark) {
		return (Bookmark)getSqlMapClientTemplate().queryForObject("BookmarkSql.readBookmark", bookmark);
	}

	public void createBookmark(Bookmark bookmark) {
		getSqlMapClientTemplate().insert("BookmarkSql.createBookmark", bookmark);
	}

	public void deleteBookmark(Bookmark bookmark) {
		getSqlMapClientTemplate().delete("BookmarkSql.deleteBookmark", bookmark);
	}

	public void updateBookmark(Bookmark bookmark) {
		getSqlMapClientTemplate().update("BookmarkSql.updateBookmark", bookmark);
	}
}
