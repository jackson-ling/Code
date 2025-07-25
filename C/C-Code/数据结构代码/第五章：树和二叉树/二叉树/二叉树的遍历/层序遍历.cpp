#include <stdio.h>
#include <stdlib.h>

#define OK 1
#define ERROR 0
#define OVERFLOW -1
#define MAXSIZE 100

/* 二叉树结点 */
typedef struct bitnode
{
    char data;
    struct bitnode *lchild, *rchild;
} bitnode, *bitree;

/* 队列中存储的是指向 bitnode 的指针 */
typedef bitnode *elemtype;

typedef struct
{
    elemtype *base;
    int front, rear;
} sqqueue;

/* —— 修改点 —— */
/* 初始化队列：改为引用，避免拷贝 */
int queueinit(sqqueue &q)
{
    q.base = (elemtype *)malloc(MAXSIZE * sizeof(elemtype));
    if (!q.base)
        return ERROR;
    q.front = q.rear = 0;
    return OK;
}

/* 入队：已经是引用，这里保持不变 */
int enqueue(sqqueue &q, elemtype e)
{
    if ((q.rear + 1) % MAXSIZE == q.front)
        return ERROR; /* 队满 */
    q.base[q.rear] = e;
    q.rear = (q.rear + 1) % MAXSIZE;
    return OK;
}

/* 出队：已经是引用，这里保持不变 */
int dequeue(sqqueue &q, elemtype &e)
{
    if (q.front == q.rear)
        return ERROR; /* 队空 */
    e = q.base[q.front];
    q.front = (q.front + 1) % MAXSIZE;
    return OK;
}

/* 判断队空：改为引用，避免拷贝 */
int isempty(const sqqueue &q)
{
    return (q.front == q.rear);
}

/* 按先序输入（遇 '#' 表示空子树）创建二叉树 */
void creatbitree(bitree &t)
{
    char e;
    if (scanf(" %c", &e) != 1)
    {
        t = NULL;
        return;
    }
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

/* 打印“带 / \\ 的”图形树 */
#define MAXH 200
#define MAXW 200
#define CONSOLE_WIDTH 80

static char canvas[MAXH][MAXW];

void initCanvas()
{
    for (int i = 0; i < MAXH; i++)
        for (int j = 0; j < MAXW; j++)
            canvas[i][j] = ' ';
}

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

void printSlashedTree(bitree root)
{
    initCanvas();
    int startR = 0, startC = MAXW / 2;
    fillCanvas(root, startR, startC);

    int minC = MAXW, maxC = 0, maxR = 0;
    for (int i = 0; i < MAXH; i++)
        for (int j = 0; j < MAXW; j++)
            if (canvas[i][j] != ' ')
            {
                if (j < minC)
                    minC = j;
                if (j > maxC)
                    maxC = j;
                if (i > maxR)
                    maxR = i;
            }

    int treeWidth = maxC - minC + 1;
    int pad = (CONSOLE_WIDTH - treeWidth) / 2;
    if (pad < 0)
        pad = 0;

    for (int i = 0; i <= maxR; i++)
    {
        for (int k = 0; k < pad; k++)
            putchar(' ');
        for (int j = minC; j <= maxC; j++)
            putchar(canvas[i][j]);
        putchar('\n');
    }
}

/* 层序遍历 */
void leveltraverse(bitree t)
{
    if (!t)
        return;
    sqqueue q;
    queueinit(q);

    /* 队列中存储的是指向 bitnode 的指针（其实就是存储指向节点的指针，便于后面用指针防蚊服元素） */
    elemtype p; // p是在执行出队操作后把出队元素赋值给p起的作用，这是是先定义了，没有初始化

    enqueue(q, t);
    while (!isempty(q))
    {
        dequeue(q, p);
        printf("%c ", p->data);
        if (p->lchild)
            enqueue(q, p->lchild);
        if (p->rchild)
            enqueue(q, p->rchild);
    }
}

int main()
{
    bitree t;
    creatbitree(t);

    putchar('\n');
    printSlashedTree(t);

    printf("\nSequence traversal sequence is:  ");
    leveltraverse(t);
    putchar('\n');
    return 0;
}
