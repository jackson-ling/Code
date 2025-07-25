#include <stdio.h>
#include <stdlib.h>

typedef int elemtype;

// 定义一颗二叉排序树（binary sort tree）
typedef struct bstnode
{
    elemtype data;
    struct bstnode *lchild, *rchild;
} bstnode, *bstree; // 通过指针指向根节点，进而确定一颗树

/*

删除的三种情况

第一种：删除节点既有左子树又有右子树
第二种：删除节点只有左子树
第三种：删除节点只有右子树

对删除节点既有左子树又有右子树的处理：可以选择前驱（后继）代替，之后需要删除前驱（后继）

*/

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