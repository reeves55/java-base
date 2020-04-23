package jsonparse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: xiao
 * @date: 2020/4/24
 */
public class Main {
    public static void main(String[] args) {
        String jsonStr = "{\"employees\": [{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }]}";
        jsonStr = "[1,2,3]";
        jsonStr = "(3,4,5)";
        JSONObject jsonObj = JSON.parseObject(jsonStr);
        System.out.println(jsonObj);
    }
}
