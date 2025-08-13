# 导入包
import urllib.request

# 定义url
url = "https://www.baidu.com"

# 模拟浏览器发送请求
response = urllib.request.urlopen(url)

# 一个类型
# print(type(response)) # <class 'http.client.HTTPResponse'>

# 八个方法

"""
decode()方法：解码，将字节形式的二进制数据转为字符串
"""
# content = response.read().decode()
# print(content)

"""
encode()方法：反解码，字符串数据转为字节形式的二进制数据
"""
# content = response.read().decode().encode()
# print(content)

"""
read("读取的字节数")：以字节的形式返回二进制数据（b'（二进制数据）'）
"""

# content = response.read()
# content = response.read(1)
# print(content)

"""
readline() 方法：只读取一行
"""
# content = response.readline()
# print(content)

"""
readlines()方法：一行一行读取，直至结束
"""
# content = response.readlines()
# print(content)

"""
getcode()方法：返回状态码，查看执行状态（200代表执行成功）
"""
# print(response.getcode())

"""
geturl()方法：返回url
"""
# print(response.geturl())

"""
getheaders()：获取headers
"""
# print(response.getheaders())