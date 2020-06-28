package com.yunmi.app;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunmi.app.model.crm.TbUser;
import com.yunmi.app.service.crm.TbUserService;
import com.yunmi.app.service.system.WyyxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SunmTest {
	
	@Autowired
	private WyyxService wyyxService;

	@Autowired
	private TbUserService userService;

	@Test
	public void test7() throws Exception {
		QueryWrapper<TbUser> userQuery = new QueryWrapper<>();
		userQuery.isNotNull("WYYX_TOKEN");
		userQuery.ne("ID", "7a537f382c0d4f74b55c83eba0b827cc");
		List<TbUser> users = this.userService.list(userQuery);
		
		List<String> userIds = new ArrayList<String>();
		users.forEach(user -> {
			userIds.add(user.getId());
		});
		this.wyyxService.sendOfficialMsg(userIds, "云觅客服上线了，请各位小伙伴多多支持");
//		this.wyyxService.sendCustomNotice(userIds);
		
	}
}
