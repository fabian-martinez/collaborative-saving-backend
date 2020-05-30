package com.colaborativesaving.demo.shares.services;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestStock;
import com.colaborativesaving.demo.shares.model.ShareType;
import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.model.UserStockMapper;

import java.util.List;

public interface SharesService {
    public ShareType createShareType(ShareType shareType);
    public ShareType getShareType(String shareName);
    public List<ShareType> getShareTypes();
    public ShareType setShareType(String shareName, ShareType shareType);

    public UserStockMapper purchaseStock(RequestStock requestStock) throws Exception;
    public UserStockMapper retireStock(RequestStock requestRetireStock);

    public UserStockMapper getStockForUserAndShare(String userName, String shareName) throws Exception;
    public List<UserStockMapper> getAllStocksForUser(String userName);
    public List<UserStockMapper> getAllStocksForShare(String shareName);
    public List<UserStockMapper> getAllStocks();
}
