# 导入包
import urllib.request

# 定义url
url = "https://www.baidu.com"

# 模拟浏览器发送请求
response = urllib.request.urlopen(url)

# 获取响应中的页面源码
"""
read()方法：返回字节形式的二进制数据
decode("字符集")方法；解码（二进制 --> 字符串）
"""
content = response.read().decode("utf-8")

# 打印内容
print(content)

