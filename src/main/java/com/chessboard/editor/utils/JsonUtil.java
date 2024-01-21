package com.chessboard.editor.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.MapperFeature.USE_STD_BEAN_NAMING;

/**
 * 基于jackson库的JSON序列化、反序列化工具封装
 *
 * @author liupu
 */
public class JsonUtil {
    private static final ObjectMapper MAPPER;
    private static final int DEFAULT_LOG_LENGTH = 500;

    static {
        MAPPER = JsonMapper.builder()
                .configure(USE_STD_BEAN_NAMING, true)
                // 支持部分JSON5功能: 注释, key值引号, 尾部逗号等
                .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS)
                .enable(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES)
                .enable(JsonReadFeature.ALLOW_SINGLE_QUOTES)
                .enable(JsonReadFeature.ALLOW_TRAILING_COMMA)
                .build();
        // 忽略目标对象没有的属性
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public static String toJsonStr(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            LogUtil.info("toJsonStrFailed : " + e.getMessage());
        }
        return null;
    }

    public static Map<String, Object> toMap(String json) {
        try {
            return MAPPER.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            LogUtil.info("toMapFailed : " + e.getMessage());
        }
        return null;
    }

    public static <T> List<T> toJsonList(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            LogUtil.info("toJsonListFailed : " + e.getMessage());
        }
        return null;
    }

    /**
     * 提供截取json字符串长度的工具
     */
    public static String toJsonStrFixed(Object value, int len) {
        String json = toJsonStr(value);
        if (json == null || json.length() <= len) {
            return json;
        } else {
            return json.substring(0, len);
        }
    }

    /**
     * 为防止日志长度太大导致性能问题, 取一个默认的最大值(500字节)
     */
    public static String toJsonStrDefaultFixed(Object value) {
        return toJsonStrFixed(value, DEFAULT_LOG_LENGTH);
    }

    /**
     * 详细打印反序列化异常相关的日志
     */
    public static <T> T toBean(String json, Class<T> valueType) {
        if (StringUtils.isBlank(json)) return null;
        try {
            return MAPPER.readValue(json, valueType);
        } catch (Throwable throwable) {
            LogUtil.info("toBeanFailed : " + throwable.getMessage());
        }
        return null;
    }

    public static JsonNode getJsonNode(String json, String name) {
        if (StringUtils.isAnyBlank(json, name)) {
            return null;
        }
        try {
            JsonNode node = MAPPER.readTree(json);
            if (node != null) {
                return node.get(name);
            }
        } catch (JsonProcessingException e) {
            LogUtil.info("getNodeFailed : " + e.getMessage());
        }
        return null;
    }
}
