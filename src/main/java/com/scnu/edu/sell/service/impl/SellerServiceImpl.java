package com.scnu.edu.sell.service.impl;

import com.scnu.edu.sell.dataobject.SellerInfo;
import com.scnu.edu.sell.repository.SellerInfoRepository;
import com.scnu.edu.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hepengyu
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
