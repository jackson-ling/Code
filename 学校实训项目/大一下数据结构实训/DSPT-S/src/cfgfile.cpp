#include "cfgfile.h"
#include <string.h>

extern const char* GetExeFileFullName();

static char FormatCode[16] = {0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F};
typedef struct
{
    char Format[16];
    int  nServiceTypeNumMax; //����ж�����ҵ������ 
    int  nWinNumMax; //���Ĵ����� 
    char reserved[32]; //���ã�������չ 
} SFileHdr;
SFileHdr gFileHdr;

/*===============================================================
                ��д�����ļ�
�����ļ���ʽ:
    ��ʽ�� 16�ֽ�
    ��ര��������m 4�ֽ�
    ��ര�ڸ���n   4�ֽ�
    m����������
    n����������
===============================================================*/

//�������ļ� 
FILE* CFGF_Open()
{
    char szFileName[1024] = {0};
    char *pLast;
    FILE *f;
    
    //1 ���������ļ��� 
    strcpy(szFileName, GetExeFileFullName());
    pLast = strrchr(szFileName, '.');
    strcpy(pLast + 1, "cfg");
    
    //2 ���ļ�
    f = fopen(szFileName, "r+b");
    if (f)
    {
        fread(&gFileHdr, sizeof(gFileHdr), 1,f);
        if (memcmp(&gFileHdr, FormatCode, sizeof(FormatCode)) != 0) //��ʽ����ȷ 
        {
            fclose(f);
            return NULL;
        }
    }
    else //�ļ������ڣ�����һ�����ļ� 
    {
        f = fopen(szFileName, "w+b");
        
        //2.1 д���ļ�ͷ 
        memcpy(gFileHdr.Format, FormatCode, sizeof(FormatCode));
        gFileHdr.nServiceTypeNumMax = 20;
        gFileHdr.nWinNumMax         = 100;
        fwrite(&gFileHdr, sizeof(gFileHdr), 1, f);
        
        //2.2 д�������
        char *pNull;
        int len = sizeof(SServiceType)* gFileHdr.nServiceTypeNumMax + sizeof(SWinCfg) * gFileHdr.nWinNumMax;

        pNull = new char[len];
        memset(pNull, 0, len);
        fwrite(pNull, len, 1, f);
        delete pNull;
    }
    
    return f;
}

//�ر������ļ� 
void CFGF_Close(FILE* f)
{
    fclose(f);
}

//���ļ�ָ���ƶ�������ҵ������ 
void CFGF_MoveFirstServiceType(FILE* f)
{
    fseek(f, sizeof(gFileHdr), SEEK_SET);
}

//��ȡ��ǰ�ļ�ָ����ָ���ҵ���������� 
bool CFGF_ReadServiceType(FILE* f, SServiceType &type)
{
    long MaxOffset = sizeof(gFileHdr);
    
    MaxOffset += gFileHdr.nServiceTypeNumMax * sizeof(SServiceType);
    while (ftell(f) < MaxOffset)
    {
        fread(&type, sizeof(type), 1, f);
        if (type.nTypeId > 0) return true;
    }

    return false;
}

//��ҵ����������д���ļ� 
bool CFGF_WriteServiceType(FILE* f, const SServiceType *type)
{
    //�����Ϸ��Լ�� 
    if ((type->nTypeId < 1) || (type->nTypeId > gFileHdr.nServiceTypeNumMax)) return false;
    
    //�����ļ�ָ�뵽�洢�ô��ڵ�λ�� 
    fseek(f, sizeof(gFileHdr) + (type->nTypeId - 1)*sizeof(SServiceType), SEEK_SET);
    
    return fwrite(type, sizeof(SServiceType), 1, f) > 0;
}

bool CFGF_WriteServiceType(const SServiceType *type)
{
    FILE *f = CFGF_Open();
    
    if (!f) return false;
    CFGF_WriteServiceType(f, type);
    CFGF_Close(f);
    
    return true;
}

//���ļ�ָ���ƶ����������ڼ�¼ 
void CFGF_MoveFirstWinCfg(FILE* f)
{
    fseek(f, sizeof(gFileHdr) + gFileHdr.nServiceTypeNumMax * sizeof(SServiceType), SEEK_SET);
}

//��ȡ��ǰ�ļ�ָ����ָ��Ĵ��ڼ�¼
bool CFGF_ReadWinCfg(FILE* f, SWinCfg &wincfg)
{
    long MaxOffset = sizeof(gFileHdr);
    
    MaxOffset += gFileHdr.nServiceTypeNumMax * sizeof(SServiceType);
    MaxOffset += gFileHdr.nWinNumMax * sizeof(SWinCfg);
    
    while (ftell(f) < MaxOffset)
    {
        fread(&wincfg, sizeof(wincfg), 1, f);
        if (wincfg.nWinId > 0) return true;
    }
    
    return false;
}

//�����ڼ�¼д���ļ� 
bool CFGF_WriteWinCfg(FILE* f, const SWinCfg *wincfg)
{
    long nOffset = sizeof(gFileHdr);
    
    //�����Ϸ��Լ�� 
    if ((wincfg->nWinId < 1) || (wincfg->nWinId > gFileHdr.nWinNumMax)) return false;
    
    //�����ļ�ָ�뵽�洢�ô��ڵ�λ�� 
    nOffset += gFileHdr.nServiceTypeNumMax * sizeof(SServiceType);
    nOffset += (wincfg->nWinId - 1) * sizeof(SWinCfg);    
    fseek(f, nOffset, SEEK_SET);
    
    //д������ 
    return fwrite(wincfg, sizeof(SWinCfg), 1, f) > 0;
}

bool CFGF_WriteWinCfg(const SWinCfg *win)
{
    FILE *f = CFGF_Open();
    
    if (!f) return false;
    CFGF_WriteWinCfg(f, win);
    CFGF_Close(f);

    return true;
}

//ɾ������
void CFGF_DeleteWinCfg(int nWinId)
{
    FILE *f = CFGF_Open();
    SWinCfg wincfg = {0};
    long nOffset = sizeof(gFileHdr);
    
    if (!f) return;
    
    //�����Ϸ��Լ�� 
    if ((nWinId < 1) || (nWinId > gFileHdr.nWinNumMax)) return;
    
    //�����ļ�ָ�뵽�洢�ô��ڵ�λ�� 
    nOffset += gFileHdr.nServiceTypeNumMax * sizeof(SServiceType);
    nOffset += (nWinId - 1) * sizeof(SWinCfg);    
    fseek(f, nOffset, SEEK_SET);
    
    //д������ݣ���ʾɾ�� 
    fwrite(&wincfg, sizeof(wincfg), 1, f);
    
    CFGF_Close(f);
}

int CFGF_GetMaxServiceTypeId()
{
    return gFileHdr.nServiceTypeNumMax;
}

int CFGF_GetMaxWinId()
{
    return gFileHdr.nWinNumMax;
}

