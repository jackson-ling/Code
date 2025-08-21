#if !defined(CMD_H_22CD0AZASGCGD94DC48G__INCLUDED_)
#define CMD_H_22CD0AZASGCGD94DC48G__INCLUDED_

#include "ds.h"

/*===============================================================
                命令行处理
===============================================================*/

typedef void (*CmdHandle)(void* para);

typedef struct
{
	char      szCmdName[32]; /* 命令名称 */
	char      szCmdDesc[64]; /* 命令描述信息 */
	CmdHandle fpCmdFun;      /* 命令响应函数 */
} SCmd;
extern int CmdLoop(const char *pszTitle, const SCmd cmd[], int nCmdNum, void *para = NULL, int nCmdSeqBase = 1);

#endif // !defined(CMD_H_22CD0AZASGCGD94DC48G__INCLUDED_)
