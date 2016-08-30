package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.AssetDao;
import com.si.domain.Asset;

@Service
public class AssetService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private AssetDao assetDao;

	public List<Asset> readAssetList(Asset asset) {
		return assetDao.readAssetList(asset);
	}

	public Asset readAsset(Asset asset) {
		return assetDao.readAsset(asset);
	}

	public void createAsset(Asset asset) {
		assetDao.createAsset(asset);
	}

	public void deleteAsset(Asset asset) {
		assetDao.deleteAsset(asset);
	}

	public void updateAsset(Asset asset) {
		assetDao.updateAsset(asset);
	}

}
