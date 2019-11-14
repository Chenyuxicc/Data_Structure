# DataStructure
I create this repository to record the exercise of DataStructure
### leetcode
<details>
<summary>点击查看详情</summary>
  
|编号 |类名|思路|分类|时间|备注|
|-----|----|----|---|----|---|
|2|leetcode\.arrayMath\.S220_duplicate3|**题名**：<br>**描述**：<br>**思路**：||||
|1|leetcode\.dfs\.Solution51|n皇后问题<br>使用一个数组array记录每一行的皇后所在的列号<br>判断是否在斜线上，考虑斜率，判断绝对值|回溯|20190911||
|2|leetcode\.arrayMath\.S220_duplicate3|题名：数组中重复的数<br>描述：判断一个数组中是否存在下标i和j相差小于等t而且值nums[i]和nums[j]相差小于等于k的这两个数<br>思路：使用TreeSet数据结构获取最接近的两个数|数组|20191028||
|3|leetcode\.arrayMath\.S15_threeNumSum|题名：三数之和<br>描述：数组中找出所有三个和为给定target的数<br>思路：使用一个指针去遍历数组，再使用两个指针去移动，找到和为target的数，注意去重|数组|20191030|复习|
|4|leetcode\.arrayMath\.S18_fourNumSum|**题名**：四数之和<br>**描述**：同上<br>**思路**：在三数之和的外面再加上一层循环，去重|数组|20191030||
|5|leetcode\.linkedList\.S19_deleteKthNode|**题名**：删除链表倒数第k个节点<br>**描述**：<br>**思路**：双指针|链表|20191030||
|6|leetcode\.stack\.S20_validBrackets|**题名**：有效的括号<br>**描述**：<br>**思路**：使用栈|栈|20191030||
|7|leetcode\.dfs\.S22_generateBrackets|**题名**：生成有效的括号<br>**描述**：<br>**思路**：使用深度优先遍历，但是在判断是否要加右括号时，条件为此时右括号的数量小于左括号的数量|dfs|20191030||
|8|leetcode\.linkedlist\.S23_mergeKLinkedList|**题名**：合并K个有序链表<br>**描述**：<br>**思路**：使用原地归并，不申请额外空间，使用interval变量来控制需要归并的两个链表|归并 链表|20191031| *** |
|9|leetcode\.matrix\.S48_rotate|**题名**：原地旋转矩阵<br>**描述**：不使用额外空间复杂度，旋转矩阵<br>**思路**：找规律旋转|矩阵|20191031| ** |
|10|leetcode\.linkedlist\.S24_swapPairs|**题名**：两两交换链表中的节点<br>**描述**：<br>**思路**：使用一个指针遍历，两个指针存放需要交换的节点，就地交换|链表|20191031|* |
|11|leetcode\.linkedlist\.S25_reverseKGroup|**题名**：K个一组反转链表<br>**描述**：<br>**思路**：使用slow、fast两个指针指向需要反转的k个一组的链表的头尾，使用pre1指针来保存当前k个一组链表的前一个节点，将k个一组链表断开进行翻转，在将pre1指向这组链表，并将这组链表尾指针指向下一组，下一组头节点使用temp指针保存,注意不满k个的时候链表的处理|链表|20191101|*** |
|12|leetcode\.arrayMath\.S26_removeDuplicate|**题名**：删除排序数组中数组的重复项<br>**描述**：<br>**思路**：使用双指针，不同时则放到前面去|数组|20191101|* |
|13|leetcode\.arrayMath\.S27_removeElement|**题名**：移除元素<br>**描述**：<br>**思路**：同上，细节变化|数组|20191101|* |
|14|leetcode\.StringMath\.S28_strStr|**题名**：实现strStr<br>**描述**：判断主串中是否存在字串<br>**思路**：遇到主串和字串相同的字符时，则开始移动双方指针，匹配失败，子串从头开始，主串减去字串移动的位置，再开始<br>KMP|字符串|20191104|KMP|
|15|leetcode\.math\.S29_divide|**题名**：两数相除<br>**描述**：不使用乘法除法mo实现两个数相除<br>**思路**：使用位移，判断是否等于边界/2，使用负数|数学|20191105|****| 
|16|leetcode\.StringMath\.S30_findSubString|**题名**：串联所有单词的子串<br>**描述**：判断一个字符串S中有没有由字符串数组words中所有元素组成的子串，有的话给出子串起始位置<br>**思路**：使用两个HashMap，判断两个HashMap是否相等|字符串|20191109|*** |
|17|leetcode\.math\.S31_nextPermutation|**题名**：下一个排列<br>**描述**：输出一个整形数组里的数字的下一个排列(指最接近这个数字的比其大的一个数)，如果已经是最大值，则输出最小值<br>**思路**：找到第一个nums[i]>nums[i-1]的元素，将nums[i-1]和后面比其大且和其最接近的数nums[j]交换，再将i以及其之后的元素反转|排列组合|20191110|*** |
|18|leetcode\.StringMath\.S32_longestValidBracket|**题名**：有效括号子串<br>**描述**：给出有效括号子串的长度<br>**思路**：使用一个栈，当前元素为'('时直接下标入栈，当前元素为')',先弹出栈顶元素，如果此时栈为空，则说明这个')'没有与之匹配的'(',将这个'('的下标入栈，否则计算有效子字符长度|stack|20191113|**** |
  
