#if !defined(CFG_FILE_H_BF724AE6B8498_0E08FHS5E83_31EEF_INCLUDED_)
#define CFG_FILE_H_BF724AE6B8498_0E08FHS5E83_31EEF_INCLUDED_

#include <stdio.h>

/*===============================================================
                读写配置文件
===============================================================*/
typedef struct
{
    int  nTypeId; //类型ID(从1开始)
    char szTypeName[50]; //类型名称
    char reserved[32]; //预留，以备扩展 
} SServiceType; //业务类型 

typedef struct
{
    int nWinId; //窗口编号(从1开始)
    int nTypeId; //该窗口办理的业务类型ID
    bool bIsVIP; //是否VIP专用窗口
    char reserved[32]; //预留，以备扩展 
} SWinCfg; //窗口配置

//"CFGF_"前缀表示配置文件（ConFiGure File）操作函数 
//配置文件的打开与关闭
extern FILE* CFGF_Open();
extern void CFGF_Close(FILE* f);

//读写业务类型配置
extern void CFGF_MoveFirstServiceType(FILE* f);
extern bool CFGF_ReadServiceType(FILE* f, SServiceType &type);
extern bool CFGF_WriteServiceType(FILE* f, const SServiceType *type);
extern bool CFGF_WriteServiceType(const SServiceType *type);

//读写窗口
extern void CFGF_MoveFirstWinCfg(FILE* f);
extern bool CFGF_ReadWinCfg(FILE* f, SWinCfg &win);
extern bool CFGF_WriteWinCfg(FILE* f, const SWinCfg *win);
extern bool CFGF_WriteWinCfg(const SWinCfg *win);
extern void CFGF_DeleteWinCfg(int nWinId);

extern int CFGF_GetMaxServiceTypeId();
extern int CFGF_GetMaxWinId();

#endif
