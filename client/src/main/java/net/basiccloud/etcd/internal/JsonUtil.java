package net.basiccloud.etcd.internal;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message.Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;

/**
 * util class to convert between message and json.
 */
public class JsonUtil {

    private JsonUtil() {
        // no instance
    }

    /**
     * convert json to message.
     *
     * @param jsonContent content in json format
     * @param message message builder
     */
    public static void json2message(String jsonContent, Builder message) {
        try {
            JsonFormat.parser().merge(jsonContent, message);
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException("fail to parse json", e);
        }
    }

    /**
     * convert message to json.
     *
     * @param message message contains content
     * @return content in json format
     */
    public static String message2Json(MessageOrBuilder message) {
        try {
            return JsonFormat.printer().includingDefaultValueFields().print(message);
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException("fail to generate json", e);
        }
    }

}
