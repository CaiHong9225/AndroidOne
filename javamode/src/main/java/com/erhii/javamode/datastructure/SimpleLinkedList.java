package com.erhii.javamode.datastructure;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.javamode.datastructure
 * @ClassName: SimpleLinkedList
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/9/6 9:41
 * @UpdateUser: admin
 * @UpdateDate: 2019/9/6 9:41
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SimpleLinkedList {

    private Node head;
    private static final int HEAD_NODE_DATA = -1;

    public SimpleLinkedList() {
//        head = new Node(HEAD_NODE_DATA);
    }

    public int length() {
        Node temp = head;
        if (temp == null) {
            return 0;
        }
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size = size + 1;
        }
        return size;
    }

    private void addNode(Node node) {
        if(head ==null){
            head = node;
            return;
        }
        Node currentNode = head;
        if (currentNode == null) {
            throw new IllegalArgumentException("the SimpleLinkedList is null,it should have nodes at least one");
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    /**
     * 通知已知数据在链表内插入一个节点
     * 插入位置:链表最后面
     *
     * @param data 节点中存储的数据
     */
    public void addNode(int data) {
        Node node = new Node(data);
        if(head==null){
            head = new Node(data);
            return;
        }
        Node currentNode = head;
        if (currentNode == null) {
            throw new IllegalArgumentException("the SimpleLinkedList is null,it should have nodes at least one");
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public void addNode(int index, int data) {
        Node node = new Node(data);
        if(head==null){
            head = new Node(data);
            return;
        }
        //如果链表不为空,至少需要一个节点
        if (index < 0 || index > length() + 1) {
            throw new IllegalArgumentException("the SimpleLinkedList index bound is out limit");
        }
        //从第一个位置开始(head位置为0)
        int count = 0;
        Node currentNode = head;
        while (currentNode.next != null) {
            //到达指定节点
            if (index == count++) {
                node.next = currentNode.next;
                currentNode.next = node;
                return;
            }
            //循环现在的节点到最后一个
            currentNode = currentNode.next;
        }
        //如果插入的末尾 放入末尾
        if (index == length()) {
            addNode(node);
        }
    }

    public void removeNode(int index) {
        if (index < 0 || index > length() - 1) {
            throw new IllegalArgumentException("the SimpleLinkedList is null,it should have nodes at least one");
        }
        int count = 0;
        if(head==null){
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (index == count++) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Integer get(int location){
        Node node = null;
        if(location <0||location>length()-1){
            throw new IllegalArgumentException("the SimpleLinkedList is null,it should have nodes at least one");
        }
        int count = 0;
        if(head==null){
            return -1;
        }
        Node current = head;
//        head->current->current->current->current->null; 1 3 8 9
        while (current.next!=null){
            if (location ==count++){
                node = current;
                break;
            }
            current = current.next;
        }
        if(node==null){
            return -1;
        }
        return node.data;
    }
    public String toString(){
        if(head==null){
            return "";
        }
        Node temp = head;
        StringBuffer message = new StringBuffer();
        while (temp!=null){
            message.append(temp.data).append("\t");
            temp = temp.next;
        }
        return message.toString();
    }
}
