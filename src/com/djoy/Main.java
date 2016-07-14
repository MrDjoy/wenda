package com.djoy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Djoy on 2016/7/11.
 */
public class Main {

    public static void print(int index, Object object){
        System.out.println(String.format("{%d},%s",index,object));
    }
    public static void demoString(){
        String str = "hello world";
        print(1,str.indexOf('e'));
        print(2,str.charAt(1));
        print(3,str.codePointAt(1));
    }
    public static void demoList(){
        List<String> strList = new ArrayList<String>(10);
        for (int i =0 ;i<4;i++){
            strList.add(String.valueOf(i));//添加
        }
        List<String> strListB = new ArrayList<String>(10);
        for (int i =0 ;i<4;i++){
            strListB.add(String.valueOf(i*i));
        }
        strList.addAll(strListB);//添加一个arrayList
        print(1, strList);

        strList.remove(1);//删除下标元素
        print(2,strList);

        strList.remove(String.valueOf(0));//删除数值为1的元素
        print(3,strList);

        strList.remove(strList.get(1));//删除下标为1的元素
        print(4,strList);

        Collections.reverse(strList);//反转元素
        print(5,strList);
        //内部命名类，相当于C++的函数指针
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
                //自定义排序方法
            }
        });
        //两种遍历方式
        for (int i =0 ;i<strList.size();++i){
            print(9,strList.get(i));
        }
        for (String obj : strList){
            print(10,obj);
        }

        int[] array = new int[]{1,2};//数组
        print(11,array[0]);//数组直接下标访问
    }

    public static void demoMapTable(){
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0 ; i<4 ;++i){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        print(1,map);
        for (Map.Entry<String,String> obj : map.entrySet() ){//entry是set集合
            //print(1,obj);
            print(2,obj.getKey()+"|"+obj.getValue());//获一个实例集合键和值
        }
        print(3,map.keySet());//获取map的键
        print(4,map.values());//获取map的值
        print(5,map.get("1"));//通过键获取值，key此处声明为string
        String value = map.get("2");
        map.put("2",value+"a");
        print(6,map);

        map.replace("2","4a","4");//（key，oldvalue,newvalue）（key,value）
        print(7, map);//将key的value替换替换
        map.remove("2","4");
        print(8, map);// 将key删除，删除key对应value也被删除 ,（key，value）同时存在将删除此键值对（也即此entry）
    }

    public  static  void demoSet(){
        Set<String> strSet = new HashSet<String>();
        for(int i = 0 ;i<3 ;++i){
            strSet.add(String.valueOf(i));
        }
        print(1,strSet);
        print(2,strSet.contains(String.valueOf(1)));//是否包含
        strSet.addAll(Arrays.asList(new String[]{"a","b","c"}));//添加一组数据
        for (String value : strSet) {
            print(3,value);
        }
    }
    //异常处理
    public static void demoException(){
        try {
            int k = 2;
//            k = k/0;
            if (k==2){//抛出业务异常
                throw new Exception("@_@");
            }
        } catch (Exception message) {
            print(2,message.getMessage());//捕获异常
        } finally {
            print(3,"finally");//句柄，资源，数据清理
        }
    }
    public static void demoFunction(){
        //ArrayList<Integer> array = new ArrayList<Integer>();
        List<Integer> arr = Arrays.asList(new Integer[]{1,2,3,4});
        Collections.shuffle(arr);
        print(1,arr);

        Random random = new Random();
        random.setSeed(1);
        print(1,random.nextInt(100));

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:MM:ss");
        print(2,date);
        print(3,date.getTime());
        print(4,df.format(date));

        print(5,UUID.randomUUID());//static function 类名调用

        print(6,Math.log(10));
        print(7,Math.min(3,10));
        print(8,Math.max(5,Math.max(3,4)));//只有两个参数
        print(9,Math.abs(-10));
        print(10,Math.ceil(0.03));//向上进一位
        print(11,Math.floor(0.03));//向下退一位
    }
    public static  void  main(String[] args){
       // demoString();
        //demoMapTable();
        // demoList();
        //demoSet();
        //demoException();
        demoFunction();
    }
}

