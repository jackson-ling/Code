#include <stdio.h>
#include <stdlib.h>

/*

由于需要经常插入和删除，为了维持表的有序性，需要移动大量元素，时间开销大，查找效率低，这个时候通过动态查找表（树表）便可提高查找效率
引出----二叉排序树（前提：是一个递增的有序序列）

特点：比根节点小的在左子树，比根节点大的在右子树，左右子树又是递归定义的二叉排序树

如何确定序列？通过中序遍历便可得到有序递增的序列表

可以对二叉排序树进行插入，删除，查找，并且还能保持有序，同时不需要移动元素，提高了效率
*/

typedef int elemtype;

// 定义一颗二叉排序树（binary sort tree）
typedef struct bstnode
{
    elemtype data;
    struct bstnode *lchild, *rchild;
} bstnode, *bstree; // 通过指针指向根节点，进而确定一颗树

// 查找算法（使用关键字查找，返回指向关键字节点的指针），使用bstree结构体指针类型
bstree searchbst(bstree t, elemtype key)
{
    // 树为空或者找到了关键字
    if (!t || t->data == key)
    {
        return t;
    }

        // 关键字的值比根节点小，递归查找左子树
    else if (key < t->data)
    {
        return searchbst(t->lchild, key);
    }

        // 关键字的值比根节点大，递归查找右子树
    else
    {
        return searchbst(t->rchild, key);
    }
}

// 插入算法
void insertbst(bstree t, elemtype key)
{
    // 如果t是空的，说明找到了合适的插入位置，插入节点即可
    if (!t)
    {
        bstnode *s = (bstnode *)malloc(sizeof(bstnode));
        // 给节点赋值
        s->data = key;
        // 左右子树置空
        s->lchild = NULL;
        s->rchild = NULL;
        // t指针此时指向了插入位置，将插入节点连接到相应位置即可
        t = s;
    }

        // 如果key小于当前节点，在左子树中查找插入位置
    else if (key < t->data)
    {
        insertbst(t->lchild, key);
    }

        // 如果key大于当前节点，在左子树中查找插入位置
    else
    {
        insertbst(t->rchild, key);
    }
}

// 创建算法（结束标志设为 '#' ）
void createbst(bstree &t)
{
t = NULL;
char endflag = '#';
char root, elem;
scanf("%c", &root); // 输入根节点
// 循环输入其余节点
while (elem != endflag)
{
insertbst(t, elem);
scanf("%c", &elem);
}
}

// 删除算法（采用寻找前驱的方法）
void deletebst(bstree &t, elemtype key)
{
/* 预备工作

1.设立双亲节点指针（用于第一种和第二种情况删除节点后重接子树的操作）
2. 设立指针 p，q，s，
    s:用于找到前驱节点替换删除节点后，删除前驱节点
    q：用于删除前驱节点后重新连接左右子树
*/
bstree p = t; // 变相理解：不会对根节点指针直接操作，需要新的指针来完成操作
bstree f = NULL;

// 第一步：找到删除节点
while (p)
{
// 找到了就跳出循环
if (p->data == key)
{
break;
}
// 设置节点的双亲（f为什么是双亲？p在后续的程序中会移动，在第二轮循环中再次判断是否找到删除节点）
f = p;

if (key < p->data)
{
p = p->lchild;
}
else
{
p = p->rchild;
}
}

// 找不到删除节点就结束
if (!p)
{
return;
}

// 第二步：分情况执行不同的操作
bstree q = p; // 首先初始化q指针，在后续的操作中起作用

// 删除节点有左子树和右子树
if (p->lchild && p->rchild)
{
/*

1.采用找到前驱节点然后代替删除节点的思路

2.如何找前驱节点？首先肯定在删除节点的左子树。而且是左子树中最大的，必然在左子树中的最右节点
*/

// 1.首先进入左子树
bstree s = p->lchild;

// 2.找到最右节点：即删除节点的前驱节点
while (s->rchild)
{
q = s;
s = s->rchild;
}

// 找到前驱节点之后替换删除节点
p->data = s->data;

// 重新连接左右子树，然后删除需要删除的节点
if (p != q)
{
q->rchild = s->lchild;
}
else
{
q->lchild = s->lchild;
}

/*
对于两种连接代码的实例说明
（1）p != q（删除节点50）
        50 (p)
        /
       30 （q）
      / \
    20  40  (s)
        /
       35

结果如下
        40
        /
      30
     / \
   20  35

（2）p = q（删除50）
        50 (p)
        /
       30 （q）
      /
    20
   / \
  10  25

结果如下
       30
      /
    20
   / \
  10  25

*/

// 删除前驱节点
free(s);
return; // 操作完成
}

// 以下两种情况中p的移动目的：是为了找到重新连接子树的节点
// 删除节点没有左子树，重新处理右子树即可
else if (!p->lchild)
{
p = p->rchild;
}
// 删除节点没有右子树，重新处理左子树即可
else if (!p->rchild)
{
p = p->lchild;
}

// 判断一下是哪种情况，执行重接子树操作
if (!p)
{
t = p; // 删除节点为根节点
}
// 注意：经过上面p指针的移动后，p指针跑到了q指针的后面了，此时q指针指向删除节点
else if (f->lchild == q) // 判断一下是不是删除节点只有  左  子树的情况
{
f->lchild = p;
}
else // 判断一下是不是删除节点只有  右  子树的情况
{
f->rchild = p;
}
free(q);
}

// 中序遍历算法，用于输出序列
void inodertraverse(bstree t)
{
    if (t)
    {
        inodertraverse(t->lchild);
        printf("%c ", t->data);
        inodertraverse(t->rchild);
    }
}

// 以下代码为AI生成，打印图形化的树结构
#define MAXH 200
#define MAXW 200
#define CONSOLE_WIDTH 80

static char canvas[MAXH][MAXW];

/* 清空 */
void initCanvas()
{
    for (int i = 0; i < MAXH; i++)
        for (int j = 0; j < MAXW; j++)
            canvas[i][j] = ' ';
}

/* 放节点和一条斜线 */
void fillCanvas(bstree t, int r, int c)
{
    if (!t)
        return;
    canvas[r][c] = t->data;
    if (t->lchild)
    {
        canvas[r + 1][c - 1] = '/';
        fillCanvas(t->lchild, r + 2, c - 1);
    }
    if (t->rchild)
    {
        canvas[r + 1][c + 1] = '\\';
        fillCanvas(t->rchild, r + 2, c + 1);
    }
}

/* 打印并居中 */
void printSlashedTree(bstree root)
{
    initCanvas();
    int startR = 0, startC = MAXW / 2;
    fillCanvas(root, startR, startC);

    /* 找到最左、最右、最下非空 */
    int minC = MAXW, maxC = 0, maxR = 0;
    for (int i = 0; i < MAXH; i++)
    {
        for (int j = 0; j < MAXW; j++)
        {
            if (canvas[i][j] != ' ')
            {
                if (j < minC)
                    minC = j;
                if (j > maxC)
                    maxC = j;
                if (i > maxR)
                    maxR = i;
            }
        }
    }
    int treeWidth = maxC - minC + 1;
    int pad = (CONSOLE_WIDTH - treeWidth) / 2;
    if (pad < 0)
        pad = 0;

    /* 从第0行到 maxR 行，逐行打印 */
    for (int i = 0; i <= maxR; i++)
    {
        for (int k = 0; k < pad; k++)
            putchar(' ');
        for (int j = minC; j <= maxC; j++)
            putchar(canvas[i][j]);
        putchar('\n');
    }
}

int mian()
{
    bstree t;
    createbst(t);
    return 0;
}