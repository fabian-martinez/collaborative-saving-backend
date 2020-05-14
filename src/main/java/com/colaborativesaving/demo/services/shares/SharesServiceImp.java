package com.colaborativesaving.demo.services.shares;

import com.colaborativesaving.demo.models.entities.Share;
import com.colaborativesaving.demo.models.share.ResponseShare;
import com.colaborativesaving.demo.models.share.ResponseShares;
import com.colaborativesaving.demo.repositories.SharesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SharesServiceImp implements SharesService{

    @Autowired
    private SharesRepository sharesRepository;

    @Override
    public ResponseShares GetShares() {
        List<Share> shares = new ArrayList<Share>();
        sharesRepository.findAll().forEach(shares::add);
        return new ResponseShares(shares);
    }

    @Override
    public ResponseShare GetShare(String type) {
        return new ResponseShare(sharesRepository.findByType(type));
    }

    @Override
    public ResponseShare CreateShare(Share share) {
        return new ResponseShare(sharesRepository.save(share));
    }

    @Override
    public ResponseShare DeleteShare(String type) {
        Share share = sharesRepository.findByType(type);
        sharesRepository.delete(share);
        return new ResponseShare(share);
    }
}
