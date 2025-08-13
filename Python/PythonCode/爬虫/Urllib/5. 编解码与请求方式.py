import urllib.request
import urllib.parse # 用于编解码

# url = 'https://www.baidu.com/s?wd='
#
# # quote()方法：中文转unicode编码
# name = urllib.parse.quote("周杰伦")
#
# # 利用解码拼接url
# url = url + name
# print(url)
#
# # encode()方法：处理多个参数转换问题，需要定义data字典
# data = {
#     'wd':'周杰伦',
#     'sex':'男',
#     'location':'中国台湾省'
# }
#
# a = urllib.parse.urlencode(data)
# print(a)



# 案例：爬取网页（get请求）
#
# url = 'https://www.baidu.com/s?'
#
# data = {
#     'wd':'周杰伦',
#     'sex':'男',
#     'location':'中国台湾省'
# }
#
# # url 拼接
# new_data = urllib.parse.urlencode(data)
# url = url + new_data
#
# # 获取ua
# headers = {
#     'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36 Edg/138.0.0.0'
# }
#
# # 定制request对象
# request = urllib.request.Request(url = url,headers=headers)
#
# # 发送请求
# response = urllib.request.urlopen(request)
#
# # 解码
# content = response.read().decode("utf-8")
#
# # 打印内容
# print(content)

# 案例；post请求爬取百度翻译

url = "https://fanyi.baidu.com/sug"

headers={
    'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36 Edg/138.0.0.0'
}

data = {
    'kw':'spider%0A'
}

# post 请求，数据解码后需要调用 encode() 方法
new_data = urllib.parse.urlencode(data).encode("utf-8")

request = urllib.request.Request(url=url,data=new_data,headers=headers)

response = urllib.request.urlopen(request)

content = response.read().decode("utf-8")

import json

obj = json.loads(content)
print(obj)