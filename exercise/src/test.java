import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/16 on 11:46
 **/
class Creature{
    public Creature(int age){
        System.out.println("age"+age);
    }
}

class Animal extends Creature{
    public Animal(int age){
        super(age);
    }
//    public Animal(int age){
//       this();
//       System.out.println("调用了this()");
//   }
}
public class test {

    public static void main(String[] args) {
//        com.chen.swordOffer.TreeNode root=new com.chen.swordOffer.TreeNode(10);
//        root.left=new com.chen.swordOffer.TreeNode(5);
//        root.right=new com.chen.swordOffer.TreeNode(12);
//        root.left.left=new com.chen.swordOffer.TreeNode(4);
//        root.left.right=new com.chen.swordOffer.TreeNode(7);
//        char c = '-';
//        System.out.println(c-77);
//        Animal animal = new Animal(50);
//        LinkedList<Integer> linkedList = new LinkedList();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(1,3);
//        System.out.println(linkedList.get(0)+":"+linkedList.get(1)+":"+linkedList.get(2));
        //deque pollFirst or pollLast will change first or last pointer
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);
        arrayDeque.pollFirst();
        arrayDeque.pollLast();
        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.peekLast());
    }
}
