#include "cfgfile.h"
#include <string.h>

extern const char* GetExeFileFullName();

static char FormatCode[16] = {0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F};
typedef struct
{
    char Format[16];
    int  nServiceTypeNumMax; //最多有多少种业务类型 
    int  nWinNumMax; //最多的窗口数 
    char reserved[32]; //无用，留待扩展 
} SFileHdr;
SFileHdr gFileHdr;

/*===============================================================
                读写配置文件
配置文件格式:
    格式码 16字节
    最多窗口类型数m 4字节
    最多窗口个数n   4字节
    m条窗口类型
    n条窗口配置
===============================================================*/

//打开配置文件 
FILE* CFGF_Open()
{
    char szFileName[1024] = {0};
    char *pLast;
    FILE *f;
    
    //1 构造配置文件名 
    strcpy(szFileName, GetExeFileFullName());
    pLast = strrchr(szFileName, '.');
    strcpy(pLast + 1, "cfg");
    
    //2 打开文件
    f = fopen(szFileName, "r+b");
    if (f)
    {
        fread(&gFileHdr, sizeof(gFileHdr), 1,f);
        if (memcmp(&gFileHdr, FormatCode, sizeof(FormatCode)) != 0) //格式不正确 
        {
            fclose(f);
            return NULL;
        }
    }
    else //文件不存在，创建一个空文件 
    {
        f = fopen(szFileName, "w+b");
        
        //2.1 写入文件头 
        memcpy(gFileHdr.Format, FormatCode, sizeof(FormatCode));
        gFileHdr.nServiceTypeNumMax = 20;
        gFileHdr.nWinNumMax         = 100;
        fwrite(&gFileHdr, sizeof(gFileHdr), 1, f);
        
        //2.2 写入空数据
        char *pNull;
        int len = sizeof(SServiceType)* gFileHdr.nServiceTypeNumMax + sizeof(SWinCfg) * gFileHdr.nWinNumMax;

        pNull = new char[len];
        memset(pNull, 0, len);
        fwrite(pNull, len, 1, f);
        delete pNull;
    }
    
    return f;
}

//关闭配置文件 
void CFGF_Close(FILE* f)
{
    fclose(f);
}

//将文件指针移动到首条业务类型 
void CFGF_MoveFirstServiceType(FILE* f)
{
    fseek(f, sizeof(gFileHdr), SEEK_SET);
}

//读取当前文件指针所指向的业务类型配置 
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

//将业务类型配置写入文件 
bool CFGF_WriteServiceType(FILE* f, const SServiceType *type)
{
    //参数合法性检查 
    if ((type->nTypeId < 1) || (type->nTypeId > gFileHdr.nServiceTypeNumMax)) return false;
    
    //调整文件指针到存储该窗口的位置 
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

//将文件指针移动到首条窗口记录 
void CFGF_MoveFirstWinCfg(FILE* f)
{
    fseek(f, sizeof(gFileHdr) + gFileHdr.nServiceTypeNumMax * sizeof(SServiceType), SEEK_SET);
}

//读取当前文件指针所指向的窗口记录
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

//将窗口记录写入文件 
bool CFGF_WriteWinCfg(FILE* f, const SWinCfg *wincfg)
{
    long nOffset = sizeof(gFileHdr);
    
    //参数合法性检查 
    if ((wincfg->nWinId < 1) || (wincfg->nWinId > gFileHdr.nWinNumMax)) return false;
    
    //调整文件指针到存储该窗口的位置 
    nOffset += gFileHdr.nServiceTypeNumMax * sizeof(SServiceType);
    nOffset += (wincfg->nWinId - 1) * sizeof(SWinCfg);    
    fseek(f, nOffset, SEEK_SET);
    
    //写入数据 
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

//删除窗口
void CFGF_DeleteWinCfg(int nWinId)
{
    FILE *f = CFGF_Open();
    SWinCfg wincfg = {0};
    long nOffset = sizeof(gFileHdr);
    
    if (!f) return;
    
    //参数合法性检查 
    if ((nWinId < 1) || (nWinId > gFileHdr.nWinNumMax)) return;
    
    //调整文件指针到存储该窗口的位置 
    nOffset += gFileHdr.nServiceTypeNumMax * sizeof(SServiceType);
    nOffset += (nWinId - 1) * sizeof(SWinCfg);    
    fseek(f, nOffset, SEEK_SET);
    
    //写入空数据，表示删除 
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

