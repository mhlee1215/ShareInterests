package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Asset;

@Repository
public class AssetDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Asset> readAssetList(Asset asset) {
		List<Asset> array = getSqlMapClientTemplate().queryForList("AssetSql.readAssetList", asset);
		return array;
	}

	public Asset readAsset(Asset asset) {
		return (Asset)getSqlMapClientTemplate().queryForObject("AssetSql.readAsset", asset);
	}

	public void createAsset(Asset asset) {
		getSqlMapClientTemplate().insert("AssetSql.createAsset", asset);
	}

	public void deleteAsset(Asset asset) {
		getSqlMapClientTemplate().delete("AssetSql.deleteAsset", asset);
	}

	public void updateAsset(Asset asset) {
		getSqlMapClientTemplate().update("AssetSql.updateAsset", asset);
	}
}
