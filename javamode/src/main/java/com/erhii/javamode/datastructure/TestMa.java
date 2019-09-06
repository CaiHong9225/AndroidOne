package com.erhii.javamode.datastructure;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.datastructure
 * @ClassName: TestMa
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/9/6 11:11
 * @UpdateUser: admin
 * @UpdateDate: 2019/9/6 11:11
 * @UpdateRemark:
 * @Version: 1.0
 */
public class TestMa {
    public static void main(String[] args) {

        SimpleLinkedList list = new SimpleLinkedList();
        list.addNode(1);

        System.out.println(list.length());

        list.addNode(2);

        System.out.println(list.length());

        list.addNode(3);

        System.out.println(list.length());

        list.addNode(3, 8);

        System.out.println(list.length());

        list.addNode(4, 9);
        System.out.println(list.length());
        System.out.println(list.toString());
        list.removeNode(2);
        System.out.println(list.toString());
        System.out.println(list.length());
        System.out.println(list.get(1));

    }
}
