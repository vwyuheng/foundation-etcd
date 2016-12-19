package net.basiccloud.etcd.internal;

import com.coreos.etcd3.api.RangeRequest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilTest {

    @Test
    public void test() throws Exception {
        // message to json
        RangeRequest rangeRequest = RangeRequest.newBuilder().setCountOnly(true).setLimit(100).build();
        String json = JsonUtil.message2Json(rangeRequest);
        //System.out.printf("json=" + json);

        // json to message
        RangeRequest.Builder builder = RangeRequest.newBuilder();
        JsonUtil.json2message(json, builder);
        assertThat(builder.getCountOnly()).isTrue();
        assertThat(builder.getLimit()).isEqualTo(100);
    }

}