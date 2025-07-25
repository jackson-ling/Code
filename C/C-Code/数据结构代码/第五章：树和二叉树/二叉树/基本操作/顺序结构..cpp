#include <stdio.h>

/*

从根节点开始，按照从上到下，从左到右的顺序从一开始依次标号，作为数组的第 i 个元素，数组中存放节点值
缺点：一颗二叉树的深度为 k ，则需要 2的k次方-1 个空间的大小存储二叉树，对于单只树的情况就非常浪费空间，

     即 顺序存储结构使用于 完全二叉树，满二叉树的情况


    binary tree 表示二叉树
*/

#define maxsize 100

typedef int elemtype;

typedef elemtype sqbitree[maxsize]; // 0号单元存储根节点

sqbitree bt;