</details>

### 剑指offer二刷
<details>
<summary>点击查看详情</summary>
  
|编号 |类名|记录 | 分类|时间|备注|
|-----|----|----|------|----|---|
|1|swordOffer2\.S12_matrixPath|题名：<br>描述：<br>思路：||||
|1|swordOffer2\.S1_SingleTon|题名：实现Singleton模式<br>描述：实现一个单例<br>思路：1.懒汉模式：双重校验锁(进入方法后，先校验，加锁，再校验)以及volatile关键字保证线程安全，懒汉模式延迟初始化<br>2.静态内部类：创建一个静态内部类，静态内部类加载初始化线程安全，使用get方法保证延迟初始化|设计模式|20190930|面试前复习|
|2|swordOffer2\.S11_minNum|题名：旋转数组的最小数字<br>描述：将一个排序数组的开始若干元素搬到数组的末尾<br>思路：使用二分法的变形，传统二分查找是和target进行比较，再决定头尾指针移动方向，这个题根据自身的特点，也是定义头尾指针，如果中间值大于等于头指针，则头指针后移，如果中间值小于尾指针指向值，则尾指针前移<br>极端情况：头尾中指针指向值均相同，则从头指针往后开始顺序遍历|数组|20191015||
|3|swordOffer2\.S12_matrixPath|题名：矩阵中的路径<br>描述：判断在一个矩阵中是否存在一条包含某个字符串所有字符的路径<br>思路：两个函数，一个遍历矩阵中所有的点，只要有一个存在这条路径，即返回true,另一个只判断这个点是否存在路径，函数内容：一个visited数组用来表示矩阵中某点是否被访问过，一个指针index用来指向字符串，字符串走完时返回true，否则，判断该点是否合法，index++,将该点置为访问过，如果该点和指针指向的元素不同直接返回false,否则再判断其周围四个点是否满足要求，不满足要求则回溯，返回false|回溯法|20191016|复习一遍|
|4|swordOffer2\.S13_movingCount|题名：机器人的运动范围<br>描述：m行n列的方格，机器人从坐标(0,0)开始移动，上下左右四个方向，移动到坐标点的数位之和不能超过给定k值，求机器人能走过的格子数<br>思路：一个函数用来计算数位之和，一个函数用来计算格子数。如果满足点合法且数位和小于等于k，则访问这个点，count为1加上另外四个方向的点的count，最后返回count||20191016||
|5|swordOffer2\.S14_cutRope|题名：剪绳子<br>描述：给一段绳子n，把绳子剪成m段，使得绳子长度之积最大<br>思路：初值和子问题最优解不同，不能使用递归，迭代：绳子长度为小于2以及等于2等于3时单独处理，使用一个数组记录所有子问题的最优解，子问题最优解初值，剪成长度为1、2、3时最优解为其本身，从4开始判断，判断绳子剪为j和i-j长度时，result积的最大值，记录为i对应的result|动态规划|20191017|复习一遍|
|6|swordOffer2\.S14_numOf1|题名：二进制中1的个数<br>描述：计算一个整数的二进制数中的1的个数<br>思路：1.使用原数n与n-1按位与，直到n为0，记录下次数即为答案2.与1按位与，再左移1，继续按位与32词，结果不为0的记录下来|位运算|20191018||
|7|swordOffer2\.S17_print1ToMax|题名：打印从1到最大的n位数<br>描述：打印从1到最大的n位数<br>思路：大数问题，使用字符串模拟加法，使用一个长度为n的数组，初值全为0，一个自增函数，返回值判断是否溢出。增加number[length -1]位置上的值，如果已经超过9，则进位到number[length - 2]如果还是需要进位则继续判断。并将进位后的值写入number[i]|四则运算|20191021|复习一遍|
  
</details>

