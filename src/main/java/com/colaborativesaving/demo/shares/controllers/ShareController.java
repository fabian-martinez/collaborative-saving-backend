package com.colaborativesaving.demo.shares.controllers;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestChange;
import com.colaborativesaving.demo.shares.controllers.contracts.RequestPurchase;
import com.colaborativesaving.demo.shares.controllers.contracts.RequestRemovement;
import com.colaborativesaving.demo.shares.controllers.contracts.RequestShare;
import com.colaborativesaving.demo.shares.model.Share;

public interface ShareController {
    public Share createShareType(RequestShare requestShare);
    public Share getShare(String shareName);
    public Share getShares();
    public Share buyShare(String shareName, RequestPurchase purchase);
    public Share removeShare(String shareName, RequestRemovement removement);
    public Share changeShares(RequestChange requestChange);
}
