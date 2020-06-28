package com.yunmi.app.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunmi.app.common.BaseController;
import com.yunmi.app.constant.Constant;
import com.yunmi.app.model.crm.TbUser;
import com.yunmi.app.service.crm.TbUserService;
import com.yunmi.app.service.system.WyyxService;
import com.yunmi.app.utils.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 官方频道
 */
@RestController
@RequestMapping("/official/")
@Slf4j
public class OfficialMsgController extends BaseController {

    @Autowired
    private WyyxService wyyxService;

    @Autowired
    private TbUserService userService;

    /**
     * 发布官方消息
     * @param params
     * @return
     */
    @PostMapping("pub")
    public Map<String, Object> statistics(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        QueryWrapper<TbUser> userQuery = new QueryWrapper<>();
        userQuery.isNotNull("WYYX_TOKEN");
        String gender = MapUtil.getValueStr(params, "gender");
        if("0".equals(gender) || "1".equals(gender)){
            userQuery.eq("GENDER", gender);
        }
        userQuery.ne("ID", "7a537f382c0d4f74b55c83eba0b827cc");
        List<TbUser> users = this.userService.list(userQuery);

        List<String> userIds = new ArrayList<String>();
        users.forEach(user -> {
            userIds.add(user.getId());
        });
        try {
            String officialMsg = MapUtil.getValueStr(params, "officialMsg");
            this.wyyxService.sendOfficialMsg(userIds, officialMsg);
            result.put("code", Constant.RESULT_FLAG_SUCCESS);
        } catch (Exception e) {
            log.error(e.getMessage());
            result.put("code", Constant.RESULT_FLAG_FAIL);
            result.put("message", e.getMessage());
        }
        return result;

    }

}