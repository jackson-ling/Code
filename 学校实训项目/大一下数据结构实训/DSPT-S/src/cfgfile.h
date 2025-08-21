#if !defined(CFG_FILE_H_BF724AE6B8498_0E08FHS5E83_31EEF_INCLUDED_)
#define CFG_FILE_H_BF724AE6B8498_0E08FHS5E83_31EEF_INCLUDED_

#include <stdio.h>

/*===============================================================
                ��д�����ļ�
===============================================================*/
typedef struct
{
    int  nTypeId; //����ID(��1��ʼ)
    char szTypeName[50]; //��������
    char reserved[32]; //Ԥ�����Ա���չ 
} SServiceType; //ҵ������ 

typedef struct
{
    int nWinId; //���ڱ��(��1��ʼ)
    int nTypeId; //�ô��ڰ����ҵ������ID
    bool bIsVIP; //�Ƿ�VIPר�ô���
    char reserved[32]; //Ԥ�����Ա���չ 
} SWinCfg; //��������

//"CFGF_"ǰ׺��ʾ�����ļ���ConFiGure File���������� 
//�����ļ��Ĵ���ر�
extern FILE* CFGF_Open();
extern void CFGF_Close(FILE* f);

//��дҵ����������
extern void CFGF_MoveFirstServiceType(FILE* f);
extern bool CFGF_ReadServiceType(FILE* f, SServiceType &type);
extern bool CFGF_WriteServiceType(FILE* f, const SServiceType *type);
extern bool CFGF_WriteServiceType(const SServiceType *type);

//��д����
extern void CFGF_MoveFirstWinCfg(FILE* f);
extern bool CFGF_ReadWinCfg(FILE* f, SWinCfg &win);
extern bool CFGF_WriteWinCfg(FILE* f, const SWinCfg *win);
extern bool CFGF_WriteWinCfg(const SWinCfg *win);
extern void CFGF_DeleteWinCfg(int nWinId);

extern int CFGF_GetMaxServiceTypeId();
extern int CFGF_GetMaxWinId();

#endif
