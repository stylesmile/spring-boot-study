package com.futve.common.tools;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futve.common.constant.ArtCommonConstant;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.text.SimpleDateFormat;

/**
 * 序列化常用类
 *
 * @since luoka @ 2015年6月2日 下午1:53:45
 */
public class JsonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance(ArtCommonConstant.FormatConfig.FORMAT4DISPLAY);
    static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(ArtCommonConstant.FormatConfig.FORMAT4DISPLAY));
    }

    private JsonUtil() {
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            LOG.warn("serialize object has error", e);
        }
        return "";
    }

    public static <T> T fromJson(String content, Class<T> type) {
        try {
            return mapper.readValue(content, type);
        } catch (Exception e) {
            LOG.warn("serialize parse value[" + content + "] to object has error", e);
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static <T> T fromJson(String content, TypeReference valueTypeRef) {
        try {
            return (T)mapper.readValue(content, valueTypeRef);
        } catch (Exception e) {
            LOG.warn("serialize parse value[" + content + "] to object has error", e);
            return null;
        }
    }

    /**
     * 序列化工具类
     * @author pc
     *
     */
    public static class SerializeHelper {
        private static Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        static {
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
        }

        /**
         * 序列化对象
         *
         * @param object
         * @return
         */
        public static byte[] serialize(Object object) {
            return jackson2JsonRedisSerializer.serialize(object);
        }

        public static void main(String[] args) {
            System.out.println(new String(serialize("ssjdjshdsj")));
        }

        /**
         * 反序列化对象
         *
         * @return
         */
        public static <T> T deserialize(byte[] value) {
            return (T) jackson2JsonRedisSerializer.deserialize(value);
        }
    }
}
