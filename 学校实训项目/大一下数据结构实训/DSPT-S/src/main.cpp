#include <stdio.h>
#include "ds.h"

static char gExeFileFullName[1024];  //EXE�ļ���(��·��)
extern void OnMainCmd(void *para);

int main(int argc, char** argv)
{
    strcpy(gExeFileFullName, argv[0]); //��¼��ִ���ļ�ȫ·���� 
	OnMainCmd(NULL);
	return 0;
}

const char* GetExeFileFullName()
{
    return gExeFileFullName;
}


