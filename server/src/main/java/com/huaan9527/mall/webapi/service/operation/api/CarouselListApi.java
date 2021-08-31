package com.huaan9527.mall.webapi.service.operation.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtk.main.ApiClient;
import com.huaan9527.mall.webapi.configuration.properties.DaTaoKeProperties;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName CarouselListApi
 * @Author linrol
 * @date 2021年08月31日 10:35 Copyright (c) 2020, linrol@77hub.com All Rights Reserved.
 */
@Slf4j
@Component
public class CarouselListApi extends AbstractDaTaoKeApi {

  private static final String url = "https://openapi.dataoke.com/api/goods/topic/carouse-list";

  public CarouselListApi(
      DaTaoKeProperties daTaoKeProperties) {
    super(daTaoKeProperties);
  }

  public JSONArray get() {
    TreeMap<String, String> params = createParams();
    String body = ApiClient.sendReq(url, daTaoKeProperties.getAppSecret(), params);
    JSONObject result = JSON.parseObject(body);
    if (result.getInteger("code") != 0) {
      log.error("查询轮播图失败, body:{}", body);
      return null;
    }
    return result.getJSONArray("data");
  }
}
