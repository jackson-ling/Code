#include <stdio.h>
#include <stdlib.h>

typedef int elemtype;

typedef struct bitnode
{
    elemtype data;
    bitnode *lchild, *rchild;
} bitnode, *bitree;

void creatbitree(bitree &t)
{
    char e;
    scanf("%c", &e);
    if (e == '#')
    {
        t = NULL;
    }
    else
    {
        t = (bitnode *)malloc(sizeof(bitnode));
        t->data = e;
        creatbitree(t->lchild);
        creatbitree(t->rchild);
    }
}

//          下面是AI生成的代码，用于打印二叉树结果的图形，不用管，重点理解如何创建一个二叉树
//----------------------------------------------------------------------------------------------------------

/* ——— 以下为单斜线 + 居中打印 ——— */
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
void fillCanvas(bitree t, int r, int c)
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
void printSlashedTree(bitree root)
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

// 后序遍历，按照 左 右 跟 的方式输出
void postodertraverse(bitree t)
{
    if (t)
    {
        postodertraverse(t->lchild);
        postodertraverse(t->rchild);
        printf("%c ", t->data);
    }
}

int main()
{
    bitree t;
    creatbitree(t);
    printSlashedTree(t);
    printf("\n");
    printf("The result of postorder traversal is: ");
    postodertraverse(t);
    printf("\n");
}