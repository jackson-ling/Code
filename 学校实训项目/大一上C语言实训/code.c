#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <dos.h>
#include <string.h>

// 宏定义部分
#define LEN sizeof(struct student)                 // 学生结构体长度
#define FORMAT "%-8d%-15s%-12.11f%-12.11f%-12.11f%-12.1lf"  // 输出格式
#define DATA stu[i].num, stu[i].name, stu[i].elec, stu[i].expe, stu[i].requ, stu[i].sum

// 定义学生信息结构体
typedef struct student {
    int num;        // 学号
    char name[15];  // 姓名
    double elec;    // 选修课成绩
    double expe;    // 实验课成绩
    double requ;    // 必修课成绩
    double sum;     // 总分
} stu;


stu students[50];  // 定义结构体数组
int count = 0;     // 用于记录当前学生人数
stu imformation[100];//用于查找学生信息




//                                                              _ooOoo_    
//                                                             o8888888o   
//                                                             88" . "88    
//                                                            (|  -_-  |)   
//                                                             O\  =  /O     
//                                                          ____/`---'\____
//                                                        .' \\|       |// `.
//                                                       / \\|||   :   |||// \
//                                                      / _|||||  -:-  |||||- \
//                                                     |   | \\\   -   /// |   |
//                                                     | \_| '' \ --- /''  |   |
//                                                     \  .-\__   `-`   ___/-. /
//                                                    ___`..'   /--.--\   `..   __
//                                                  ."" '< `.___\_<|>_/___.' >'"".
//                                                  | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                                                  \ \ `-.   \_ __\ /__ _/  .-`  / /
//                                          ====== ` -. ___ `-. ___ \_____/ ___ .- `____ .-'======
//                                                              `=---='     
//                                                          佛祖保佑 永无BUG



// 函数声明

//菜单显示函数
void menu() {
    printf("------------------------------------------------\n");
    printf("|              学生信息管理系统               |\n");
    printf("------------------------------------------------\n");
    printf("|               1. 录入学生信息               |\n");
    printf("|               2. 查询学生信息               |\n");
    printf("|               3. 删除学生信息               |\n");
    printf("|               4. 修改学生信息               |\n");
    printf("|               5. 插入学生信息               |\n");
    printf("|               6. 排序                       |\n");
    printf("|               7. 统计学生总数               |\n");
    printf("|               8. 显示所有学生信息           |\n");
    printf("|               0. 退出系统                   |\n");
    printf("------------------------------------------------\n");
}




// 录入学生成绩信息函数
void in(stu students[], int* count) {
    int n;
    printf("请输入要录入的学生人数: ");
    scanf("%d", &n);

    //录入学生信息
    for (int i = 0; i < n; i++) {
        (*count)++;
        printf("录入第 %d 个学生的信息:\n", (*count));
        printf("学号: ");
        scanf("%d", &students[(*count) - 1].num);

        printf("姓名: ");
        scanf("%s", students[(*count) - 1].name);

        printf("选修课成绩: ");
        scanf("%lf", &students[(*count) - 1].elec);

        printf("实验课成绩: ");
        scanf("%lf", &students[(*count) - 1].expe);

        printf("必修课成绩: ");
        scanf("%lf", &students[(*count) - 1].requ);

        // 计算总分
        students[(*count) - 1].sum = students[(*count) - 1].elec + students[(*count) - 1].expe + students[(*count) - 1].requ;

        //printf("总分: %.2f\n", students[*count].sum);
        printf("%d,%s,%lf,%lf,%lf,%lf\n", students[(*count) - 1].num,
            students[(*count) - 1].name,
            students[(*count) - 1].elec,
            students[(*count) - 1].expe,
            students[(*count) - 1].requ,
            students[(*count) - 1].sum);
        //第一个元素的索引是0，所以(*count) - 1（例子：第一次循环count变成1）
        FILE* file = fopen("school.csv", "a");
        if (file == NULL) {
            perror("no file");
            exit(EXIT_FAILURE);
        }
        fprintf(file, "%d,%s,%lf,%lf,%lf,%lf\n",
            students[(*count) - 1].num,
            students[(*count) - 1].name,
            students[(*count) - 1].elec,
            students[(*count) - 1].expe,
            students[(*count) - 1].requ,
            students[(*count) - 1].sum);
        fclose(file);
        printf("录入成功。\n");

    }
}





//查找学生信息函数（1）
void search()
{
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("no file");
        exit(EXIT_FAILURE);
    }
    printf("文件打开成功\n");
    int numStu = 0;
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6)
    {
        numStu++;
    }
    fclose(file);
    /*printf("从文件中读取到的学生信息如下：\n");
    for (int i = 0; i < numStu; i++) {
        printf("学号：%d，姓名：%s，选修课成绩：%.2lf，实验课成绩：%.2lf，必修课成绩：%.2lf，总分：%.2lf\n",
            imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
    }*/
    int a;
    printf("输入需要查询的学号\n");
    scanf("%d", &a);
    int i;
    for (i = 0; i <= 100; i++)
    {
        if (imformation[i].num != a)
        {
            continue;
        }
        if (imformation[i].num == a)
        {
            printf("学号：%d，姓名：%s，选修课成绩：%.2lf，实验课成绩：%.2lf，必修课成绩：%.2lf，总分：%.2lf\n",
                imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
            return;

        }
    }
    printf("未查询到该生信息\n");//如果到100都没有找到，循环结束，显示没有该生信息

}






