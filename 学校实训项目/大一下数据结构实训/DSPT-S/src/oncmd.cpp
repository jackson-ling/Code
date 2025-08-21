#include <stdlib.h>
#include <search.h>
#include "util.h"
#include "sqlist.h"
#include "linklist.h"
#include "log.h"

#define WIN_TITLE "����ҵ���Ŷӹ���ϵͳ"

Status SysInit(); //ϵͳ��ʼ�� 
void SysFinal(); //ϵͳ�ս� 

void OnCustomerArrive(void *para);
void OnCustomerLeave(void *para);
void OnCfgMan(void *para);

void OnServiceTypeAdd(void *para);
void OnServiceTypeEdit(void *para);
void OnServiceTypeView(void *para);
void OnWinAdd(void *para);
void OnWinDel(void *para);
void OnWinEdit(void *para);
void OnWinView(void *para);
void OnStat(void *para);
void OnWinPause(void *para);
void OnWinResume(void *para);

void OnMainCmd(void *para)
{
	SCmd acmd[] = {{"CustomerArrive",  "ȡ���Ŷ�",   OnCustomerArrive},
                   {"CustomerLeave",   "������",   OnCustomerLeave},
                   {"",                "",           NULL},
                   {"WinPause",        "ҵ����ͣ",   OnWinPause},
                   {"WinResume",       "ҵ��ָ�",   OnWinResume},
                   {"",                "",           NULL},
                   {"Stat",            "ҵ��ͳ��",   OnStat},
                   {"WinView",         "���Ȳ鿴",   OnWinView},
                   {"",                "",           NULL},
                   {"CfgMan",          "���ù���...", OnCfgMan}
	};

    if (!SysInit()) return;
	CmdLoop(WIN_TITLE, acmd, numof(acmd), NULL);
	SysFinal();
}

//���ù��� 
void OnCfgMan(void *para)
{
	SCmd acmd[] = {{"ServiceTypeAdd",  "ҵ������",   OnServiceTypeAdd},
	               {"ServiceTypeEdit", "ҵ���޸�",   OnServiceTypeEdit},
	               {"ServiceTypeView", "ҵ��鿴",   OnServiceTypeView},
	               {"",                "",           NULL},
                   {"WinAdd",          "��������",   OnWinAdd},
                   {"WinDel",          "����ɾ��",   OnWinDel},
                   {"WinEdit",         "�����޸�",   OnWinEdit},
                   {"WinView",         "���ڲ鿴",   OnWinView}
	};
    CmdLoop(WIN_TITLE, acmd, numof(acmd), para);
}

//ϵͳ��ʼ�� 
Status SysInit()
{
    TBD_RETURN(OK);
}

//ϵͳ�ս� 
void SysFinal()
{
    TBD; 
}

void OnServiceTypeAdd(void *para)
{
    TBD; 
}

void OnServiceTypeEdit(void *para)
{
    TBD; 
}

void OnServiceTypeView(void *para)
{
    TBD;
}

void OnWinAdd(void *para)
{
    TBD;
}

void OnWinDel(void *para)
{
    TBD;
}

void OnWinEdit(void *para)
{
    TBD;
}

void OnWinView(void *para)
{
    TBD;
}

/*----------------------------------------------------------------
ͳ�ƣ� 
1. ���ÿ��ҵ��ͳ���˾�ҵ�����ʱ�䡢�˾��Ŷӵȴ�ʱ��
2. ���ÿ�����ڣ�ͳ���˾�ҵ�����ʱ�䡢�˾��Ŷӵȴ�ʱ��
ҵ�����ʱ�䣺�û����ﴰ���ύ���ϵ�ҵ����������ʱ��
�Ŷӵȴ�ʱ�䣺�û�ȡ�ŵ�ҵ��ʼ��������ʱ�䡣
��ʾʱ�������û�ѡ�������Ŷ�ʱ�����򣬻�����ҵ�����ʱ������ 
----------------------------------------------------------------*/
void OnStat(void *para)
{
    TBD;
}

void OnWinPause(void *para)
{
    TBD;
}

void OnWinResume(void *para)
{
    TBD;
}

void OnCustomerArrive(void *para)
{
    TBD;
}

void OnCustomerLeave(void *para)
{
    TBD;
}


