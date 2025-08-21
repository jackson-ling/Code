#if !defined(LOG_H_BFCB72PS_JDGM67KG8EF_INCLUDED_)
#define LOG_H_BFCB72PS_JDGM67KG8EF_INCLUDED_

#include <stdio.h>

typedef unsigned int U32;
/*===============================================================
                读写日志文件
===============================================================*/
typedef struct
{
    int nServiceTypeId; //业务类型ID
    int nWinId;  //窗口编号
    U32 nQueueWaitSec; //排队等待时间（单位：秒） 
    U32 nServiceSec;   //业务办理时间（单位：秒）  
    char reserved[32];   //无用，留待扩展 
} SLog;

//"LOG_"前缀表示日志操作函数 
//日志文件的打开与关闭 
extern FILE* LOG_Open();
extern void LOG_Close(FILE* f);

//日志文件的读写
extern bool LOG_Read(FILE* f, SLog &log);
extern bool LOG_Write(const SLog &log);

#endif
