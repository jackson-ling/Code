# <div style="text-align:center">对 KMP 算法的理解<div>

---

# 一、辅助理解的资料

- # [KMP 动画图解（b 站）](https://www.bilibili.com/video/BV1AY4y157yL/?spm_id_from=333.337.search-card.all.click)

- # [CSDN 博客](https://blog.csdn.net/v_JULY_v/article/details/7041827?spm=1001.2014.3001.5506)

- # [对求 next 数组的理解（b 站）](https://www.bilibili.com/video/BV16X4y137qw/?spm_id_from=333.337.search-card.all.click)

- # 补充：对 next 数组的初步理解
  - # [天勤考研（易懂版本）](https://www.bilibili.com/video/BV1jb411V78H/?spm_id_from=333.337.search-card.all.click&vd_source=822e86b53dab98632ef279a46d2536db)

# 提醒：按照顺序依次往下看，就会逐渐理解 next 数组的推到过程和代码的原理

---

# 二、KMP 基本思想回顾

## 为了充分利用已经匹配的字符信息，避免多次回溯造成的重复比较而降低了时间效率

## 两个关键点

- ## (1)主串指针不回溯
- ## (2)字串指针回溯有讲究

## 在大多数理解的材料中都会以模式串移动的方式呈现，但是实际上在计算机中并不会，如何实现移动？本质就是模式串指针回溯的位置（<span style="color:red">天勤的时评讲的很清晰</span>），接下来就要讨论到底回溯到哪个位置如何确定，于是引出了 next 数组的概念

---

# 三、next 数组的求解和理解

## 先看代码

```c
void GetNext(char* p,int next[])
{
	int pLen = strlen(p);
	next[0] = -1;
	int k = -1;
	int j = 0;
	while (j < pLen - 1)
	{
		//p[k]表示前缀，p[j]表示后缀
		if (k == -1 || p[j] == p[k])
		{
			++k;
			++j;
			next[j] = k;
		}
		else
		{
			k = next[k];
		}
	}
}
```

## 问题：为什么要使用 next 数组?

## 为了规避 BF 算法中重复比较的问题，同时充分利用已知的信息，用 next 数组记录在下一次比较中字串子帧回溯的位置

## <span style="color:red">注意：next 数组只与子串本身有关，与主串无关<span>

## 代码理解部分

> ### 1. 这是数组下标从 0 开始计数 的版本，数组下标初值设为-1
>
> ### 2. 举例说明两种情况对计算 next 数组值的影响
>
> > ## 例如：<span style="color:blue"><u>A</u></span>BA <span style="color:red">C</span> AB<span style="color:blue"><u>A</u></span> <span style="color:red">B</span>
>
> ### 这里特意用空格隔开方便观察，可以发现相同的字串是<span style="color:red">ABC<span>
>
> ### 接下来继续扫描
>
> ### （1）如果下一个字符仍然<span style="color:blue">匹配</span>（D 和 E，这里举例是不匹配的情况），<span style="color:red">那 next 数组的值就为上一个 j 所指的字符的 next[j] 的值加一<span>
>
> ### <span style="color:blue">解释：由于前后缀是一样的，既有对称性，如果下一位还匹配，那 j 回溯的位置也会加一，即 next[j]+1 这个值对应的位置<span>
>
> ### 代码如下
>
> ```c
> ++k;
> ++j;
> next[j] = k;
> ```
>
> ### （2）如果下一个字符<span style="color:blue">不匹配</span>，那就不能简单的加一了，<span style="color:red">思路就是：找更短的前后缀，看有没有匹配的（因为如果下一个不匹配，再前面已经匹配的前提下是有可能找到更短的共同前后缀）<span>
>
> ### 解释：这里实际上是一个递归的思路
>
> ### >>>对于找更短前后缀的详述
>
> ### (1)首先我们找到了共同的前后缀，但是扫描到下一个字符发现不匹配，在这个前提下，<span style="color:red">已经匹配的前后缀应有这个特点：二者有着共同后缀，</span><span style="color:blue">也就是说后面这部分的后缀等同于前面这部分的后缀<span>
>
> ### (2)既然两部分相等，那直接在左边这部分找共同的前后缀不就好了，<span style="color:red">重点</span>：最后共同的前后缀，意思是—>左边的前缀=左边的后缀（共同的），然而在之前的理解中可以知道左边的后缀和右边的后缀相同，<span style="color:red">即左边的前缀和右边的后缀相同，这就是我们寻找的目标<span>
>
> ### <span style="color:blue">蓝色标注的那部分就是我们要的目标，之后继续往后扫描，如果相同，则可以构成一个更长的前后缀（这个过程即是计算每一个字符在 next 数组中对应的值）<span>
>
> ### 问题延申：如果找到了更短的前后缀后移动下一个字符还是不匹配要怎么办？
>
> ### 那就继续寻找更小的共同前后缀，依次不断重复这个过程，于是就引出了递归的概念
>
> ### 代码如下
>
> ```c
> k=next[k]
> ```
>
> ### 代码解释
>
> ### 首先要理解 next 数组的含义
>
> - ### （1）存储的是遍历当前字符之前的所有字符中最长的公共前后缀长度
> - ### （2）模式串指针在下一次比较时回溯的位置
> - ### 这个位置的特点：当前所指位置之前有相同的前后缀，那便很好理解上面的代码了
>
> ### 代码解释：k 回溯到当前所指位置的 next 数组所存储的值，即意味着找到更短的前缀和第二部分（上面举的例子）的后缀相同

---

# 四、next 数组的优化

## 对于模式串的失配需要进一步分析，如果模式串中后缀失配，而在前面又出现了与之相同的字符，那必然失配，所以不允许出现这种情况（不能允许<span style="color:red">p[j] = p[ next[j]]</span>），需要进行分类讨论

## 代码如下

```c
//优化过后的next 数组求法
void GetNextval(char* p, int next[])
{
	int pLen = strlen(p);
	next[0] = -1;
	int k = -1;
	int j = 0;
	while (j < pLen - 1)
	{
		//p[k]表示前缀，p[j]表示后缀
		if (k == -1 || p[j] == p[k])
		{
			++j;
			++k;
			//较之前next数组求法，改动在下面4行
			if (p[j] != p[k])
				next[j] = k;   //如果不相同，和之前一样
			else
		//因为不能出现p[j] = p[ next[j]]，所以当出现时需要继续递归，之前设了 next[j]=k

                //递归：next[j]=next[next[j]]
                //联立：next[j]=k，即可得到下面的式子

                //递归寻找个更小的前后缀（是因为会导致失配，所以不继续按之前一样回溯到表达式的位置，需要递归寻找一个合适的位置，然后赋值（计算next数组的值））
				next[j] = next[k];
		}
		else
		{
			k = next[k];
		}
	}
}
```

## 说明：从代码的逻辑角度分析，if 的条件是不允许出现 p[j] = p[next[j]]（之前设了 next[j]=k），那 else 的条件就是出现了相等，那相等了不就需要继续进行递归，那代码也很容易理解了

---
