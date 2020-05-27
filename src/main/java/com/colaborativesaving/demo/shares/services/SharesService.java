package com.colaborativesaving.demo.shares.services;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestStock;
import com.colaborativesaving.demo.shares.model.ShareType;
import com.colaborativesaving.demo.shares.model.UserStock;

import java.util.List;

public interface SharesService {
    public ShareType createShareType(ShareType shareType);
    public ShareType getShareType(String shareName);
    public List<ShareType> getShareTypes();
    public ShareType setShareType(String shareName, ShareType shareType);

    public UserStock purchaseStock(RequestStock requestStock) throws Exception;
    public UserStock retireStock(RequestStock requestRetireStock);
    public UserStock getStockForUser(String userName, String shareName) throws Exception;
    public List<UserStock> getAllStocksForUser(String userName);
    public List<UserStock> getAllStocksForShareType(String shareName);
    public List<UserStock> getAllStocks();
}
