#include "log.h"
#include "string.h"

static char FormatCode[16] = {0x20, 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, 0x2A, 0x2B, 0x2C, 0x2D, 0x2E, 0x2F};
extern const char* GetExeFileFullName();

FILE* LOG_Open()
{
    char byHdr[16];
    char szFileName[1024] = {0};
    char *pLast;
    FILE *f;
    
    //1 �����ļ��� 
    strcpy(szFileName, GetExeFileFullName());
    pLast = strrchr(szFileName, '.');
    strcpy(pLast + 1, "log");

    //2 ���ļ�
    f = fopen(szFileName, "a+b");
    fread(byHdr, sizeof(byHdr), 1, f); //���Զ�ȡ�ļ�ͷ 
    if (feof(f) || ferror(f)) //���������ɵ��ļ���д���ʽ��� 
    {
        fseek(f, 0, SEEK_SET);
        fwrite(FormatCode, sizeof(FormatCode), 1, f);
        fseek(f, 0, SEEK_END);
    }
    else//���Ѵ����ļ����и�ʽ�ж� 
    {
        if (memcmp(byHdr, FormatCode, sizeof(FormatCode)) != 0) //��ʽ�Ƿ� 
        {
            printf("%s is not correct-format logfile.\n", szFileName);
            fclose(f);
            f = NULL;
        }
    }

    return f;
}

void LOG_Close(FILE* f)
{
    fclose(f);
}

bool LOG_Read(FILE* f, SLog &log)
{
    if (feof(f)) return false;
    
    return fread(&log, sizeof(log), 1, f) == 1;
}

bool LOG_Write(const SLog &log)
{
    FILE *f = LOG_Open();
    bool bOk = false;
    
    if (!f) return bOk;
    
    fseek(f, 0, SEEK_END);
    bOk = (fwrite(&log, sizeof(log), 1, f) == 1);
    LOG_Close(f);
    
    printf("д���ļ���nServiceTypeId=%d, nWinId=%d, nServiceSec=%d, nQueueWaitSec=%d\n", log.nServiceTypeId, log.nWinId, log.nServiceSec, log.nQueueWaitSec);

    return bOk;
}

