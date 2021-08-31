package com.huaan9527.mall.webapi.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huaan9527.mall.webapi.domain.Carousel;
import com.huaan9527.mall.webapi.repository.CarouselRepository;
import com.huaan9527.mall.webapi.service.operation.api.CarouselListApi;
import com.huaan9527.mall.webapi.vos.CarouselVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CarouselService {

    private CarouselRepository carouselRepository;
    private CarouselListApi carouselListApi;


    public List<CarouselVo> list_bak() {
        List<Carousel> carouselList = carouselRepository.findByStatusOrderByCreatedDateDesc(1);
        return carouselList.stream().map(carousel -> {
            CarouselVo vo = new CarouselVo();
            BeanUtils.copyProperties(carousel, vo);
            vo.setId(carousel.getId());
            return vo;
        }).collect(Collectors.toList());
    }

    public List<CarouselVo> list() {
        JSONArray data = carouselListApi.get();
        return data.stream().map(object -> {
            JSONObject carousel = (JSONObject) object;
            CarouselVo vo = new CarouselVo();
            vo.setTitle(carousel.getString("topicName"));
            vo.setImage(carousel.getString("topicImage"));
            String url = carousel.getString("link");
            if(StringUtils.isNotBlank(url)){
                vo.setUrl(url);
            }
            return vo;
        }).collect(Collectors.toList());
    }
}
