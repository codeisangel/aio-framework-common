package cn.aio1024.framework.basic.domain.utils.reflect;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.aio1024.framework.basic.domain.annotations.KgoField;
import cn.aio1024.framework.basic.domain.annotations.KgoParam;
import cn.aio1024.framework.basic.domain.entity.field.KgoFieldDesc;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhenming
 * @desc: 反射字段工具
 * @date 2023/7/22 21:16
 */
public class KgoFieldUtils {
    /**
     * 解析类类型JSONPath
     *
     * @param aClass: 类类型
     * @return java.util.Map<java.lang.String,cn.aio1024.framework.basic.domain.entity.field.KgoFieldDesc>
     **/
    public static Map<String,KgoFieldDesc> parseClass(Class aClass){
        Map<String,KgoFieldDesc> fieldMap = new HashMap<>(10);
        parseClassFields(fieldMap,aClass,null);
        return fieldMap;
    }

    /**
     * 解析字段
     *
     * @param fieldMap: Key为对象JSONPath，Value 为字段描述
     * @param aClass: 类类型
     * @param parentName: 父字段Path
     * @return void
     **/
    private static void parseClassFields(Map<String,KgoFieldDesc> fieldMap,Class aClass,String parentName){

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            // 判断是否是基础类型
            Boolean basicType = TypeUtils.isBasicType(field.getType());
            String fieldPath = StringUtils.isBlank(parentName) ? field.getName() : StrUtil.format("{}.{}",parentName,field.getName());
            if (basicType){
                KgoFieldDesc fieldDesc = KgoFieldDesc.builder()
                        .type(field.getType().getSimpleName())
                        .name(field.getName())
                        .aClass(field.getType())
                        .path(fieldPath)
                        .clazz(field.getType().getName())
                        .build();

                KgoField kgoField = field.getAnnotation(KgoField.class);
                if (ObjectUtil.isNotNull(kgoField)){
                    fieldDesc.setDesc(kgoField.desc());
                    fieldDesc.setRequired(kgoField.required());
                }
                fieldMap.put(fieldPath,fieldDesc);
            }else {
                parseClassFields(fieldMap,field.getType(),fieldPath);
            }
        }
    }
    public static void parseClassFields(List<KgoFieldDesc> fieldList, Class aClass, String parentName){

        if (TypeUtils.isBasicType(aClass)){
            KgoFieldDesc fieldDesc = KgoFieldDesc.builder()
                    .type(aClass.getSimpleName())
                    .name(aClass.getName())
                    .aClass(aClass)
                    .path(aClass.getSimpleName())
                    .clazz(aClass.getName())
                    .build();
            parseKgoFieldAnnotation(fieldDesc,aClass);
            fieldList.add(fieldDesc);
        }else {

            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                // 判断是否是基础类型
                Boolean basicType = TypeUtils.isBasicType(field.getType());
                String fieldPath = StringUtils.isBlank(parentName) ? field.getName() : StrUtil.format("{}.{}",parentName,field.getName());
                if (basicType){
                    KgoFieldDesc fieldDesc = KgoFieldDesc.builder()
                            .type(field.getType().getSimpleName())
                            .name(field.getName())
                            .aClass(field.getType())
                            .path(fieldPath)
                            .parentName(aClass.getSimpleName())
                            .clazz(field.getType().getName())
                            .build();

                    parseKgoFieldAnnotation(fieldDesc,field);
                    fieldList.add(fieldDesc);
                }else {
                    parseClassFields(fieldList,field.getType(),fieldPath);
                }
            }
        }

    }
    public static void parseKgoFieldAnnotation(KgoFieldDesc fieldDesc,Class aClass){
        KgoField kgoField = (KgoField) aClass.getAnnotation(KgoField.class);
        if (ObjectUtil.isNotNull(kgoField)){
            fieldDesc.setDesc(kgoField.desc());
            fieldDesc.setRequired(kgoField.required());
        }
    }
    public static void parseKgoFieldAnnotation(KgoFieldDesc fieldDesc,Field field){
        KgoField kgoField = field.getAnnotation(KgoField.class);
        if (ObjectUtil.isNotNull(kgoField)){
            fieldDesc.setDesc(kgoField.desc());
            fieldDesc.setRequired(kgoField.required());
        }
    }
    /**
     * 解析参数
     *
     * @param parameter: 反射参数
     * @return cn.aio1024.framework.basic.domain.entity.parameter.KgoParameter
     **/
    public static KgoFieldDesc parseParameter(Parameter parameter){
        if (ObjectUtil.isNull(parameter)){
            return null;
        }
        KgoFieldDesc kgoParameter = KgoFieldDesc.builder()
                .aClass(parameter.getType())
                .clazz(parameter.getType().getName())
                .type(parameter.getType().getSimpleName())
                .name(parameter.getName())
                .build();

        KgoParam kgoParam = parameter.getAnnotation(KgoParam.class);
        if (ObjectUtil.isNotNull(kgoParam)){
            kgoParameter.setDesc(kgoParam.desc());
            kgoParameter.setRequired(kgoParam.required());
        }
        return kgoParameter;
    }
}
