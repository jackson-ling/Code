#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <dos.h>
#include <string.h>

// �궨�岿��
#define LEN sizeof(struct student)                 // ѧ���ṹ�峤��
#define FORMAT "%-8d%-15s%-12.11f%-12.11f%-12.11f%-12.1lf"  // �����ʽ
#define DATA stu[i].num, stu[i].name, stu[i].elec, stu[i].expe, stu[i].requ, stu[i].sum

// ����ѧ����Ϣ�ṹ��
typedef struct student {
    int num;        // ѧ��
    char name[15];  // ����
    double elec;    // ѡ�޿γɼ�
    double expe;    // ʵ��γɼ�
    double requ;    // ���޿γɼ�
    double sum;     // �ܷ�
} stu;


stu students[50];  // ����ṹ������
int count = 0;     // ���ڼ�¼��ǰѧ������
stu imformation[100];//���ڲ���ѧ����Ϣ




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
//                                                          ���汣�� ����BUG



// ��������

//�˵���ʾ����
void menu() {
    printf("------------------------------------------------\n");
    printf("|              ѧ����Ϣ����ϵͳ               |\n");
    printf("------------------------------------------------\n");
    printf("|               1. ¼��ѧ����Ϣ               |\n");
    printf("|               2. ��ѯѧ����Ϣ               |\n");
    printf("|               3. ɾ��ѧ����Ϣ               |\n");
    printf("|               4. �޸�ѧ����Ϣ               |\n");
    printf("|               5. ����ѧ����Ϣ               |\n");
    printf("|               6. ����                       |\n");
    printf("|               7. ͳ��ѧ������               |\n");
    printf("|               8. ��ʾ����ѧ����Ϣ           |\n");
    printf("|               0. �˳�ϵͳ                   |\n");
    printf("------------------------------------------------\n");
}




// ¼��ѧ���ɼ���Ϣ����
void in(stu students[], int* count) {
    int n;
    printf("������Ҫ¼���ѧ������: ");
    scanf("%d", &n);

    //¼��ѧ����Ϣ
    for (int i = 0; i < n; i++) {
        (*count)++;
        printf("¼��� %d ��ѧ������Ϣ:\n", (*count));
        printf("ѧ��: ");
        scanf("%d", &students[(*count) - 1].num);

        printf("����: ");
        scanf("%s", students[(*count) - 1].name);

        printf("ѡ�޿γɼ�: ");
        scanf("%lf", &students[(*count) - 1].elec);

        printf("ʵ��γɼ�: ");
        scanf("%lf", &students[(*count) - 1].expe);

        printf("���޿γɼ�: ");
        scanf("%lf", &students[(*count) - 1].requ);

        // �����ܷ�
        students[(*count) - 1].sum = students[(*count) - 1].elec + students[(*count) - 1].expe + students[(*count) - 1].requ;

        //printf("�ܷ�: %.2f\n", students[*count].sum);
        printf("%d,%s,%lf,%lf,%lf,%lf\n", students[(*count) - 1].num,
            students[(*count) - 1].name,
            students[(*count) - 1].elec,
            students[(*count) - 1].expe,
            students[(*count) - 1].requ,
            students[(*count) - 1].sum);
        //��һ��Ԫ�ص�������0������(*count) - 1�����ӣ���һ��ѭ��count���1��
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
        printf("¼��ɹ���\n");

    }
}





//����ѧ����Ϣ������1��
void search()
{
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("no file");
        exit(EXIT_FAILURE);
    }
    printf("�ļ��򿪳ɹ�\n");
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
    /*printf("���ļ��ж�ȡ����ѧ����Ϣ���£�\n");
    for (int i = 0; i < numStu; i++) {
        printf("ѧ�ţ�%d��������%s��ѡ�޿γɼ���%.2lf��ʵ��γɼ���%.2lf�����޿γɼ���%.2lf���ܷ֣�%.2lf\n",
            imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
    }*/
    int a;
    printf("������Ҫ��ѯ��ѧ��\n");
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
            printf("ѧ�ţ�%d��������%s��ѡ�޿γɼ���%.2lf��ʵ��γɼ���%.2lf�����޿γɼ���%.2lf���ܷ֣�%.2lf\n",
                imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
            return;

        }
    }
    printf("δ��ѯ��������Ϣ\n");//�����100��û���ҵ���ѭ����������ʾû�и�����Ϣ

}






