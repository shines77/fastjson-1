package com.alibaba.json.bvt.writeAsArray;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class WriteAsArray_long_public extends TestCase {
    public void test_0 () throws Exception {
        VO vo = new VO();
        vo.setId(123);
        vo.setName("wenshao");
        
        String text = JSON.toJSONString(vo, SerializerFeature.WriteJavaBeanAsArray);
        Assert.assertEquals("[123,\"wenshao\"]", text);
        VO vo2 = JSON.parseObject(text, VO.class, Feature.SupportArrayToJavaBeanMapping);
        Assert.assertEquals(vo.getId(), vo2.getId());
        Assert.assertEquals(vo.getName(), vo2.getName());
    }
    
    public static class VO {
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}