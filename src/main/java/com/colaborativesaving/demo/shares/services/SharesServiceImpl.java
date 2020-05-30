package com.colaborativesaving.demo.shares.services;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestStock;
import com.colaborativesaving.demo.shares.model.ShareType;
import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.model.UserStockMapper;
import com.colaborativesaving.demo.shares.repository.ShareTypeRepository;
import com.colaborativesaving.demo.shares.repository.StockRepository;
import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private UsersService usersService;

    @Override
    public ShareType createShareType(ShareType shareType) {
        return shareTypeRepository.save(shareType);
    }

    @Override
    public ShareType getShareType(String shareName) {
        ShareType shareType = shareTypeRepository.findByName(shareName);
        return shareType;
    }

    @Override
    public List<ShareType> getShareTypes() {
        List<ShareType> shares = new ArrayList<ShareType>();
        shareTypeRepository.findAll().forEach(share -> {
            try {
                shares.add(share);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return shares;
    }

    @Override
    public ShareType setShareType(String shareName, ShareType shareType) {
        ShareType shareTypeDB = shareTypeRepository.findByName(shareName);
        shareTypeDB.setContribution(shareType.getContribution());
        return shareTypeRepository.save(shareTypeDB);
    }

    @Override
    public UserStockMapper purchaseStock(RequestStock requestStock) throws Exception {
        User user = userRepository.findByUserName(requestStock.getUserName());
        ShareType shareType = this.getShareType(requestStock.getShareType());
        UserStock userStock = stockRepository.findByUserIdAndShareId(user.getId(),shareType.getId());
        if (userStock == null){
            userStock = new UserStock();
        }
        userStock.setUser(user);
        userStock.setShare(shareType);
        userStock.setCnt(userStock.getCnt() + requestStock.getCnt());
        return new UserStockMapper(stockRepository.save(userStock));
    }

    @Override
    public UserStockMapper retireStock(RequestStock requestStock) {
        User user = userRepository.findByUserName(requestStock.getUserName());
        ShareType shareType = this.getShareType(requestStock.getShareType());
        UserStock userStock = stockRepository.findByUserIdAndShareId(user.getId(),shareType.getId());
        if (userStock.getCnt() == requestStock.getCnt()){
            stockRepository.delete(userStock);
            return null;
        }else {
            userStock.setCnt(userStock.getCnt() - requestStock.getCnt());
            return new UserStockMapper(stockRepository.save(userStock));
        }

    }

    @Override
    public UserStockMapper getStockForUser(String userName, String shareName) throws Exception {
        //TODO: Validar cual es share y  cual es user
        User user = userRepository.findByUserName(userName);
        ShareType shareType = this.getShareType(shareName);
        return new UserStockMapper(stockRepository.findByUserIdAndShareId(user.getId(),shareType.getId()));
    }

    @Override
    public List<UserStockMapper> getAllStocksForUser(String userName) {
        User user = userRepository.findByUserName(userName);
        List<UserStockMapper> userStocks = new ArrayList<>();
        stockRepository.findByUserId(user.getId()).forEach(stock -> {
            try {
                userStocks.add(new UserStockMapper(stock));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return userStocks;
    }

    @Override
    public List<UserStockMapper> getAllStocksForShareType(String shareName) throws Exception {
        List<UserStockMapper> userStocks = new ArrayList<>();
        ShareType shareType = shareTypeRepository.findByName(shareName);
        stockRepository.findByShareId(shareType.getId()).forEach(stock -> {
            try {
                userStocks.add(new UserStockMapper(stock));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return userStocks;
    }

    @Override
    public List<UserStockMapper> getAllStocks() {
        List<UserStockMapper> userStocks = new ArrayList<>();
        stockRepository.findAll().forEach(stock -> {
            try {
                userStocks.add(new UserStockMapper(stock));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return userStocks;
    }
}
