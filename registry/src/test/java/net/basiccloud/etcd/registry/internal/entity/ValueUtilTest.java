package net.basiccloud.etcd.registry.internal.entity;

import net.basiccloud.etcd.internal.JsonUtil;
import net.basiccloud.registry.ServiceGroupInfo;
import net.basiccloud.registry.ServiceInfo;
import net.basiccloud.registry.ServiceInstanceData;
import net.basiccloud.registry.ServiceInstanceStatus;
import org.junit.Test;

import static net.basiccloud.registry.ServiceInstanceStatus.Status.ONLINE;
import static org.assertj.core.api.Assertions.assertThat;

public class ValueUtilTest {

   private static ServiceInstanceData data = ServiceInstanceData.newBuilder()
            .setServiceVersion("1.0.1")
            .setFrameworkVersion("1.0.0")
            .addTag("Demo", "Test")
            .addHttpPort(1080)
            .addPort(ServiceInstanceData.PROTOCOL_HTTPS, 1081)
            .build();

    private static ServiceInstanceStatus status = ServiceInstanceStatus.newBuilder()
            .setStatus(ONLINE)
            .setLastUpdateTime(System.currentTimeMillis())
            .setComment("OK")
            .setLeaseId(10001)
            .build();

    private static ServiceGroupInfo groupInfo = ServiceGroupInfo.newBuilder().setDisplayName("CoreGroup")
            .setDepartment("Dep1").setDescription("group core in dep1").build();

    private static ServiceInfo serviceInfo = ServiceInfo.newBuilder()
            .setDisplayName("User Service")
            .setDescription("user setService in Department1")
            .build();

    @Test
    public void testServiceInstanceData() throws Exception {
        ServiceInstanceDataEntity entity = ValueUtil.toEntity(data);
        assertThat(entity.getServiceType()).isEqualTo(data.getServiceType());
        assertThat(entity.getServiceVersion()).isEqualTo(data.getServiceVersion().toString());
        assertThat(entity.getFrameworkVersion()).isEqualTo(data.getFrameworkVersion().toString());
        assertThat(entity.getTagsList().toArray()).isEqualTo(data.getTags());
        assertThat(entity.getPortsMap()).isEqualTo(data.getPorts());

        String json = ValueUtil.toJson(data);
        //System.out.println("json=" + json);

        ServiceInstanceDataEntity.Builder newBuilder = ServiceInstanceDataEntity.newBuilder();
        JsonUtil.json2message(json, newBuilder);
        ServiceInstanceDataEntity entity2 = newBuilder.build();
        assertThat(entity.getServiceType()).isEqualTo(entity2.getServiceType());
        assertThat(entity.getServiceVersion()).isEqualTo(entity2.getServiceVersion());
        assertThat(entity.getFrameworkVersion()).isEqualTo(entity2.getFrameworkVersion());
        assertThat(entity.getTagsList().toArray()).isEqualTo(entity2.getTagsList().toArray());
        assertThat(entity.getPortsMap()).isEqualTo(entity2.getPortsMap());
    }


    @Test
    public void testServiceInstanceStatus() throws Exception {
        ServiceInstanceStatusEntity entity = ValueUtil.toEntity(status);
        assertThat(entity.getStatus().toString()).isEqualTo(status.getStatus().toString());
        assertThat(entity.getLastUpdateTime()).isEqualTo(status.getLastUpdateTime());
        assertThat(entity.getComment()).isEqualTo(status.getComment());
        assertThat(entity.getLeaseId()).isEqualTo(status.getLeaseId());

        String json = ValueUtil.toJson(status);
        //System.out.println("json=" + json);

        ServiceInstanceStatusEntity.Builder newBuilder = ServiceInstanceStatusEntity.newBuilder();
        JsonUtil.json2message(json, newBuilder);
        ServiceInstanceStatusEntity entity2 = newBuilder.build();
        assertThat(entity.getStatus()).isEqualTo(entity2.getStatus());
        assertThat(entity.getLastUpdateTime()).isEqualTo(entity2.getLastUpdateTime());
        assertThat(entity.getComment()).isEqualTo(entity2.getComment());
        assertThat(entity.getLeaseId()).isEqualTo(entity2.getLeaseId());
    }

    @Test
    public void testGroupInfo() throws Exception {
        ServiceGroupInfoEntity entity = ValueUtil.toEntity(groupInfo);
        assertThat(entity.getDisplayName()).isEqualTo(groupInfo.getDisplayName());
        assertThat(entity.getDepartment()).isEqualTo(groupInfo.getDepartment());
        assertThat(entity.getDescription()).isEqualTo(groupInfo.getDescription());

        String json = ValueUtil.toJson(groupInfo);
        //System.out.println("json=" + json);

        ServiceGroupInfoEntity.Builder newBuilder = ServiceGroupInfoEntity.newBuilder();
        JsonUtil.json2message(json, newBuilder);
        ServiceGroupInfoEntity entity2 = newBuilder.build();
        assertThat(entity.getDisplayName()).isEqualTo(entity2.getDisplayName());
        assertThat(entity.getDepartment()).isEqualTo(entity2.getDepartment());
        assertThat(entity.getDescription()).isEqualTo(entity2.getDescription());
    }

    @Test
    public void testServiceInfo() throws Exception {
        ServiceInfoEntity entity = ValueUtil.toEntity(serviceInfo);
        assertThat(entity.getDisplayName()).isEqualTo(serviceInfo.getDisplayName());
        assertThat(entity.getDescription()).isEqualTo(serviceInfo.getDescription());

        String json = ValueUtil.toJson(serviceInfo);
        //System.out.println("json=" + json);

        ServiceInfoEntity.Builder newBuilder = ServiceInfoEntity.newBuilder();
        JsonUtil.json2message(json, newBuilder);
        ServiceInfoEntity entity2 = newBuilder.build();
        assertThat(entity.getDisplayName()).isEqualTo(entity2.getDisplayName());
        assertThat(entity.getDescription()).isEqualTo(entity2.getDescription());
    }
}