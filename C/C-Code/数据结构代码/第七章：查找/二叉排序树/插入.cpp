#include <stdio.h>
#include <stdlib.h>

typedef int elemtype;

// 定义一颗二叉排序树（binary sort tree）
typedef struct bstnode
{
    elemtype data;
    struct bstnode *lchild, *rchild;
} bstnode, *bstree; // 通过指针指向根节点，进而确定一颗树

// 插入算法
void insertbst(bstree &t, elemtype key)
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