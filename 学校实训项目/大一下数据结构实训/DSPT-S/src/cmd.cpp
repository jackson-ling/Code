#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cmd.h"
#include "util.h"

void ShowCmd(const char *pszTitle, const SCmd cmd[], int nCmdNum, int nCmdSeqBase, int CmdNo2Idx[], int CmdNo2IdxNum);
char gszCmdTip[256] = {0};

int CmdLoop(const char *pszTitle, const SCmd cmd[], int nCmdNum, void *para, int nCmdSeqBase)
{
	char szCmd[16];
	char *pLast;
	const SCmd* pCmd;
	int nCmd, CmdNo2Idx[50] = {-1};

	if (strlen(gszCmdTip) == 0) strcat(gszCmdTip, "DSPT>");
	ShowCmd(pszTitle, cmd, nCmdNum, nCmdSeqBase, CmdNo2Idx, numof(CmdNo2Idx));
	do
	{
		printf("%s", gszCmdTip);
		InputString(szCmd, sizeof(szCmd));
		if (IsSameString(szCmd, "exit", false) || IsSameString(szCmd, "q", false) || IsSameString(szCmd, "quit", false)) break;
		if (IsSameString(szCmd, "c", false) || IsSameString(szCmd, "cls", false))
		{
			system("cls");
			strcpy(szCmd, "h");
		}
		if (IsSameString(szCmd, "h", false) || IsSameString(szCmd, "help", false))
		{
			ShowCmd(pszTitle, cmd, nCmdNum, nCmdSeqBase, CmdNo2Idx, numof(CmdNo2Idx));
			continue;
		}

		if (strlen(szCmd) == 0) continue;
		if (!IsDigital(szCmd))
		{
			printf("ÃüÁî·Ç·¨£¡\r\n");
			continue;
		}

		nCmd = atoi(szCmd);
		if ((nCmd >= numof(CmdNo2Idx)) || (CmdNo2Idx[nCmd]) < 0)
		{
			printf("ÃüÁîÐòºÅ³¬ÏÞ£¡\r\n");
			continue;
		}

		pCmd = cmd + CmdNo2Idx[nCmd];
		gszCmdTip[strlen(gszCmdTip) - 1] = '/';
		strcat(gszCmdTip, pCmd->szCmdName);
		strcat(gszCmdTip, ">");

		printf("<<<   %s   >>>\n", pCmd->szCmdDesc);
		pCmd->fpCmdFun(para);

		gszCmdTip[strlen(gszCmdTip) - 1] = '\0';
		pLast = strrchr(gszCmdTip, '/');
		*pLast = '>';
		pLast++;
		*pLast = '\0';
	}while (1);

	return 0;
}

void ShowCmd(const char *pszTitle, const SCmd cmd[], int nCmdNum, int nCmdSeqBase, int CmdNo2Idx[], int CmdNo2IdxNum)
{
	const SCmd* pCmd = cmd;
	int nCmdNo = nCmdSeqBase;
	const char *strSep = "\n";
	int i;

	for (i = 0; i < CmdNo2IdxNum; i++)
	{
	    CmdNo2Idx[i] = -1;
	}

	printf("------------------------------------------------------------------\n");
	printf("              %s\n", pszTitle);
	printf("ÃüÁîºÅ\t¹¦ÄÜ\r\n");
	for (i = 0; i < nCmdNum; i++, pCmd++)
	{
	    if (pCmd->fpCmdFun)
	    {
	        printf("%d\t%s\r\n", nCmdNo, pCmd->szCmdDesc);
	        VERIFY(nCmdNo < CmdNo2IdxNum);
	        CmdNo2Idx[nCmdNo] = i;
	        nCmdNo++;
	    }
		else
		{
		    printf(strSep);
		}
	}

	printf(strSep);
	printf("c\tÇåÆÁ\r\n");
	printf("h\t°ïÖú\r\n");
	printf("q\tÍË³ö\r\n");
	printf("------------------------------------------------------------------\n");
}

