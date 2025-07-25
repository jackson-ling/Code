#include <stdio.h>

/*

又叫二叉链表

一个节点的组成：数据域：存放节点值，左孩子，右孩子
*/

typedef int elemtype;

typedef struct bitnode
{
    elemtype data;
    bitnode *lchild, *rchild;
} bitnode, *bitree;

// 本身表示一个节点
// 若用指针指向该节点，可以表示一颗树，所用用 bitree 表示