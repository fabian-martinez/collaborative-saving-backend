package com.colaborativesaving.demo.shares.services;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestStock;
import com.colaborativesaving.demo.shares.model.ShareType;
import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.repository.ShareTypeDB;
import com.colaborativesaving.demo.shares.repository.ShareTypeRepository;
import com.colaborativesaving.demo.shares.model.StockDB;
import com.colaborativesaving.demo.shares.repository.StockRepository;
import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SharesServiceImpl implements SharesService {

    @Autowired
    private ShareTypeRepository shareTypeRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private UsersService usersService;

    @Override
    public ShareType createShareType(ShareType shareType) {
        ShareTypeDB shareTypeDB = new ShareTypeDB();
        shareTypeDB.setShareType(shareType);
        return shareTypeRepository.save(shareTypeDB).getshareType();
    }

    @Override
    public ShareType getShareType(String shareName) {
        ShareTypeDB shareTypeDB = shareTypeRepository.findByName(shareName);
        return shareTypeDB.getshareType();
    }

    @Override
    public List<ShareType> getShareTypes() {
        List<ShareType> shares = new ArrayList<ShareType>();
        shareTypeRepository.findAll().forEach(shareDB -> {
            try {
                shares.add(shareDB.getshareType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return shares;
    }

    @Override
    public ShareType setShareType(String shareName, ShareType shareType) {
        ShareTypeDB shareTypeDB = shareTypeRepository.findByName(shareName);
        shareTypeDB.setContribution(shareType.getContribution());
        return shareTypeRepository.save(shareTypeDB).getshareType();
    }

    @Override
    public UserStock purchaseStock(RequestStock requestStock) throws Exception {
        try {
            User user = usersService.getUser(requestStock.getUserName());
            ShareType shareType = this.getShareType(requestStock.getShareType());
            UserStock stock = stockRepository.findByUserAndShare(
                    user.getUserName(),shareType.getShareName()).getUserStock();
            stock.setCnt(stock.getCnt() + requestStock.getCnt());
            StockDB stockDB = stockRepository.findByUserAndShare(user.getUserName(),shareType.getShareName());
            stockDB.setUserStock(stock);
            return stockRepository.save(stockDB).getUserStock();
        } catch (IllegalArgumentException ex){
            User user = usersService.getUser(requestStock.getUserName());
            ShareType shareType = this.getShareType(requestStock.getShareType());
            UserStock stock = new UserStock();
            stock.setUser(user);
            stock.setShare(shareType);
            stock.setCnt(requestStock.getCnt());
            return stockRepository.save(new StockDB(stock)).getUserStock();
        }
    }

    @Override
    public UserStock retireStock(RequestStock requestRetireStock) {
        try {
            User user = usersService.getUser(requestRetireStock.getUserName());
            ShareType shareType = this.getShareType(requestRetireStock.getShareType());
            UserStock stock = stockRepository.findByUserAndShare(
                    user.getUserName(),shareType.getShareName()).getUserStock();
            StockDB stockDB = stockRepository.findByUserAndShare(user.getUserName(),shareType.getShareName());
            if (stock.getCnt() == requestRetireStock.getCnt()){
                stockRepository.delete(stockDB);
                return stockDB.getUserStock();
            }else {
                stock.setCnt(stock.getCnt() - requestRetireStock.getCnt());
                stockDB.setUserStock(stock);
                return stockRepository.save(stockDB).getUserStock();
            }

        } catch (Exception e) {
            throw new Error("Error");
        }
    }

    @Override
    public UserStock getStockForUser(String userName, String shareName) throws Exception {
        return stockRepository.findByUserAndShare(userName,shareName).getUserStock();
    }

    @Override
    public List<UserStock> getAllStocksForUser(String userName) {
        List<UserStock> userStocks = new ArrayList<>();
        stockRepository.findByShare(userName).forEach(stockDB -> {
            try {
                userStocks.add(stockDB.getUserStock());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return userStocks;
    }

    @Override
    public List<UserStock> getAllStocksForShareType(String shareName) {
        List<UserStock> userStocks = new ArrayList<>();
        stockRepository.findByShare(shareName).forEach(stockDB -> {
            try {
                userStocks.add(stockDB.getUserStock());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return userStocks;
    }

    @Override
    public List<UserStock> getAllStocks() {
        List<UserStock> userStocks = new ArrayList<>();
        stockRepository.findAll().forEach(stockDB -> {
            try {
                userStocks.add(stockDB.getUserStock());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return userStocks;
    }
}
