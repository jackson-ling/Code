#include <stdio.h>

/*

迪杰斯特拉最短路径：适用单源最短路径，即一个点到其他点的最短路径

原理：
1. 基于MST性质，先找一个最短路径点，之后找这个点旁边的点看是否能构成最短路径
2. 利用邻接矩阵


需求：

s[]数组：判断是否被标记

path[]数组：记录前驱节点的下标

（有可能没有前驱节点，需要判断，如果没有前驱就是无穷值，通过邻接矩阵中的值和无穷值比较即可实现判断）

d[]数组：记录最短路径长度

如何输出最短路径？
遍历最短路径数组，根据前驱节点的位置，回溯即可


*/

#define max_vexnum 100
#define limit_num 10000

typedef int vexnumtype;
typedef int arctype;

// 定义临界矩阵
typedef struct
{
    // 顶点表
    vexnumtype vexs[max_vexnum];

    // 边的权值表
    arctype arcs[max_vexnum][max_vexnum];

    // 记录当前的顶点数，边数
    int vexnum;
    int arcnum;

} AMG;

// 查找算法
int locate_vex_index(AMG &G, int find_vexnum)
{

    for (int i = 0; i < G.vexnum; i++)
    {
        if (G.vexs[i] == find_vexnum)
        {
            return i;
        }
    }
    return -1; // 未找到，返回-1
}

// 建立有向网
void create_directed_net(AMG &G)
{
    // 输入顶点数
    printf("intput vexnum:");
    scanf("%d", &G.vexnum);
    // 输入边数
    printf("intput arcnum:");
    scanf("%d", &G.arcnum);

    // 顶点表的初始化
    printf("input data in vexnum_arr:");
    for (int i = 0; i < G.vexnum; i++)
    {
        scanf("%d", &G.vexs[i]);
    }

    // 初始化邻接矩阵
    for (int i = 0; i < G.vexnum; i++)
    {
        for (int j = 0; j < G.vexnum; j++)
        {
            G.arcs[i][j] = 0;
        }
    }

    // 构建有向图
    for (int i = 0; i < G.arcnum; i++)
    {
        // 输入顶点和依附的边的权值
        int vex1, vex2, weight;
        // 值录入
        scanf("%d %d %d", &vex1, &vex2, &weight);

        // 调用查找算法，查找位置
        int vex1_index = locate_vex_index(G, vex1);
        int vex2_index = locate_vex_index(G, vex2);

        // 设置权值
        G.arcs[vex1_index][vex2_index] = weight;
    }
}

// 起点 v0 到 终点 v 的单源最短路径
void Dijkstra(AMG G, int v0, int v)
{
    int n = G.vexnum;

    // 定义三个数组
    int s[n];    // 用来记录顶点是否被标记
    int path[n]; // 记录前驱节点
    int d[n];    // 记录最短路径

    // 初始化三个数组
    for (int i = 0; i < G.vexnum; i++)
    {
        // 初始化所有顶点都未被标记
        s[i] = 0;

        // 初始化所有顶点的最短路径长度为弧上的权值
        d[i] = G.arcs[v0][i]; // 根据邻接矩阵的定义，这就表示 顶点v0 到 其余所有顶点 的距离

        // 初始化所有顶点的前驱节点是起始点v0（有可能没有前驱节点，需要判断）
        if (d[i] < limit_num)
        {
            path[i] = v0;
        }
        else
        {
            path[i] = -1;
        }
    }

    // 初始化完毕，设置起始值
    s[v0] = 1; // 标记第一个顶点
    d[v0] = 0; // 到自身的最短路径长度为0

    // 算法实现部分

    // 遍历剩余的 n - 1个顶点，依次进行计算
    for (int i = 1; i < n; i++)
    {
        int min = limit_num; // 初始化最小值为无穷大
        int current = -1;    // 记录当前找到最短路径的顶点下标，为了防止意外情况，初始化为 -1

        // 遍历顶点，在   未被标记   的顶点中，选择一个路径长度最小的顶点，记录下标，
        // 找其邻接点，判断是否会因邻接点的加入实现最短路径长度
        for (int w = 0; w < n; w++)
        {
            if (!s[w] && d[w] < min)
            {
                min = d[w];  // 更新最小值
                current = w; // 记录顶点下标
            }
        }
        s[current] = 1; // 标记当前顶点

        // 遍历找到最短路径的当前顶点的邻接点，看是否回因邻接点的加入实现最短路径
        for (int w = 0; w < n; w++)
        {
            if (!s[w] && d[current] + G.arcs[current][w] < d[w])
            {
                d[w] = d[current] + G.arcs[current][w]; // 更新最短路径
                path[w] = current;                      // 更新前驱节点
            }
        }
    }

    // 输出从 v0 到 v 的最短路径和路径长度
    if (d[v] == limit_num)
    {
        printf("从 %d 到 %d 没有路径\n", v0, v); // 如果没有路径
    }
    else
    {
        printf("从 %d 到 %d 的最短路径长度为 %d\n", v0, v, d[v]); // 输出最短路径长度
        printf("路径为: ");
        int temp = v;      // 从终点开始
        while (temp != v0) // 如果还没有回到起点
        {
            printf("%d <- ", temp); // 输出当前节点
            temp = path[temp];      // 找到前驱节点
        }
        printf("%d\n", v0); // 输出起点
    }
}