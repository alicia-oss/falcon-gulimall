package com.gulimail.member;

import com.gulimail.common.utils.R;
import com.gulimail.member.feign.CouponController;
import com.gulimail.member.service.MemberService;
import com.gulimail.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimailMemberApplicationTests {

  @Autowired
  MemberServiceImpl memberService;

  @Autowired
  CouponController couponController;
  @Test
  void contextLoads() {

  }

}
