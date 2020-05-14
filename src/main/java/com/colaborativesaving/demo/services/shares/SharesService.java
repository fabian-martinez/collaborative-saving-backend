package com.colaborativesaving.demo.services.shares;

import com.colaborativesaving.demo.models.entities.Share;
import com.colaborativesaving.demo.models.share.ResponseShare;
import com.colaborativesaving.demo.models.share.ResponseShares;

public interface SharesService {
    ResponseShares GetShares();

    ResponseShare GetShare(String user);

    ResponseShare CreateShare(Share share);

    ResponseShare DeleteShare(String user);
}
