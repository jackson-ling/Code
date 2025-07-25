#include <stdio.h>

/*
邻接矩阵：Adjacency Matrix

网：带权值的图

定义一个图结构
1.顶点表
2.边的权值表
3.当前的顶点数和边数

4.最大顶点数
5.有向网中两条边没有关系时，定义的无穷大值
*/

// 利用邻接矩阵创建  无向图
#define max_vexnum 100
#define limit_num 10000

typedef int vexnumtype;
typedef int arctype;

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

// 创建无向网
void create_UDN(AMG &G)
{
    // 输入顶点数
    printf("intput vexnum:");
    scanf("%d", &G.vexnum);
    // 输入边数
    printf("intput arcnum:");
    scanf("%d", &G.arcnum);

    /*
        优化部分：检查输入值是否合理
        if (G.vexnum > max_vexnum || G.arcnum > limit_num)
        {
            printf("Error: Exceeded max vertices or edges.\n");
            return;
        }
    */

    // 给顶点表赋值
    printf("input data in vexnum_arr:");
    for (int i = 0; i < G.vexnum; i++)
    {
        scanf("%d", &G.vexs[i]);
    }

    // 初始化临界矩阵
    for (int i = 0; i < G.vexnum; i++)
    {
        for (int j = 0; j < G.vexnum; j++)
        {
            G.arcs[i][j] = 0;
        }
    }

    // 构建无向网
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

        // 无向图，会有重复，根据无向图的临界矩阵的对称性赋值
        G.arcs[vex2_index][vex1_index] = weight;
    }
}
