#include <stdio.h>
#include <stdlib.h>

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
