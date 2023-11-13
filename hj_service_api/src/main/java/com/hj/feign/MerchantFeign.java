package com.hj.feign;

import com.hj.entity.GraceJSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "system")
@RequestMapping("/merchant")
public interface MerchantFeign {

    @GetMapping("/getMerchantName")
    public GraceJSONResult getMerchantName();
}
