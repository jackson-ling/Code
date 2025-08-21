#ifndef SERVICE_H // 如果没有定义 SERVICE_H
#define SERVICE_H // 定义 SERVICE_H，表示这个头文件已被包含

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "sqlist_service.h"

#define FILE_PATH "C:\\Users\\jackson\\Desktop\\bankproject_vscode\\file\\service_info.txt" // 文件路径



// 业务的暂停
void pause_service(sqlist *l)
{
    // 显示业务信息
    show_service_info(l); // 传递指针
    printf("请输入序号选择需要暂停的业务：");
    int choice;
    scanf("%d", &choice);
    for (int i = 0; i < l->length; i++)
    {
        if (choice - 1 == i)
        {
            strcpy(l->elem[i].status, "暂停");
        }
    }
    printf("\n-----------修改成功-----------\n");
    for (int i = 0; i < l->length; i++)
    {
        printf("%d. %s  业务状态：%s\n", i + 1, l->elem[i].service, l->elem[i].status);
    }

    // 保存修改后的数据到文件
    save_to_file(l);
}

// 业务恢复
void pause_revive(sqlist *l)
{
    // 显示业务信息
    show_service_info(l); // 传递指针
    printf("请输入序号选择需要恢复的业务：");
    int choice;
    scanf("%d", &choice);
    for (int i = 0; i < l->length; i++)
    {
        if (choice - 1 == i)
        {
            strcpy(l->elem[i].status, "开放");
        }
    }
    printf("\n-----------修改成功-----------\n");
    for (int i = 0; i < l->length; i++)
    {
        printf("%d. %s  业务状态：%s\n", i + 1, l->elem[i].service, l->elem[i].status);
    }

    // 保存修改后的数据到文件
    save_to_file(l);
}



#endif // 结束 SERVICE_H 保护
