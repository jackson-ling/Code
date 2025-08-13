import urllib.request

"""
下载内容：urlretrieve("指定下载内容的文件名","文件存放路径") 方法
"""

# 下载网页
# url_page = "https://www.baidu.com"
#
# urllib.request.urlretrieve(url_page,"./download/baidu.html")

# 下载图片(赋值图片地址)
# url_photo = "https://inews.gtimg.com/om_bt/OXp0VXNiDzc2sx2CbzrnQapRtm7twZesN4jitAz_K2C4MAA/641"
#
# urllib.request.urlretrieve(url_photo,"./download/photo.png")

# 下载视频（打开 F12 检查，查看视频的链接）
url_video = "https://vdept3.bdstatic.com/mda-pj9hb85sazigtnks/360p/h264/1696940049033432701/mda-pj9hb85sazigtnks.mp4?v_from_s=hkapp-haokan-hna&auth_key=1753870140-0-0-8e687f64e25cf26b2321788e6f2bb313&bcevod_channel=searchbox_feed&pd=1&cr=0&cd=0&pt=3&logid=0540262567&vid=17208501836220176090&klogid=0540262567&abtest="

urllib.request.urlretrieve(url_video,"./download/video.mp4")


