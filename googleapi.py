from googleapiclient.discovery import build

API_KEY = "AIzaSyCJLui_HD-THLZkEmBmWvfsj1GLjCx_M9A"
CSE_ID = "008171140621555576608:krdkbofgvt8"

service = build("customsearch", "v1", developerKey=API_KEY)

def getGoogleResults(query):
    res = service.cse().list(q=query, cx=CSE_ID).execute()
    items = res['items']
    soId = []
    for item in items:
        if item['displayLink'] == u'stackoverflow.com':
            url = item['link'].split('/')
            if url[3] == u'questions' and url[4].isdigit():
                soId.append(url[4])
    return soId
