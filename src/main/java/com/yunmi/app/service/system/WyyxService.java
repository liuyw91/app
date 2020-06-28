package com.yunmi.app.service.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>网易云信服务</p>
 *
 * @author sunming
 * @date 2019年10月15日
 */
@Service
@Slf4j
public class WyyxService {


    @Value("${wyyx.appKey}")
    private String appKey;

    @Value("${wyyx.secret}")
    private String appSecret;

    @Value("${qiniu.domain}")
    private String qiniuDomain;

    /**
     * 注册
     */
    private static final String WYYX_URL_REGISTER = "https://api.netease.im/nimserver/user/create.action";

    /**
     * 发送普通消息
     */
    private static final String WYYX_URL_SIMPLE_MESSAGE = "https://api.netease.im/nimserver/msg/sendMsg.action";

    /**
     * 获取名片信息
     */
    private static final String WYYX_URL_GET_USER_INFO = "https://api.netease.im/nimserver/user/getUinfos.action";
    
    /**
     * 更新名片信息
     */
    private static final String WYYX_URL_UPDATE_USER_INFO = "https://api.netease.im/nimserver/user/updateUinfo.action";

    /**
     * 添加好友关系
     */
    private static final String WYYX_URL_ADD_FRIEND = "https://api.netease.im/nimserver/friend/add.action";

    /**
     * 获取好友关系
     */
    private static final String WYYX_URL_GET_FRIEND = "https://api.netease.im/nimserver/friend/get.action";
    
    /**
     * 点对点批量发送自定义系统通知
     */
    private static final String WYYX_URL_SEND_BATCH_ATTACH_MSG = "https://api.netease.im/nimserver/msg/sendBatchAttachMsg.action";
    
    /**
     * 点对点批量发送普通消息
     */
    private static final String WYYX_URL_SEND_NORMAL_MSG = "https://api.netease.im/nimserver/msg/sendBatchMsg.action";

    /**
     * 网易云信注册
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public String wyyxRegister(String userId) throws Exception {
        // 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("accid", userId));

        //请求
        String response = this.doPost(paramList, WYYX_URL_REGISTER);

        log.info("网易云信" + userId);
        log.info("网易云信" + response);

        JSONObject responseJson = JSONObject.parseObject(response);
        if ("200".equals(responseJson.getString("code"))) {
            JSONObject infoJson = JSONObject.parseObject(responseJson.getString("info"));
            return infoJson.getString("token");
        }
        return null;
    }

    /**
     * 网易云信发送打招呼消息
     *
     * @param fromUserId
     * @param toUserId
     * @param msgContent
     * @return
     * @throws Exception
     */
    public JSONObject wyyxSendMsg(String fromUserId, String toUserId, String msgContent) throws Exception {
    	msgContent = "{\"msg\":\"" + msgContent + "\"}";
        // 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("from", fromUserId));
        paramList.add(new BasicNameValuePair("to", toUserId));
        paramList.add(new BasicNameValuePair("body", msgContent));
        paramList.add(new BasicNameValuePair("ope", "0"));
        paramList.add(new BasicNameValuePair("type", "0"));

        // 请求
        String response = this.doPost(paramList, WYYX_URL_SIMPLE_MESSAGE);

        log.info("网易云信发送者id:" + fromUserId);
        log.info("网易云信接收者id:" + toUserId);
        log.info("网易云信内容:" + msgContent);
        log.info("网易云信返回结果:" + response);

        JSONObject responseJson = JSONObject.parseObject(response);
        if ("200".equals(responseJson.getString("code"))) {
            return JSONObject.parseObject(responseJson.getString("data"));
        }
        return null;
    }

    /**
     * 获取用户名片信息
     * @param accId
     * @throws Exception
     */
	public String getUserInfo(String accId) throws Exception {
		 // 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("accids", "[\"" + accId + "\"]"));

        // 请求
        String response = this.doPost(paramList, WYYX_URL_GET_USER_INFO);

        JSONObject responseJson = JSONObject.parseObject(response);
        if ("200".equals(responseJson.getString("code"))) {
            return responseJson.getString("uinfos");
        }
        return null;
	}


