#include <stdlib.h>
#include <search.h>
#include "util.h"
#include "sqlist.h"
#include "linklist.h"
#include "log.h"

#define WIN_TITLE "银行业务排队管理系统"

Status SysInit(); //系统初始化 
void SysFinal(); //系统终结 

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
	SCmd acmd[] = {{"CustomerArrive",  "取号排队",   OnCustomerArrive},
                   {"CustomerLeave",   "办结离队",   OnCustomerLeave},
                   {"",                "",           NULL},
                   {"WinPause",        "业务暂停",   OnWinPause},
                   {"WinResume",       "业务恢复",   OnWinResume},
                   {"",                "",           NULL},
                   {"Stat",            "业务统计",   OnStat},
                   {"WinView",         "进度查看",   OnWinView},
                   {"",                "",           NULL},
                   {"CfgMan",          "配置管理...", OnCfgMan}
	};

    if (!SysInit()) return;
	CmdLoop(WIN_TITLE, acmd, numof(acmd), NULL);
	SysFinal();
}

//配置管理 
void OnCfgMan(void *para)
{
	SCmd acmd[] = {{"ServiceTypeAdd",  "业务新增",   OnServiceTypeAdd},
	               {"ServiceTypeEdit", "业务修改",   OnServiceTypeEdit},
	               {"ServiceTypeView", "业务查看",   OnServiceTypeView},
	               {"",                "",           NULL},
                   {"WinAdd",          "窗口新增",   OnWinAdd},
                   {"WinDel",          "窗口删除",   OnWinDel},
                   {"WinEdit",         "窗口修改",   OnWinEdit},
                   {"WinView",         "窗口查看",   OnWinView}
	};
    CmdLoop(WIN_TITLE, acmd, numof(acmd), para);
}

//系统初始化 
Status SysInit()
{
    TBD_RETURN(OK);
}

//系统终结 
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
统计： 
1. 针对每类业务，统计人均业务办理时间、人均排队等待时间
2. 针对每个窗口，统计人均业务办理时间、人均排队等待时间
业务办理时间：用户到达窗口提交资料到业务办结所花费时间
排队等待时间：用户取号到业务开始办理所用时间。
显示时，允许用户选择是以排队时间排序，还是以业务办理时间排序 
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


