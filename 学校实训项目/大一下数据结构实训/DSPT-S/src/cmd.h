#if !defined(CMD_H_22CD0AZASGCGD94DC48G__INCLUDED_)
#define CMD_H_22CD0AZASGCGD94DC48G__INCLUDED_

#include "ds.h"

/*===============================================================
                �����д���
===============================================================*/

typedef void (*CmdHandle)(void* para);

typedef struct
{
	char      szCmdName[32]; /* �������� */
	char      szCmdDesc[64]; /* ����������Ϣ */
	CmdHandle fpCmdFun;      /* ������Ӧ���� */
} SCmd;
extern int CmdLoop(const char *pszTitle, const SCmd cmd[], int nCmdNum, void *para = NULL, int nCmdSeqBase = 1);

#endif // !defined(CMD_H_22CD0AZASGCGD94DC48G__INCLUDED_)
