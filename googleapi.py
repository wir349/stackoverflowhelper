import pprint
from googleapiclient.discovery import build

API_KEY = "AIzaSyCJLui_HD-THLZkEmBmWvfsj1GLjCx_M9A"
CSE_ID = "008171140621555576608:krdkbofgvt8"

service = build("customsearch", "v1", developerKey=API_KEY)

res = service.cse().list(q='something', cx=CSE_ID).execute()
items = res['items']
for item in items:
    print("-------**-------" + item + "-------**-------" )
    pprint.pprint(item)
