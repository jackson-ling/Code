import urllib.request

url = "https://www.baidu.com"

# 打开 F12，找到网络，复制 ua
headers={
    'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36 Edg/138.0.0.0'
}

# 定制 Request 对象
request = urllib.request.Request(url = url,headers=headers)

# 发送请求(Request 对象)
response = urllib.request.urlopen(request)

# 解码
content = response.read().decode("utf-8")

# 打印内容
print(content)