package com.test.uicconsumer;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.c2bmarket.domain.ResultDO;
import com.taobao.c2bmarket.domain.query.C2BReqQueryDO;
import com.taobao.c2bmarket.domain.result.C2BRequirementResultDO;
import com.taobao.c2bmarket.service.C2BQueryService;
import com.taobao.hsf.hsfunit.HSFEasyStarter;
import com.taobao.hsf.hsfunit.util.ServiceUtil;

public class C2BQueryInterfaceTest {

	@Test
	public void testBatchQueryRequirement() {
		HSFEasyStarter.start("d:/hsf/release", "");// 在用到consumer bean前启动hsf
		String springResourcePath = "spring-hsf-uic-consumer.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(springResourcePath);
		C2BQueryService c2bQueryService = (C2BQueryService) ctx	.getBean("c2bQueryService");
		ServiceUtil.waitServiceReady(c2bQueryService);// 不是必须，因为运行很快，所以要在configServer推地址下来前检测地址是否推下來，可以自己sleep(500)
		C2BReqQueryDO reqQuery = new C2BReqQueryDO();
		reqQuery.setReqId(973L);
		ResultDO<List<C2BRequirementResultDO>> rsList = c2bQueryService.batchQueryRequirement(reqQuery);
		
		System.out.println(rsList.getModule().size());
		
	}
	
	
}
