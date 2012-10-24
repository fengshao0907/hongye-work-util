package com.test.uicconsumer;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.hsfunit.HSFEasyStarter;
import com.taobao.hsf.hsfunit.util.ServiceUtil;
import com.taobao.uic.common.domain.BaseUserDO;
import com.taobao.uic.common.service.userinfo.UicReadService;

public class AppTest {

	@Test
	public void testApp() {
		HSFEasyStarter.start("d:/hsf/release", "");//在用到consumer bean前启动hsf
		String springResourcePath = "spring-hsf-uic-consumer.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				springResourcePath);
		UicReadService uicReadService = (UicReadService) ctx
				.getBean("uicReadService");
		ServiceUtil.waitServiceReady(uicReadService);//不是必须，因为运行很快，所以要在configServer推地址下来前检测地址是否推下來，可以自己sleep(500)
		BaseUserDO user = uicReadService.getBaseUserByUserId(10000L, "detail")
				.getModule();
		System.out.println("user[id:10000L] nick:" + user.getNick());
	}
}