//删除学生信息函数
void del()
{
    // 首先以只读模式打开文件，读取学生信息
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("无法打开文件");
        return;
    }
    int numStu = 0;
    // 从文件中读取学生信息并存储到 imformation 数组中
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6) {
        numStu++;
    }
    fclose(file);

    int del_num;
    // 提示用户输入要删除的学生学号
    printf("请输入要删除学生的学号：");
    scanf("%d", &del_num);

    // 标记是否找到要删除的学生
    int found = 0;
    // 以读写模式打开文件
    file = fopen("school.csv", "w");//"w"只写模式。如果文件不存在，创建文件；如果文件存在，清空文件
    if (file == NULL) {
        perror("无法打开文件进行写入");
        return;
    }
    for (int i = 0; i < numStu; i++) {
        // 如果不是要删除的学生，将其信息重新写入文件
        if (imformation[i].num != del_num) {
            fprintf(file, "%d,%s,%.2lf,%.2lf,%.2lf,%.2lf\n",
                imformation[i].num,
                imformation[i].name,
                imformation[i].elec,
                imformation[i].expe,
                imformation[i].requ,
                imformation[i].sum);
        }
        else {
            found = 1;
        }
    }
    fclose(file);
    if (found) {
        printf("学号为 %d 的学生信息已删除。\n", del_num);
    }
    else {
        printf("未找到学号为 %d 的学生信息。\n", del_num);
    }
}





//修改学生信息函数
void modify()
{
    // 首先以只读模式打开文件，读取学生信息
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("无法打开文件");
        return;
    }
    int numStu = 0;
    // 从文件中读取学生信息并存储到 imformation 数组中
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6) {
        numStu++;
    }
    fclose(file);


    int modify_num;
    // 提示用户输入要修改的学生学号
    printf("请输入要修改的学生的学号：");
    scanf("%d", &modify_num);


    // 标记是否找到要修改的学生
    int found = 0;


    // 以读写模式打开文件
    file = fopen("school.csv", "r+");
    if (file == NULL) {
        perror("无法打开文件进行写入");
        return;
    }


    for (int j = 0; j < numStu; j++) {
        if (imformation[j].num == modify_num) {
            // 输出当前学生信息
            printf("目前该学生信息：\n");
            printf("学号：%d，姓名：%s，选修课成绩：%.2lf，实验课成绩：%.2lf，必修课成绩：%.2lf，总分：%.2lf\n",
                imformation[j].num, imformation[j].name, imformation[j].elec, imformation[j].expe, imformation[j].requ, imformation[j].sum);


            // 提示用户输入新的信息
            printf("修改学号为：");
            scanf("%d", &imformation[j].num);
            printf("修改姓名为：");
            scanf("%s", imformation[j].name);
            printf("修改选修课成绩为：");
            scanf("%lf", &imformation[j].elec);
            printf("修改实验课成绩为：");
            scanf("%lf", &imformation[j].expe);
            printf("修改必修课成绩为：");
            scanf("%lf", &imformation[j].requ);
            // 重新计算总分
            imformation[j].sum = imformation[j].elec + imformation[j].expe + imformation[j].requ;
            printf("修改后该学生信息：\n");
            printf("学号：%d，姓名：%s，选修课成绩：%.2lf，实验课成绩：%.2lf，必修课成绩：%.2lf，总分：%.2lf\n",
                imformation[j].num, imformation[j].name, imformation[j].elec, imformation[j].expe, imformation[j].requ, imformation[j].sum);


            // 将文件指针定位到修改的位置
            //fseek(file, 0, SEEK_SET);
            for (int i = 0; i < numStu; i++) {
                if (i == j) {
                    fprintf(file, "%d,%s,%.2lf,%.2lf,%.2lf,%.2lf\n",
                        imformation[i].num,
                        imformation[i].name,
                        imformation[i].elec,
                        imformation[i].expe,
                        imformation[i].requ,
                        imformation[i].sum);
                }
                else {
                    fprintf(file, "%d,%s,%.2lf,%.2lf,%.2lf,%.2lf\n",
                        imformation[i].num,
                        imformation[i].name,
                        imformation[i].elec,
                        imformation[i].expe,
                        imformation[i].requ,
                        imformation[i].sum);
                }
            }
            found = 1;
            break;
        }
    }


    if (!found) {
        printf("未找到要修改的学生学号。\n");
    }


    fclose(file);
}





