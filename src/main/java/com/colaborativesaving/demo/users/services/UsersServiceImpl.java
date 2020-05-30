package com.colaborativesaving.demo.users.services;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.repository.LoanRepository;
import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.repository.StockRepository;
import com.colaborativesaving.demo.users.model.*;
import com.colaborativesaving.demo.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public UsersMapper getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return new UsersMapper(users);
    }

    @Override
    public UserMapperWithGeneralInfo getUser(String userName) throws Exception {
        User user = userRepository.findByUserName(userName);
        List<Loan> loans = loanRepository.findByUserId(user.getId());
        List<UserStock> userStocks = stockRepository.findByUserId(user.getId());

        double totalLoans = 0;
        double totalStocks = 0;

        if (loans != null){
            totalLoans = loans.stream().mapToDouble(Loan::getTotal).sum();
        }
        if (loans != null){
            totalStocks = userStocks.stream().mapToDouble(userStock ->
                    userStock.getCnt() * userStock.getShare().getValue()).sum();
        }

        return new UserMapperWithGeneralInfo(user, totalLoans,totalStocks);
    }

    @Override
    public UserMapperWithGeneralInfo createUser(User user) throws Exception {
        user.setStatus(UserStatusEnum.FREE.getCode());
        user.setUpdate(new Date().getTime());
        return new UserMapperWithGeneralInfo(userRepository.save(user));
    }

    @Override
    public UserMapperWithGeneralInfo deleteUser(String userName) throws Exception {
        User deletedUser = userRepository.findByUserName(userName);
        userRepository.delete(deletedUser);
        return new UserMapperWithGeneralInfo(deletedUser);
    }
}
