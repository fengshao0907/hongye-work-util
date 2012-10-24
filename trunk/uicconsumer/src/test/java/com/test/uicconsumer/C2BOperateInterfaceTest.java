package com.test.uicconsumer;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.c2bmarket.domain.ResultDO;
import com.taobao.c2bmarket.domain.dataobject.C2BReqReviewDO;
import com.taobao.c2bmarket.service.C2BOperateService;
import com.taobao.hsf.hsfunit.HSFEasyStarter;
import com.taobao.hsf.hsfunit.util.ServiceUtil;

public class C2BOperateInterfaceTest {

	private static final String appName = "test";
	
	@Test
	public void testReviewGroupBuyRequirement() {
		HSFEasyStarter.start("d:/hsf/release", "");// 在用到consumer bean前启动hsf
		String springResourcePath = "spring-hsf-uic-consumer.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(springResourcePath);
		
		C2BOperateService c2bOperateService = (C2BOperateService) ctx.getBean("c2bOperateService");
		ServiceUtil.waitServiceReady(c2bOperateService);// 不是必须，因为运行很快，所以要在configServer推地址下来前检测地址是否推下來，可以自己sleep(500)
		long reqId = 973L;
		long userId = 2029577068;
		int buyMode = 1;
		C2BReqReviewDO reqReviewDO = new C2BReqReviewDO(reqId, userId, buyMode,true);
		ResultDO<Boolean> result = c2bOperateService.reviewGroupBuyRequirement(reqReviewDO, appName);
		
		System.out.println(result.isSuccess());
	}
	
	
}
