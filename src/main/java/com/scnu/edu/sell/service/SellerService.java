package com.scnu.edu.sell.service;

import com.scnu.edu.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * Created by hepengyu
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
