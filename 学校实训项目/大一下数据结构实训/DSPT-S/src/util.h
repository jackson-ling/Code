#ifndef UTIL_H_2DF2C_D0AZASGC_GD94D_C48G__INCLUDED_
#define UTIL_H_2DF2C_D0AZASGC_GD94D_C48G__INCLUDED_

#include "ds.h"

#define IS_DIGITAL_CHAR(ch) (((ch) <= '9') && ('0' <= (ch)))
#define numof(a) (sizeof(a) / sizeof(a[0]))
#define SKIP_SPACE(s, pos) do{while((s[pos]==' ')) pos++;}while(0)
#define REV_SKIP_SPACE(s, pos) do{while((s[pos]==' ') && (pos >= 0)) pos--;}while(0)
#define IS_NULL_STR(s) (*(s) == '\0')



#if 1
#ifdef ASSERT
#undef ASSERT
#endif
#define ASSERT(b) assert(b)
#endif

#define VERIFY(b) do{if(!(b)){printf("%s line-%d VERIFY fail.\n", __FILE__, __LINE__);}}while(0)
#define VERIFY_RETURNVAL(b, v) do{if(!(b)){printf("%s line-%d VERIFY fail.\n", __FILE__, __LINE__); return v;}}while(0)
#define VERIFY_RETURN(b) do{if(!(b)){printf("%s line-%d VERIFY fail.\n", __FILE__, __LINE__); return;}}while(0)

#define RETURN_MSG(msg) do{printf(msg); return;}while(0);
#define RETURN_VAL_MSG(v, msg) do{printf(msg); return v;}while(0);

extern bool InputString(char* pszInput, int nMaxSize, const char* pszPrompt = NULL);
extern bool InputChar(char &ch, const char* pszPrompt = NULL);
extern bool InputInteger(int& nInput, const char* pszPrompt = NULL);
extern bool IsInputYes(const char* pszQuestion);

extern bool IsDigital(const char* s);

extern bool IsSameString(const char* a, const char* b, bool bCaseSensitive = true);

extern char LowercaseChar(char ch); //将字符转小写
extern char UppercaseChar(char ch);  //将字符转大写

#endif // !defined(UTIL_H_2DF2C_D0AZASGC_GD94D_C48G__INCLUDED_)
