package me.zhengjie.utils; /**
 * Created by Super on 2020/8/21.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/21 17:12
 */
public class JsonDataUtils {

    public static String getJson(Object object){
        try {
            return   new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