//ɾ��ѧ����Ϣ����
void del()
{
    // ������ֻ��ģʽ���ļ�����ȡѧ����Ϣ
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("�޷����ļ�");
        return;
    }
    int numStu = 0;
    // ���ļ��ж�ȡѧ����Ϣ���洢�� imformation ������
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
    // ��ʾ�û�����Ҫɾ����ѧ��ѧ��
    printf("������Ҫɾ��ѧ����ѧ�ţ�");
    scanf("%d", &del_num);

    // ����Ƿ��ҵ�Ҫɾ����ѧ��
    int found = 0;
    // �Զ�дģʽ���ļ�
    file = fopen("school.csv", "w");//"w"ֻдģʽ������ļ������ڣ������ļ�������ļ����ڣ�����ļ�
    if (file == NULL) {
        perror("�޷����ļ�����д��");
        return;
    }
    for (int i = 0; i < numStu; i++) {
        // �������Ҫɾ����ѧ����������Ϣ����д���ļ�
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
        printf("ѧ��Ϊ %d ��ѧ����Ϣ��ɾ����\n", del_num);
    }
    else {
        printf("δ�ҵ�ѧ��Ϊ %d ��ѧ����Ϣ��\n", del_num);
    }
}





//�޸�ѧ����Ϣ����
void modify()
{
    // ������ֻ��ģʽ���ļ�����ȡѧ����Ϣ
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("�޷����ļ�");
        return;
    }
    int numStu = 0;
    // ���ļ��ж�ȡѧ����Ϣ���洢�� imformation ������
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
    // ��ʾ�û�����Ҫ�޸ĵ�ѧ��ѧ��
    printf("������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
    scanf("%d", &modify_num);


    // ����Ƿ��ҵ�Ҫ�޸ĵ�ѧ��
    int found = 0;


    // �Զ�дģʽ���ļ�
    file = fopen("school.csv", "r+");
    if (file == NULL) {
        perror("�޷����ļ�����д��");
        return;
    }


    for (int j = 0; j < numStu; j++) {
        if (imformation[j].num == modify_num) {
            // �����ǰѧ����Ϣ
            printf("Ŀǰ��ѧ����Ϣ��\n");
            printf("ѧ�ţ�%d��������%s��ѡ�޿γɼ���%.2lf��ʵ��γɼ���%.2lf�����޿γɼ���%.2lf���ܷ֣�%.2lf\n",
                imformation[j].num, imformation[j].name, imformation[j].elec, imformation[j].expe, imformation[j].requ, imformation[j].sum);


            // ��ʾ�û������µ���Ϣ
            printf("�޸�ѧ��Ϊ��");
            scanf("%d", &imformation[j].num);
            printf("�޸�����Ϊ��");
            scanf("%s", imformation[j].name);
            printf("�޸�ѡ�޿γɼ�Ϊ��");
            scanf("%lf", &imformation[j].elec);
            printf("�޸�ʵ��γɼ�Ϊ��");
            scanf("%lf", &imformation[j].expe);
            printf("�޸ı��޿γɼ�Ϊ��");
            scanf("%lf", &imformation[j].requ);
            // ���¼����ܷ�
            imformation[j].sum = imformation[j].elec + imformation[j].expe + imformation[j].requ;
            printf("�޸ĺ��ѧ����Ϣ��\n");
            printf("ѧ�ţ�%d��������%s��ѡ�޿γɼ���%.2lf��ʵ��γɼ���%.2lf�����޿γɼ���%.2lf���ܷ֣�%.2lf\n",
                imformation[j].num, imformation[j].name, imformation[j].elec, imformation[j].expe, imformation[j].requ, imformation[j].sum);


            // ���ļ�ָ�붨λ���޸ĵ�λ��
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
        printf("δ�ҵ�Ҫ�޸ĵ�ѧ��ѧ�š�\n");
    }


    fclose(file);
}





//����ѧ����Ϣ����
void insert()
{
    // ������ֻ��ģʽ���ļ�����ȡѧ����Ϣ
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("�޷����ļ�");
        return;
    }
    int numStu = 0;
    // ���ļ��ж�ȡѧ����Ϣ���洢�� imformation ������
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
    printf("������Ҫ�����λ�ã��� 0 ��ʼ����");
    scanf("%d", &insert_num);


    // ��Χ���
    if (insert_num < 0 || insert_num > numStu) {
        printf("����λ����Ч��\n");
        return;
    }


    // ������λ��֮���Ԫ������ƶ�
    for (int i = numStu; i >= insert_num; i--) {
        imformation[i + 1] = imformation[i];
    }


    // ��ʾ�û������µ���Ϣ
    printf("�������µ���Ϣ��\n");
    printf("ѧ��Ϊ��");
    scanf("%d", &imformation[insert_num].num);
    printf("����Ϊ��");
    scanf("%s", imformation[insert_num].name);
    printf("ѡ�޿γɼ�Ϊ��");
    scanf("%lf", &imformation[insert_num].elec);
    printf("ʵ��γɼ�Ϊ��");
    scanf("%lf", &imformation[insert_num].expe);
    printf("���޿γɼ�Ϊ��");
    scanf("%lf", &imformation[insert_num].requ);
    // �����ܷ�
    imformation[insert_num].sum = imformation[insert_num].elec + imformation[insert_num].expe + imformation[insert_num].requ;


    // �Զ�дģʽ���ļ�
    file = fopen("school.csv", "w+");
    if (file == NULL) {
        perror("�޷����ļ�����д��");
        return;
    }


    // ������ѧ����Ϣд���ļ�
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
    printf("����ɹ���\n");
}




