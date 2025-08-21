#if !defined(LOG_H_BFCB72PS_JDGM67KG8EF_INCLUDED_)
#define LOG_H_BFCB72PS_JDGM67KG8EF_INCLUDED_

#include <stdio.h>

typedef unsigned int U32;
/*===============================================================
                ��д��־�ļ�
===============================================================*/
typedef struct
{
    int nServiceTypeId; //ҵ������ID
    int nWinId;  //���ڱ��
    U32 nQueueWaitSec; //�Ŷӵȴ�ʱ�䣨��λ���룩 
    U32 nServiceSec;   //ҵ�����ʱ�䣨��λ���룩  
    char reserved[32];   //���ã�������չ 
} SLog;

//"LOG_"ǰ׺��ʾ��־�������� 
//��־�ļ��Ĵ���ر� 
extern FILE* LOG_Open();
extern void LOG_Close(FILE* f);

//��־�ļ��Ķ�д
extern bool LOG_Read(FILE* f, SLog &log);
extern bool LOG_Write(const SLog &log);

#endif
