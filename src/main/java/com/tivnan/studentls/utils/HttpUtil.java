package com.tivnan.studentls.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tivnan.studentls.bean.vo.OpenIDBean;
import org.apache.http.HttpStatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @project: studentls
 * @description: Http util
 * @author: tivnan
 * @create: 2020-2020/11/20-下午3:35
 * @version: 1.0
 **/
public class HttpUtil {

    public static String doGet(String urlPath, HashMap<String, Object> params)
            throws Exception {

        StringBuilder sb = new StringBuilder(urlPath);

        if (params != null && !params.isEmpty()) { // 说明有参数

            sb.append("?");

            Set<Entry<String, Object>> set = params.entrySet();

            for (Entry<String, Object> entry : set) { // 遍历map里面的参数
                String key = entry.getKey();
                String value = "";
                if (null != entry.getValue()) {
                    value = entry.getValue().toString();
                    // 转码
                    value = URLEncoder.encode(value, "UTF-8");
                }
                sb.append(key).append("=").append(value).append("&");
            }

            sb.deleteCharAt(sb.length() - 1); // 删除最后一个&
        }
        // System.out.println(sb.toString());
        URL url = new URL(sb.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000); // 5s超时
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == HttpStatus.SC_OK) {// HttpStatus.SC_OK ==
            // 200
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            StringBuilder sbs = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sbs.append(line);
            }
            return sbs.toString();
        }

        return null;
    }


    public static void main(String[] args) throws JsonProcessingException {

        String appID = "wx07026120b8ca5c85";
        String appSecret = "e4880f49fecea8a6b9fd49a9e5d4dc50";


        String code = "0830290w3GpRmV2J2T2w3lakIB30290z";
        String result = "";
        try {
            //请求微信服务器，用code换取openid。
            // HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session"
                            + "?appid=" + appID
                            + "&secret=" + appSecret
                            + "&js_code=" + code
                            + "&grant_type=authorization_code", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        OpenIDBean openIDBean = mapper.readValue(result, OpenIDBean.class);

        System.out.println(openIDBean);

        System.out.println(openIDBean.getOpenid());
    }
}
