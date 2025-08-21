#include <stdio.h>
#include "ds.h"

static char gExeFileFullName[1024];  //EXE文件名(含路径)
extern void OnMainCmd(void *para);

int main(int argc, char** argv)
{
    strcpy(gExeFileFullName, argv[0]); //记录可执行文件全路径名 
	OnMainCmd(NULL);
	return 0;
}

const char* GetExeFileFullName()
{
    return gExeFileFullName;
}


