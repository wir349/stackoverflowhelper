from googleapiclient.discovery import build

API_KEY = "AIzaSyCplGtbbbEW27P8UQVCgf4xXtr4ou044og"
CSE_ID = "015349106293630255420:l3euh1pkngq"

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
