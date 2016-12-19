package net.basiccloud.etcd.registry.internal.entity;

import com.google.common.base.Strings;
import net.basiccloud.etcd.internal.JsonUtil;
import net.basiccloud.registry.ServiceGroupInfo;
import net.basiccloud.registry.ServiceInfo;
import net.basiccloud.registry.ServiceInstanceData;
import net.basiccloud.registry.ServiceInstanceStatus;

/**
 * Value utility in etcd registry.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ValueUtil {

    public static ServiceInstanceDataEntity toEntity(ServiceInstanceData data) {
        ServiceInstanceDataEntity.Builder builder = ServiceInstanceDataEntity.newBuilder();
        if (!Strings.isNullOrEmpty(data.getServiceType())) {
            builder.setServiceType(data.getServiceType());
        }
        builder.setServiceVersion(data.getServiceVersion().toString());
        builder.setFrameworkVersion(data.getFrameworkVersion().toString());

        for (String tag : data.getTags()) {
            builder.addTags(tag);
        }
        builder.putAllPorts(data.getPorts());
        return builder.build();
    }

    public static ServiceInstanceData fromEntity(ServiceInstanceDataEntity entity) {
        ServiceInstanceData.Builder builder = ServiceInstanceData.newBuilder();
        if (!Strings.isNullOrEmpty(entity.getServiceType())) {
            builder.setServiceType(entity.getServiceType());
        }
        builder.setServiceVersion(entity.getServiceVersion());
        builder.setFrameworkVersion(entity.getFrameworkVersion());
        entity.getTagsList().forEach(builder::addTag);
        builder.addPort(entity.getPortsMap());
        return builder.build();
    }

    public static String toJson(ServiceInstanceData data) {
        ServiceInstanceDataEntity entity = toEntity(data);
        return JsonUtil.message2Json(entity);
    }

    public static ServiceInstanceStatusEntity toEntity(ServiceInstanceStatus status) {
        return ServiceInstanceStatusEntity.newBuilder()
                .setComment(status.getComment())
                .setLastUpdateTime(status.getLastUpdateTime())
                .setStatus(Status.valueOf(status.getStatus().toString()))
                .setLeaseId(status.getLeaseId())
                .build();
    }

    public static ServiceInstanceStatus fromEntity(ServiceInstanceStatusEntity entity) {
        return ServiceInstanceStatus.newBuilder()
                .setComment(entity.getComment())
                .setStatus(ServiceInstanceStatus.Status.valueOf(entity.getStatus().toString()))
                .setLastUpdateTime(entity.getLastUpdateTime())
                .setLeaseId(entity.getLeaseId()).build();
    }

    public static String toJson(ServiceInstanceStatus status) {
        ServiceInstanceStatusEntity entity = toEntity(status);
        return JsonUtil.message2Json(entity);
    }

    public static ServiceGroupInfoEntity toEntity(ServiceGroupInfo info) {
        return ServiceGroupInfoEntity.newBuilder().setDisplayName(info.getDisplayName())
                .setDepartment(info.getDepartment())
                .setDescription(info.getDescription()).build();

    }

    public static ServiceGroupInfo fromEntity(ServiceGroupInfoEntity entity) {
        return ServiceGroupInfo.newBuilder()
                .setDisplayName(entity.getDisplayName())
                .setDescription(entity.getDescription())
                .setDepartment(entity.getDepartment()).build();
    }

    public static String toJson(ServiceGroupInfo info) {
        ServiceGroupInfoEntity entity = toEntity(info);
        return JsonUtil.message2Json(entity);
    }

    public static ServiceInfoEntity toEntity(ServiceInfo info) {
        return ServiceInfoEntity.newBuilder().setDisplayName(info.getDisplayName())
                .setDescription(info.getDescription()).build();

    }

    public static ServiceInfo fromEntity(ServiceInfoEntity entity) {
        return ServiceInfo.newBuilder()
                .setDisplayName(entity.getDisplayName())
                .setDescription(entity.getDescription()).build();
    }

    public static String toJson(ServiceInfo info) {
        ServiceInfoEntity entity = toEntity(info);
        return JsonUtil.message2Json(entity);
    }

    public static ServiceInstanceData fromDataJson(String json) {
        ServiceInstanceDataEntity.Builder builder = ServiceInstanceDataEntity.newBuilder();
        JsonUtil.json2message(json, builder);
        return ValueUtil.fromEntity(builder.build());
    }

    public static ServiceInstanceStatus fromStatusJson(String json) {
        ServiceInstanceStatusEntity.Builder builder = ServiceInstanceStatusEntity.newBuilder();
        JsonUtil.json2message(json, builder);
        return ValueUtil.fromEntity(builder.build());
    }

    private ValueUtil() {
        // no instance
    }
}