//插入学生信息函数
void insert()
{
    // 首先以只读模式打开文件，读取学生信息
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("无法打开文件");
        return;
    }
    int numStu = 0;
    // 从文件中读取学生信息并存储到 imformation 数组中
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6) {
        numStu++;
    }
    fclose(file);


    int insert_num;
    printf("请输入要插入的位置（从 0 开始）：");
    scanf("%d", &insert_num);


    // 范围检查
    if (insert_num < 0 || insert_num > numStu) {
        printf("插入位置无效。\n");
        return;
    }


    // 将插入位置之后的元素向后移动
    for (int i = numStu; i >= insert_num; i--) {
        imformation[i + 1] = imformation[i];
    }


    // 提示用户输入新的信息
    printf("请输入新的信息：\n");
    printf("学号为：");
    scanf("%d", &imformation[insert_num].num);
    printf("姓名为：");
    scanf("%s", imformation[insert_num].name);
    printf("选修课成绩为：");
    scanf("%lf", &imformation[insert_num].elec);
    printf("实验课成绩为：");
    scanf("%lf", &imformation[insert_num].expe);
    printf("必修课成绩为：");
    scanf("%lf", &imformation[insert_num].requ);
    // 计算总分
    imformation[insert_num].sum = imformation[insert_num].elec + imformation[insert_num].expe + imformation[insert_num].requ;


    // 以读写模式打开文件
    file = fopen("school.csv", "w+");
    if (file == NULL) {
        perror("无法打开文件进行写入");
        return;
    }


    // 将所有学生信息写入文件
    for (int i = 0; i <= numStu; i++) {
        fprintf(file, "%d,%s,%.2lf,%.2lf,%.2lf,%.2lf\n",
            imformation[i].num,
            imformation[i].name,
            imformation[i].elec,
            imformation[i].expe,
            imformation[i].requ,
            imformation[i].sum);
    }


    fclose(file);
    printf("插入成功。\n");
}




//交换函数
void swap(stu* a, stu* b)
{
    stu temp = *a;
    *a = *b;
    *b = temp;
}




//学生成绩排序函数
void order()
{
    // 首先以只读模式打开文件，读取学生信息
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("无法打开文件");
        return;
    }
    int numStu = 0;
    // 从文件中读取学生信息并存储到 imformation 数组中
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6) {
        numStu++;
    }
    fclose(file);
    for (int i = 0; i < numStu; i++)
    {
        for (int j = 0; j < numStu - 1 - i; j++)
        {
            if (imformation[j].sum < imformation[j + 1].sum)
            {
                swap(&imformation[j], &imformation[j + 1]);
            }
        }

    }
    for (int i = 0; i < numStu; i++) //打印数组内数据
    {
        printf("学号：%d，姓名：%s，选修课成绩：%.2lf，实验课成绩：%.2lf，必修课成绩：%.2lf，总分：%.2lf\n",
            imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
    }

}




//统计学生总数函数
void total()
{
    int n=0;//局部定义一个变量记录学生的总人数
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("no file");
        exit(EXIT_FAILURE);
    }
    printf("文件打开成功\n");
    int numStu = 0;
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6)
    {
        numStu++;
    }
    fclose(file);
    for (int i = 0; i < 100; i++)
    {
        //如果数组没有存储信息，不应该算一个学生，累加之前先做判断
        if (imformation[i].num != NULL)
        {
            n++;
        }

    }
    printf("当前学生总数为：%d\n", n);


}




//显示所有学生信息函数
void show()
{
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("no file");
        exit(EXIT_FAILURE);
    }
    printf("文件打开成功\n");
    int numStu = 0;
    while (fscanf(file, "%d,%[^,],%lf,%lf,%lf,%lf\n",
        &imformation[numStu].num,
        imformation[numStu].name,
        &imformation[numStu].elec,
        &imformation[numStu].expe,
        &imformation[numStu].requ,
        &imformation[numStu].sum) == 6)
    {
        numStu++;
    }
    fclose(file);
    printf("从文件中读取到的学生信息如下：\n");
    for (int i = 0; i < numStu; i++)
    {
        printf("学号：%d，姓名：%s，选修课成绩：%.2lf，实验课成绩：%.2lf，必修课成绩：%.2lf，总分：%.2lf\n",
            imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
    }
}




//----------------------------------------------------------------------------------------





// 主函数实现
int main() {
    int choice;

    // 显示主菜单
    menu();

    // 选择功能并执行
    while (1) {
        printf("请选择<0-8>：");

        // 规避输入字母进入死循环
        if (scanf("%d", &choice) != 1) { // 检查输入是否为整数
            printf("输入无效，请输入数字！\n");
            while (getchar() != '\n');  // 清空输入缓冲区
            continue;  // 重新进入循环
        }

        switch (choice) {
        case 1: in(students, &count); break;
        case 2: search(); break;
        case 3: del(); break;
        case 4: modify(); break;
        case 5: insert(); break;
        case 6: order(); break;
        case 7: total(); break;
        case 8: show(); break;
        case 0: return 0; break;
        default: printf("无效选择，请重新输入\n"); break;
        }
    }

    return 0;
}