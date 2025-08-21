// stdafx.h : include file for standard system include files,
//  or project specific include files that are used frequently, but
//      are changed infrequently
//

#if !defined(AFX_DS_H_BF72AE6B_81444960_80E_F08F5E8331EEF_INCLUDED_)
#define AFX_DS_H_BF72AE6B_81444960_80E_F08F5E8331EEF_INCLUDED_

//#define _MSC_VER 0
#ifndef NULL
#define NULL 0
#endif

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "cmd.h"
#include "util.h"

#define TBD do{printf("请实现%s 第%d行所在函数！\n", __FILE__, __LINE__);}while(0)
#define TBD_RETURN(code) do{printf("请实现%s 第%d行所在函数！\n",  __FILE__, __LINE__); return code;}while(0)

#define FALSE 0
#define TRUE  1

#define OK       1
#define ERROR    0
#define OVERFLOW 2

typedef int Status;


//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_STDAFX_H__BF72AE6B_8144_4960_80EF_08F5E8331EEF__INCLUDED_)
