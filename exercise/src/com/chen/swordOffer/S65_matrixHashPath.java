package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/1 on 15:37
 **/
public class S65_matrixHashPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(rows <=0 || cols <= 0 || matrix == null || str == null){
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        Integer index = 0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(path(matrix,visited,str,rows,cols,i,j,index)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean path(char[] matrix,boolean[] visited,char[] str,int rows,int cols,int row,int col,Integer pathIndex){
        if(pathIndex == str.length){
            return true;
        }
        boolean flag = false;
        if(row >= 0 && row < rows && col >=0 && col < cols && !visited[row*cols+col] && str[pathIndex] == matrix[row*cols+col]){
            visited[row*cols+col] = true;
            System.out.println("matrix:"+matrix[row*cols+col]);
            pathIndex++;
            flag = path(matrix,visited,str,rows,cols,row+1,col,pathIndex)||
                    path(matrix,visited,str,rows,cols,row-1,col,pathIndex)||
                    path(matrix,visited,str,rows,cols,row,col+1,pathIndex)||
                    path(matrix,visited,str,rows,cols,row,col-1,pathIndex);
            System.out.println("flag:"+flag);
            if(!flag){
                pathIndex--;
                visited[row*cols+col] = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String s1= "SGGFIECVAASABCEHJIGQEM";
        char[] matrix = s.toCharArray();
        char[] str = s1.toCharArray();
        //char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
//        char[] str = {'a','b','c','c','e','d'};
//        char[] str1 = {'a','b','c','b'};
        S65_matrixHashPath solution65 = new S65_matrixHashPath();
        System.out.println(solution65.hasPath(matrix,5,8,str));
    }
}
