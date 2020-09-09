package com.wwb.gulimall.search;

import com.google.common.collect.Lists;
import lombok.Data;
import java.util.List;
import java.util.Random;

@Data
public class StreamEntity {

    private Long id;

    private String  name;

    private Integer value;
}


class StreamTest {

    public  static void  main(String [] arges) {
        //造两个30000的集合  一个简单类型 一个自定义类型
        List<Integer> integerList = Lists.newArrayList();
        List<StreamEntity> streamEntityList = Lists.newArrayList();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            Integer number =random.nextInt(100000);
            integerList.add(number);
            StreamEntity streamEntity = new StreamEntity();
            streamEntity.setId(Long.valueOf(number));
            streamEntity.setName(String.valueOf(number));
            streamEntity.setValue(number);
            streamEntityList.add(streamEntity);
        }
        //简单集合
        long prevTime1 = System.currentTimeMillis();
        Integer result1= integerList.get(0);
        for(int i =0;i<integerList.size();i++){
            int j = integerList.get(i);
            if(j>result1){
                result1 =j;
            }
        }
        System.out.println("简单集合普通for循环计算耗时："+(System.currentTimeMillis() -prevTime1)+" 结果："+result1);
        long prevTime2 = System.currentTimeMillis();
        Integer result2 = integerList.stream().mapToInt(v->v).max().getAsInt();
        System.out.println("简单集合单线程stream计算耗时："+ (System.currentTimeMillis() - prevTime2)+" 结果："+result2);

        long prevTime3 = System.currentTimeMillis();
        Integer sum3 = integerList.parallelStream().mapToInt(v->v).max().getAsInt();
        System.out.println("简单集合多线程stream计算耗时："+(System.currentTimeMillis() - prevTime3)+" 结果："+sum3);
        // 自定义集合
        long prevTime4 = System.currentTimeMillis();
        Integer result4=streamEntityList.get(0).getValue();
        for(int i =0;i<streamEntityList.size();i++){
            StreamEntity streamEntity = streamEntityList.get(i);
            if(result4<streamEntity.getValue()){
                result4 = streamEntity.getValue();
            }
        }
        System.out.println("自定义集合普通for循环环计算耗时："+(System.currentTimeMillis() -prevTime4)+" 结果："+result4);
        long prevTime5 = System.currentTimeMillis();
        Integer result5 =  streamEntityList.stream().mapToInt(v->v.getValue()).max().getAsInt();
        System.out.println("自定义集合单线程stream计算耗时："+ (System.currentTimeMillis() - prevTime5)+" 结果："+result5);

        long prevTime6 = System.currentTimeMillis();
        Integer result6 = streamEntityList.parallelStream().mapToInt(v->v.getValue()).max().getAsInt();
        System.out.println("自定义集合多线程stream计算耗时："+(System.currentTimeMillis() - prevTime6)+" 结果："+result6);

    }

}
