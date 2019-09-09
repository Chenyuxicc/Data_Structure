package arr1.chen.qiuzhaotest.huawei;

import javafx.scene.transform.Scale;

import java.util.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/7 on 20:51
 **/
public class Main3{
    public static Map<String, String> arr1 = new HashMap<>();
    public static Map<String, Integer> arr2 = new HashMap<>();
    public static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] t = s.split(";");
        for (String m : t[0].split(",")) {
            String[] b = m.split("=");
            arr1.put(b[0], b[1]);
            queue.add(b[0]);
        }
        for (String m : t[1].split(",")) {
            String[] b = m.split("=");
            arr2.put(b[0], Integer.valueOf(b[1]));
        }
        tag:while (!queue.isEmpty()) {
            String key = queue.poll();
            String val = arr1.get(key);
            String[] res = val.split("[-+]");
            int[] resi = new int[res.length];
            for (int i=0;i<res.length;i++) {
                String[] ss = res[i].split("[*/]");
                int[] tss = new int[ss.length];
                for (int j = 0; j < ss.length; j++) {
                    if (ss[j].indexOf("{") != -1) {
                        tss[j] = getP(ss[j]);
                    } else if (arr2.containsKey(ss[j])) {
                        tss[j] = arr2.get(ss[j]);
                    } else {
                        queue.add(key);
                        continue tag;
                    }
                }
                resi[i]=tss[0];
                for(int j=1;j<tss.length;j++){
                    char c=res[i].charAt(val.indexOf(res[j])-1);
                    if(c=='*'){
                        resi[i]*=tss[j];
                    }else{
                        resi[i]/=tss[j];
                    }
                }
            }
            int sum=resi[0];
            for(int i=1;i<resi.length;i++){
                char c=val.charAt(val.indexOf(res[i])-1);
                if(c=='+'){
                    sum+=resi[i];
                }else{
                    sum-=resi[i];
                }
            }
            arr2.put(key,sum);
        }
        System.out.println(arr2.get(t[2]));
    }

    public static int getP(String s) {
        int l = s.indexOf("{"), r = s.indexOf("}");
        return Integer.valueOf(s.substring(l + 1, r));
    }
}