//��������
void swap(stu* a, stu* b)
{
    stu temp = *a;
    *a = *b;
    *b = temp;
}




//ѧ���ɼ�������
void order()
{
    // ������ֻ��ģʽ���ļ�����ȡѧ����Ϣ
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("�޷����ļ�");
        return;
    }
    int numStu = 0;
    // ���ļ��ж�ȡѧ����Ϣ���洢�� imformation ������
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
    for (int i = 0; i < numStu; i++) //��ӡ����������
    {
        printf("ѧ�ţ�%d��������%s��ѡ�޿γɼ���%.2lf��ʵ��γɼ���%.2lf�����޿γɼ���%.2lf���ܷ֣�%.2lf\n",
            imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
    }

}




//ͳ��ѧ����������
void total()
{
    int n=0;//�ֲ�����һ��������¼ѧ����������
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("no file");
        exit(EXIT_FAILURE);
    }
    printf("�ļ��򿪳ɹ�\n");
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
        //�������û�д洢��Ϣ����Ӧ����һ��ѧ�����ۼ�֮ǰ�����ж�
        if (imformation[i].num != NULL)
        {
            n++;
        }

    }
    printf("��ǰѧ������Ϊ��%d\n", n);


}




//��ʾ����ѧ����Ϣ����
void show()
{
    FILE* file = fopen("school.csv", "r");
    if (file == NULL) {
        perror("no file");
        exit(EXIT_FAILURE);
    }
    printf("�ļ��򿪳ɹ�\n");
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
    printf("���ļ��ж�ȡ����ѧ����Ϣ���£�\n");
    for (int i = 0; i < numStu; i++)
    {
        printf("ѧ�ţ�%d��������%s��ѡ�޿γɼ���%.2lf��ʵ��γɼ���%.2lf�����޿γɼ���%.2lf���ܷ֣�%.2lf\n",
            imformation[i].num, imformation[i].name, imformation[i].elec, imformation[i].expe, imformation[i].requ, imformation[i].sum);
    }
}




//----------------------------------------------------------------------------------------





// ������ʵ��
int main() {
    int choice;

    // ��ʾ���˵�
    menu();

    // ѡ���ܲ�ִ��
    while (1) {
        printf("��ѡ��<0-8>��");

        // ���������ĸ������ѭ��
        if (scanf("%d", &choice) != 1) { // ��������Ƿ�Ϊ����
            printf("������Ч�����������֣�\n");
            while (getchar() != '\n');  // ������뻺����
            continue;  // ���½���ѭ��
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
        default: printf("��Чѡ������������\n"); break;
        }
    }

    return 0;
}