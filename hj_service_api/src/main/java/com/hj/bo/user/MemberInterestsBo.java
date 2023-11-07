package com.hj.bo.user;

import lombok.Data;

@Data
public class MemberInterestsBo {

    private Long interestsId;

    private String name;

    private String info;

    private Integer brokerageLevel;

    private String pic;
}