    /**
     * 网易云信头像或姓名更新
     *
     * @param accId icon \\ name
     * @return
     * @throws Exception
     */
    public String wyyxUpdateIconName(String accId, String icon, String name) throws Exception {
        // 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("accid", accId));
        if (!StringUtils.isBlank(icon)) {
            paramList.add(new BasicNameValuePair("icon", qiniuDomain + "/" + icon));
        }
        if (!StringUtils.isBlank(name)) {
            paramList.add(new BasicNameValuePair("name", name));
        }

        //请求
        String response = this.doPost(paramList, WYYX_URL_UPDATE_USER_INFO);

        log.info("网易云信" + accId);
        log.info("网易云信返回结果" + response);

        JSONObject responseJson = JSONObject.parseObject(response);
        if ("200".equals(responseJson.getString("code"))) {
            return responseJson.getString("code");
        }
        return null;
    }

    /**
     * 网易云信用户添加好友关系
     *
     * @param fromUserId
     * @param toUserId
     * @throws Exception
     */
    public void wyyxAddFriend(String fromUserId, String toUserId) throws Exception {
        // 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("accid", fromUserId));
        paramList.add(new BasicNameValuePair("faccid", toUserId));
        paramList.add(new BasicNameValuePair("type", "1"));

        // 请求
        String response = this.doPost(paramList, WYYX_URL_ADD_FRIEND);

        log.info("网易云信发起好友请求用户id:" + fromUserId);
        log.info("网易云信接收好友请求用户id:" + toUserId);
        log.info("网易云信返回结果:" + response);
    }

    /**
     * 网易云信获取用户好友关系
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public JSONObject wyyxGetFriends(String userId) throws Exception {
        // 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("accid", userId));
        paramList.add(new BasicNameValuePair("updatetime", String.valueOf(System.currentTimeMillis() - 10000000)));

        // 请求
        String response = this.doPost(paramList, WYYX_URL_GET_FRIEND);

        log.info("网易云信用户id:" + userId);
        log.info("网易云信返回结果:" + response);

        JSONObject responseJson = JSONObject.parseObject(response);
        if ("200".equals(responseJson.getString("code"))) {
            return responseJson.getJSONObject("friends");
        }
        return null;
    }

    /**
     * 发送官方消息
     * @throws Exception
     */
	public void sendOfficialMsg(List<String> userIds, String msgContent) throws Exception {
		msgContent = "{\"msg\":\"" + msgContent + "\"}";

		// 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("fromAccid", "7a537f382c0d4f74b55c83eba0b827cc"));
        paramList.add(new BasicNameValuePair("toAccids", JSON.toJSONString(userIds)));
        paramList.add(new BasicNameValuePair("type", "0"));
        paramList.add(new BasicNameValuePair("body", msgContent));
        // 请求
        String response = this.doPost(paramList, WYYX_URL_SEND_NORMAL_MSG);
        JSONObject responseJson = JSONObject.parseObject(response);
        System.out.println("wyyx_sendOfficialMsg:" + responseJson.getString("code"));
	}



	/**
     * 发送自定义通知
     * @param userIds
     * @throws Exception
     */
	public void sendCustomNotice(List<String> userIds) throws Exception {
		// 创建参数列表
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("fromAccid", "7a537f382c0d4f74b55c83eba0b827cc"));
        paramList.add(new BasicNameValuePair("toAccids", JSON.toJSONString(userIds)));
        paramList.add(new BasicNameValuePair("attach", "这是云觅官方频道"));
        paramList.add(new BasicNameValuePair("pushcontent", "这是云觅官方频道"));
        // 请求
        String response = this.doPost(paramList, WYYX_URL_SEND_BATCH_ATTACH_MSG);
        JSONObject responseJson = JSONObject.parseObject(response);
        System.out.println("wyyx_sendOfficialMsg:" + responseJson.getString("code"));
	}

    /**
     * sha1加密
     *
     * @param algorithm
     * @param value
     * @return
     */
    private String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest
                    = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * POST请求
     * 网易云信请求公共方法
     */
    private String doPost(List<NameValuePair> paramList, String httpsUrl) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
        	//随机数
            String nonce = UUID.randomUUID().toString().replaceAll("-", "");

            //当前UTC时间戳
            Date date = new Date();
            String curTime = String.valueOf(date.getTime());
            curTime = curTime.substring(0, curTime.length() - 3);

            //checkSum
            String checkSum = encode("sha1", appSecret + nonce + curTime);

            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(httpsUrl);
            // 设置请求的header
            httpPost.addHeader("AppKey", appKey);
            httpPost.addHeader("Nonce", nonce);
            httpPost.addHeader("CurTime", curTime);
            httpPost.addHeader("CheckSum", checkSum);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

	

    

}
