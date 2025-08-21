#ifndef SERVICE_H // ���û�ж��� SERVICE_H
#define SERVICE_H // ���� SERVICE_H����ʾ���ͷ�ļ��ѱ�����

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "sqlist_service.h"

#define FILE_PATH "C:\\Users\\jackson\\Desktop\\bankproject_vscode\\file\\service_info.txt" // �ļ�·��



// ҵ�����ͣ
void pause_service(sqlist *l)
{
    // ��ʾҵ����Ϣ
    show_service_info(l); // ����ָ��
    printf("���������ѡ����Ҫ��ͣ��ҵ��");
    int choice;
    scanf("%d", &choice);
    for (int i = 0; i < l->length; i++)
    {
        if (choice - 1 == i)
        {
            strcpy(l->elem[i].status, "��ͣ");
        }
    }
    printf("\n-----------�޸ĳɹ�-----------\n");
    for (int i = 0; i < l->length; i++)
    {
        printf("%d. %s  ҵ��״̬��%s\n", i + 1, l->elem[i].service, l->elem[i].status);
    }

    // �����޸ĺ�����ݵ��ļ�
    save_to_file(l);
}

// ҵ��ָ�
void pause_revive(sqlist *l)
{
    // ��ʾҵ����Ϣ
    show_service_info(l); // ����ָ��
    printf("���������ѡ����Ҫ�ָ���ҵ��");
    int choice;
    scanf("%d", &choice);
    for (int i = 0; i < l->length; i++)
    {
        if (choice - 1 == i)
        {
            strcpy(l->elem[i].status, "����");
        }
    }
    printf("\n-----------�޸ĳɹ�-----------\n");
    for (int i = 0; i < l->length; i++)
    {
        printf("%d. %s  ҵ��״̬��%s\n", i + 1, l->elem[i].service, l->elem[i].status);
    }

    // �����޸ĺ�����ݵ��ļ�
    save_to_file(l);
}



#endif // ���� SERVICE_H ����
