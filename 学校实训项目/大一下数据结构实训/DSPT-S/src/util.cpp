#include <stdio.h>
#include <string.h>
#include "util.h"

bool InputString(char* pszInput, int nMaxSize, const char* pszPrompt)
{
    if (pszPrompt) printf("%s", pszPrompt);
	gets(pszInput);
	return (int)strlen(pszInput) < nMaxSize;
}

bool InputChar(char &ch, const char* pszPrompt)
{
    char szInput[16];

    if (!InputString(szInput, sizeof(szInput), pszPrompt)) return false;
    ch = szInput[0];
    return true;
}

bool InputInteger(int &nInput, const char* pszPrompt)
{
    char szInput[64] = {0};

    if (!InputString(szInput, sizeof(szInput), pszPrompt)) return false;
	if (IsDigital(szInput))
	{
        nInput = atoi(szInput);
        return true;
    }
    
	return false;
}

bool IsInputYes(const char* pszQuestion)
{
    char szTip[512] = {'\0'};
    char szInput[17] = {'\0'};
    
    strcat(szTip, pszQuestion);
    strcat(szTip, "(回车表示同意，否则键入任意字符)：");

    if (!InputString(szInput, sizeof(szInput) - 1, szTip)) return false;
    return (strlen(szInput) == 0);
}

bool IsDigital(const char* s)
{
	char ch;
	int nWidth = 0;
	
	if (strlen(s) < 1) return false;
	for (unsigned int i = 0; i < strlen(s); i++)
	{
		ch = s[i];
		if (ch == ' ') continue;
		if (((ch == '+') || (ch == '-'))) 
		{
		    if (nWidth > 0) return false; //正负号只能出现在最左端
		    continue;
		}
		
		if ((ch < '0') || (ch > '9')) return false;
		nWidth++;
	}
	
	return (nWidth > 0);
}

bool IsSameString(const char* a, const char* b, bool bCaseSensitive)
{
	return ((bCaseSensitive ? strcmp(a, b) : _stricmp(a, b)) == 0);
}


//将字符转小写
char LowercaseChar(char ch)
{
    if (('A' <= ch) && (ch <= 'Z')) return 'a' + (ch - 'A');
    return ch;
}

//将字符转大写
char UppercaseChar(char ch)
{
    if (('a' <= ch) && (ch <= 'z')) return 'A' + (ch - 'a');
    return ch;
}

